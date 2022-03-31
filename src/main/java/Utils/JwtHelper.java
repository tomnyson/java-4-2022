/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author tomnyson
 */
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtHelper {

    static final long EXPIRATIONTIME = 86_400_000; // 1 day
    static final String SECRET = "secret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static String generateJwt(String userId) {
        Map<String, Object> map = new HashMap<>();
        Date date = new Date();
        long t = date.getTime();
        Date expirationTime = new Date(t + 60 * 5000l);
        String token = Jwts.builder().setSubject("adam")
                .setExpiration(expirationTime)
                .setIssuer("info@wstutorial.com")
                .claim("role", "admin")
                .claim("id", 1)
                // HMAC using SHA-512  and 12345678 base64 encoded
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return token;
    }

    public static Boolean decodeJWT(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("claims"+claims.get("role", String.class));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
