package cn.jeeweb.core.support.redis;

import cn.jeeweb.core.utils.ArrayUtils;
import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.modules.sys.Constants;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by hexin on 2018/9/4.
 */
public class RedisSessionDAO extends AbstractSessionDAO {
    private static final int EXPIRE_TIME = 600;
    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        byte[] sessionKey = buildRedisSessionKey(sessionId);
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        RedisConnection conn = null;
        try {
            conn = RedisConnectionUtils.getConnection(factory);
            byte[] value = conn.get(sessionKey);
            if (value == null) {
                return null;
            }
            Session session = deserialize(value, SimpleSession.class);
            return session;
        } finally {
            RedisConnectionUtils.releaseConnection(conn, factory);
        }
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session != null) {
            Serializable id = session.getId();
            if (id != null) {
                RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
                RedisConnection conn = null;
                try {
                    conn = RedisConnectionUtils.getConnection(factory);
                    conn.del(buildRedisSessionKey(id));
                } finally {
                    RedisConnectionUtils.releaseConnection(conn, factory);
                }
            }
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        List<Session> list = ArrayUtils.newArrayList();
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        RedisConnection conn = null;
        try {
            conn = RedisConnectionUtils.getConnection(factory);
            Set<byte[]> set = conn.keys((Constants.REDIS_SHIRO_SESSION + "*").getBytes());
            for (byte[] key : set) {
                list.add(deserialize(conn.get(key), SimpleSession.class));
            }
        } finally {
            RedisConnectionUtils.releaseConnection(conn, factory);
        }
        return list;
    }

    public void delete(Serializable sessionId) {
        if (sessionId != null) {
            byte[] sessionKey = buildRedisSessionKey(sessionId);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection conn = null;
            try {
                conn = RedisConnectionUtils.getConnection(factory);
                conn.del(sessionKey);
            } finally {
                RedisConnectionUtils.releaseConnection(conn, factory);
            }
        }
    }

    private void saveSession(Session session) {
        if (session == null || session.getId() == null) {
            throw new UnknownSessionException("session is empty");
        }
        byte[] sessionKey = buildRedisSessionKey(session.getId());
        int sessionTimeOut = new PropertiesUtil("redis.properties").getInt("session.maxInactiveInterval", EXPIRE_TIME);
        byte[] value = serialize(session);
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        RedisConnection conn = null;
        try {
            conn = RedisConnectionUtils.getConnection(factory);
            conn.set(sessionKey, value, Expiration.seconds(sessionTimeOut), RedisStringCommands.SetOption.UPSERT);
        } finally {
            RedisConnectionUtils.releaseConnection(conn, factory);
        }
    }

    private byte[] buildRedisSessionKey(Serializable sessionId) {
        return (Constants.REDIS_SHIRO_SESSION + sessionId).getBytes();
    }

    public static final <T> T deserialize(byte[] bytes, Class<T> cls) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
            return (T)ois.readObject();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
            }
            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public static final byte[] serialize(Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
            }
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
