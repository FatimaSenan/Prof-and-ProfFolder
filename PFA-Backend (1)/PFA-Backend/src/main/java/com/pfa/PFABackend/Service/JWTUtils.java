package com.pfa.PFABackend.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JWTUtils {
    private SecretKey Key;
    private static final long EXPIRATION_TIME = 86400000;//24hours

    public JWTUtils(){
        String secretString = "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";
        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
        this.Key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();
    }

    public  String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();
    }

    public  String extractUsername(String token){
        return  extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        return claimsTFunction.apply(Jwts.parser().verifyWith(Key).build().parseSignedClaims(token).getPayload());
    }

    public  boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public  boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }

}
