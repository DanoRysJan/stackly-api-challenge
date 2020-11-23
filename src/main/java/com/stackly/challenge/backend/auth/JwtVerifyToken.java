package com.stackly.challenge.backend.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtVerifyToken {
    public int verifyToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("TopSecretMeLaPelan");
        JWTVerifier verifier = JWT.require(algorithm).withClaimPresence("userId").build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("userId").asInt();
    }
}
