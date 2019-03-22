package com.company.shop.sys.service.utils;

import com.company.shop.sys.service.properties.JwtConfigProperties;
import com.company.shop.sys.service.security.userdetails.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hexin on 2018/11/26.
 */
@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -1L;
    @Autowired
    private JwtConfigProperties jwtConfigProperties;

    public String getUserNameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
//            username = claims.getSubject();
            username = (String) claims.get(jwtConfigProperties.getClaim_key_username());
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(jwtConfigProperties.getClaim_key_createdate()));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtConfigProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + jwtConfigProperties.getExpiration() * 1000);
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(jwtConfigProperties.getClaim_key_username(), userDetails.getUsername());//username
        claims.put(jwtConfigProperties.getClaim_key_createdate(), new Date());//时间戳
        return generateToken(claims);
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(jwtConfigProperties.getClaim_key_username(), username);//username
        claims.put(jwtConfigProperties.getClaim_key_createdate(), new Date());//时间戳
        return generateToken(claims);
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, jwtConfigProperties.getSecret())
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(jwtConfigProperties.getClaim_key_createdate(), new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUserNameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
