package cn.jeeweb.sso.utils;

import cn.jeeweb.sso.config.SsoJwtProperties;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by hexin on 2018/9/14.
 */
@Component
public class SsoJwtUtil {
    @Autowired
    private SsoJwtProperties ssoJwtProperties;

    /**
     * 生成token
     * @param user
     * @param claims
     * @return
     */
    public String generateToken(String user, Map<String,Object>... claims){
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + ssoJwtProperties.getExpiration() * 1000);
        JwtBuilder jwtBuilder = Jwts.builder();
        if(claims != null && claims.length > 0){
            jwtBuilder.setClaims(claims[0]);
        }
        jwtBuilder.setExpiration(expirationDate);
        jwtBuilder.setIssuedAt(now);
        jwtBuilder.setSubject(user);
        jwtBuilder.signWith(SignatureAlgorithm.HS256,ssoJwtProperties.getSecret());
        return jwtBuilder.compact();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public String parseToken(String token){
        return Jwts.parser().setSigningKey(ssoJwtProperties.getSecret()).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * token 是否过期
     * @param token
     * @return false:未过期，true:过期
     */
    public Boolean isTokenExpiration(String token){
        Date expiration = Jwts.parser().setSigningKey(ssoJwtProperties.getSecret()).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}
