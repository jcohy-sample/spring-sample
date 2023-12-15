package com.relive.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestOperations;

import java.time.Duration;

import static org.springframework.security.oauth2.jose.jws.SignatureAlgorithm.RS256;

/**
 * @author: ReLive
 * @date: 2022/8/16 12:38
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/resource/article").hasAuthority("SCOPE_message.read")
                .anyRequest().authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return http.build();
    }


    /**
     * {@link JwtDecoder} with Redis cache
     *
     * @param properties
     * @param restOperations
     * @param cacheManager
     * @return
     */
    @Bean
    JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties, RestOperations restOperations, CacheManager cacheManager) {
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri())
                .restOperations(restOperations)
                .cache(cacheManager.getCache("jwks"))
                .jwsAlgorithms(algorithms -> {
                    algorithms.add(RS256);
                }).build();

        //custom timestamp validation
        OAuth2TokenValidator<Jwt> withClockSkew = new DelegatingOAuth2TokenValidator<>(
                new JwtTimestampValidator(Duration.ofSeconds(60)));

        jwtDecoder.setJwtValidator(withClockSkew);

        return jwtDecoder;
    }

    /**
     * RestOperations set connection timeout 60s, read timeout 60s
     * <p>
     * In some cases you can set @LoadBalanced
     *
     * @param builder
     * @return
     */
    @Bean
    RestOperations restOperations(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(60))
                .setReadTimeout(Duration.ofSeconds(60))
                .build();
    }
}
