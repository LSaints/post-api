package br.com.lsant.postApi.core.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;

@Component
public class JWTUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        SecretKey key = getKeyBySecret();
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public Boolean isValidToken(String token) {
        Claims claims = getClaims(token);
        if(Objects.nonNull(claims)) {
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if(Objects.nonNull(username) && Objects.nonNull(expirationDate) && now.before(expirationDate))
                return true;
        }
        return false;
    }

    private Claims getClaims(String token) {
        SecretKey key = getKeyBySecret();
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (Objects.nonNull(claims))
            return claims.getSubject();
        return null;
    }


    private SecretKey getKeyBySecret() {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return key;
    }
}
