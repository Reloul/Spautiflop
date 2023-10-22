package com.project.jee.spautiflop.service;

import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonWebTokenService {

  @Value("${jwt.algorithm.key}")
  private String algorithmKey;
  @Value("${jwt.issuer}")
  private String issuer;
  @Value("${jwt.expiryInSecs}")
  private long expirationTimeInSecs;
  private Algorithm algorithm;
  public static final String USERNAME_KEY = "USERNAME";

  @PostConstruct
  public void PostConstruct() {
    algorithm = Algorithm.HMAC256(algorithmKey);
  }

  public String generateToken(String pseudo) {
    return com.auth0.jwt.JWT.create()
      .withIssuer(issuer)
      .withClaim(USERNAME_KEY, pseudo)
      .withExpiresAt(new java.util.Date(System.currentTimeMillis() + expirationTimeInSecs * 1000))
      .sign(algorithm);
  }
}
