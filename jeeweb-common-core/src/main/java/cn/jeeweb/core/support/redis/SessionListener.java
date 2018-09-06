package cn.jeeweb.core.support.redis;

import cn.jeeweb.modules.sys.Constants;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by hexin on 2018/9/4.
 */
public class SessionListener implements org.apache.shiro.session.SessionListener  {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void onStart(Session session) {
        redisTemplate.opsForSet().add(Constants.ALLUSER_NUMBER, session.getId());
    }

    @Override
    public void onStop(Session session) {
        redisTemplate.opsForSet().remove(Constants.ALLUSER_NUMBER, session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        onStop(session);
    }

    public Integer getAllUserNumber() {
        return redisTemplate.opsForSet().size(Constants.ALLUSER_NUMBER).intValue();
    }
}
