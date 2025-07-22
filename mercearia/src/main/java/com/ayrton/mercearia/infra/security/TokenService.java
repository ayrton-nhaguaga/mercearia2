package com.ayrton.mercearia.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ayrton.mercearia.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    // metodo para gerar tokens
    public String generateToken(User user){
        // ALgorimto de geracao de token HMAC256
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);// recebe como parametro uma secret que torna o hash exclusivo
            String token = JWT.create()
                    .withIssuer("mecearia-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return  token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while generating token ", exception);
        }
    }

    // metodo para validar o token
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("mercearia-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }


    // tempo de expiracao do token 2 horas no time zone de Mocambique "+02:00"
    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("+02:00"));
    }
}

