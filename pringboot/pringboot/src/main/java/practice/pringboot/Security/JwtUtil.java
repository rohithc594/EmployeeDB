package practice.pringboot.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private String SECRET_KEY =  "mysecretkeymysecretkeymysecretkey";

    public String generateToken(String username){//generating token
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()+1000*10)
                )
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET_KEY
                )
                .compact();

    }

    public String extractUsername(String token){//check the exsting token
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token){// check the token still valied or not
        Date expirationDate = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        return expirationDate.before(new Date());
    }

    public boolean validateToken(String token ,String username){
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }
}
