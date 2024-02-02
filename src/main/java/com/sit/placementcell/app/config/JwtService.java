package com.sit.placementcell.app.config;

import com.sit.placementcell.app.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("deprecation")
@Service
public class JwtService {

//    @Value("${application.security.jwt.secret-key}")
    private String secretkey = "D332B82C993D6CD94BE894B1BFF3A81C9DDFA99E4063CCD9D21E690E86DA2B195B52DEAC134B77D7B0F418CAA1C020759F25444697C83DE077D2261FE18E136A1E6828D30B8408D10988D5CAB0832C1E13C19098DC75E764168C8030721BE338D1F3FC3FC6209572E8E9D5F0F18E48D9929845FBEF320B1FAA3683D54C0935F8";

//    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration = 24*60*60*1000;

//    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshJwtExpiration = 604800000;

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public String generateToken(UserDetails userDetails){

        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken (Map<String, Object> extraClaims,UserDetails userDetails) {
        extraClaims.put("role",((User) userDetails).getRole().name());
        return buildToken(extraClaims,userDetails,jwtExpiration);
    }

    public String generateRefreshToken (UserDetails userDetails) {
        return buildToken(new HashMap<>(),userDetails,refreshJwtExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}