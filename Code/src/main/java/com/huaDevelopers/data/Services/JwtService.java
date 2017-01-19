package com.huaDevelopers.data.Services;

import static java.time.ZoneOffset.UTC;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huaDevelopers.data.Entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {

    private static final String ISSUER = "com.huaDevelopers";
    private SecretKeyProvider secretKeyProvider;

    public JwtService() {
        this(null);
    }

    @Autowired
    public JwtService(SecretKeyProvider secretKeyProvider) {
        this.secretKeyProvider = secretKeyProvider;
    }

    public String tokenFor(User user) throws IOException, URISyntaxException {
        String secretKey = "testKEY";

        
        Date expiration = Date.from(LocalDateTime.now().plusHours(2).toInstant(UTC));
        return Jwts.builder()
                .setSubject(user.getLastName())
                .setId(String.valueOf(user.getUserId()))
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
    
    public User parseToken(String token) throws Exception {
    	 String secretKey = "testKEY";
    	System.out.println("------INDIDE  parseToken");
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("------BODY " + body);
            User u = new User();
            u.setLastName(body.getSubject());
            u.setUserId(Long.parseLong((String) body.getId()));
            
            System.out.println("------>>>" + u.getFirstName());

            return u;

        } catch (JwtException | ClassCastException e) {
        	System.out.println("------ inside jwt exception");
        	return null;
        }
    }
}
