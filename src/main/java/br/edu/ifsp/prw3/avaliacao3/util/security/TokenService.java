package br.edu.ifsp.prw3.avaliacao3.util.security;

import br.edu.ifsp.prw3.avaliacao3.model.UserMechanic;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String generateToken(UserMechanic userMechanic){
        try {
            var algoritmo = Algorithm.HMAC256("12345678");
            String token = JWT.create()
                    .withIssuer("MechanicProject")
                    .withSubject(userMechanic.getLogin())
                    .withExpiresAt(expDate())
                    .sign(algoritmo);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }
    private Instant expDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    }
}
