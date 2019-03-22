package com.company.manerger.sys.common.security.shiro.session;

import com.company.manerger.sys.common.utils.DateUtils;
import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.google.common.collect.Sets;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 自定义授权会话管理类
 */
public class RedisSessionDAO extends AbstractSessionDAO implements SessionDAO {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String sessionKeyPrefix = "gzskjt_session_";

    private RedisTemplate<Object, Object> redisTemplate;

    public RedisSessionDAO(){

    }
    public RedisSessionDAO(RedisTemplate<Object, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            return;
        }

        HttpServletRequest request = ServletUtils.getRequest();
        try {
            // 获取登录者编号
            PrincipalCollection pc = (PrincipalCollection) session
                    .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            String principalId = pc != null ? pc.getPrimaryPrincipal().toString() : StringUtils.EMPTY;

            redisTemplate.opsForHash().put(sessionKeyPrefix, session.getId().toString(),
                    principalId + "|" + session.getTimeout() + "|" + session.getLastAccessTime().getTime());
            redisTemplate.opsForValue().set(sessionKeyPrefix + session.getId(), session);

            // 设置超期时间
            int timeoutSeconds = (int) (session.getTimeout() / 1000);
            redisTemplate.expire(sessionKeyPrefix + session.getId(), timeoutSeconds, TimeUnit.SECONDS);
            redisTemplate.expire(sessionKeyPrefix, timeoutSeconds, TimeUnit.SECONDS);
            logger.debug("update {} {}", session.getId(), request != null ? request.getRequestURI() : "");
        } catch (Exception e) {
            logger.error("update {} {}", session.getId(), request != null ? request.getRequestURI() : "", e);
        }
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        try {
            redisTemplate.opsForHash().delete(sessionKeyPrefix, session.getId().toString());
            redisTemplate.delete(sessionKeyPrefix + session.getId());
            logger.debug("delete {} ", session.getId());
        } catch (Exception e) {
            logger.error("delete {} ", session.getId(), e);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return getActiveSessions(true);
    }

    /**
     * 获取活动会话
     *
     * @param includeLeave
     *            是否包括离线（最后访问时间大于3分钟为离线会话）
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions(boolean includeLeave) {
        return getActiveSessions(includeLeave, null, null);
    }

    /**
     * 获取活动会话
     *
     * @param includeLeave
     *            是否包括离线（最后访问时间大于3分钟为离线会话）
     * @param principal
     *            根据登录者对象获取活动会话
     * @param filterSession
     *            不为空，则过滤掉（不包含）这个会话。
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions(boolean includeLeave, Object principal, Session filterSession) {
        Set<Session> sessions = Sets.newHashSet();
        try {
            Map<Object, Object> map = redisTemplate.opsForHash().entries(sessionKeyPrefix);
            for (Map.Entry<Object, Object> e : map.entrySet()) {
                String key =(String)e.getKey();
                String value = (String)e.getValue();
                if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                    String[] ss = StringUtils.split(value, "|");
                    if (ss != null && ss.length == 3) {
                        SimpleSession session = (SimpleSession) redisTemplate.opsForValue().get(sessionKeyPrefix + key);
                        session.setId(key);
                        session.setAttribute("principalId", ss[0]);
                        session.setTimeout(Long.valueOf(ss[1]));
                        session.setLastAccessTime(new Date(Long.valueOf(ss[2])));
                        try {
                            // 验证SESSION
                            session.validate();
                            boolean isActiveSession = false;
                            // 不包括离线并符合最后访问时间小于等于3分钟条件。
                            if (includeLeave || DateUtils.pastMinutes(session.getLastAccessTime()) <= 3) {
                                isActiveSession = true;
                            }
                            // 符合登陆者条件。
                            if (principal != null) {
                                PrincipalCollection pc = (PrincipalCollection) session
                                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                                if (principal.toString()
                                        .equals(pc != null ? pc.getPrimaryPrincipal().toString() : StringUtils.EMPTY)) {
                                    isActiveSession = true;
                                }
                            }
                            // 过滤掉的SESSION
                            if (filterSession != null && filterSession.getId().equals(session.getId())) {
                                isActiveSession = false;
                            }
                            if (isActiveSession) {
                                sessions.add(session);
                            }
                        }
                        // SESSION验证失败
                        catch (Exception e2) {
                            redisTemplate.opsForHash().delete(sessionKeyPrefix, e.getKey());
                        }
                    }
                    // 存储的SESSION不符合规则
                    else {
                        redisTemplate.opsForHash().delete(sessionKeyPrefix, e.getKey());
                    }
                }
                // 存储的SESSION无Value
                else if (StringUtils.isNotBlank(key)) {
                    redisTemplate.opsForHash().delete(sessionKeyPrefix,key);
                }
            }
            logger.info("getActiveSessions size: {} ", sessions.size());
        } catch (Exception e) {
            logger.error("getActiveSessions", e);
        }
        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.update(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session s = null;
        HttpServletRequest request = ServletUtils.getRequest();
        if (request != null) {
            s = (Session) request.getAttribute("session_" + sessionId);
        }
        if (s != null) {
            return s;
        }
        Session session = null;
        try {
            session = (Session) redisTemplate.opsForValue().get(sessionKeyPrefix + sessionId);
            logger.debug("doReadSession {} {}", sessionId, request != null ? request.getRequestURI() : "");
        } catch (Exception e) {
            logger.error("doReadSession {} {}", sessionId, request != null ? request.getRequestURI() : "", e);
        }

        if (request != null && session != null) {
            request.setAttribute("session_" + sessionId, session);
        }
        return session;
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        try {
            return super.readSession(sessionId);
        } catch (UnknownSessionException e) {
            return null;
        }
    }

    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String getSessionKeyPrefix() {
        return sessionKeyPrefix;
    }

    public void setSessionKeyPrefix(String sessionKeyPrefix) {
        this.sessionKeyPrefix = sessionKeyPrefix;
    }

}