package br.edu.ifsp.prw3.avaliacao3.util.security;

import br.edu.ifsp.prw3.avaliacao3.model.UserMechanic;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${mechanic.password.generate.token}")
    private String secret;

    public String generateToken(UserMechanic userMechanic){

        try {
            var algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("MechanicProject")
                    .withSubject(userMechanic.getLogin())
                    .withExpiresAt(expDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtv = JWT.require(algorithm).withIssuer("MechanicProject").build();
            return jwtv.verify(tokenJWT).getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido ou expirado!");
        }
    }
    private Instant expDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
