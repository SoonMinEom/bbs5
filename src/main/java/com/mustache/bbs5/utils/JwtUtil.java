package com.mustache.bbs5.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static Claims openToken(String token, String key) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public static boolean isExpired(String token, String key) {
        return openToken(token,key).getExpiration().before(new Date());
    }

    public static String createToken(String key) {
        Claims claims = Jwts.claims();
        claims.put("userName","soonmin");
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+360000))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
