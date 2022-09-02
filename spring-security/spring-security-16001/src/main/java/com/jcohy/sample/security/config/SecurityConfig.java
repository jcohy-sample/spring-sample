package com.jcohy.sample.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:18:41
 * @since 2022.04.0
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests((authorize) ->
                authorize
                        .antMatchers("/css/**","/index")
                        .permitAll()
                        .antMatchers("/user/**")
                        .hasRole("USER"))
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .failureUrl("/login-error"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails userDetails = User
                .withUsername("user")
                .password("password")
                .roles("USER")
                .passwordEncoder(encoder::encode)
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
