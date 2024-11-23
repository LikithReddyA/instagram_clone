package com.thejeshlikithreddy.instagram.services;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.thejeshlikithreddy.instagram.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Service
public class JWTService {

    @Value("${spring.jwt.secret-key}")
    private String jwtKey;

    @Value("${spring.jwt.issuer}")
    private String jwtIssuer;

    public String jwtTokenGenerator(String userName){
        Instant currentTime = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(currentTime)
                .issuer(jwtIssuer)
                .expiresAt(currentTime.plus(30, ChronoUnit.SECONDS))
                .subject(userName)
                .build();
        NimbusJwtEncoder nimbusJwtEncoder=new NimbusJwtEncoder(new ImmutableSecret<>(jwtKey.getBytes()));
        JwtEncoderParameters params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(),jwtClaimsSet);
        return nimbusJwtEncoder.encode(params).getTokenValue();
    }
}
