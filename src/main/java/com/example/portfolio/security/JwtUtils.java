package com.example.portfolio.security;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

//import org.springframework.security.oauth2.*;

@Component
public class JwtUtils {
    @Value("${backend.app.jwtSecret}")
    private String jwtSecret;
    @Value("${backend.app.jwtExpirationMs}")
    private int jwtExpirationMs;
    public String generateJwtToken(String email, Long id ) {
        return Jwts.builder()
                .setId(String.valueOf(id))
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    public String getEmail(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(authToken);
        return true;
        //        catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("JWT token is unsupported: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty: {}", e.getMessage());
//        }
    }
}
