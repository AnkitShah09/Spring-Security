package com.demo.spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/users").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                                .anyRequest().authenticated()
                )
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails regularUser = User
                .builder()
                .username("regularUser")
                .password(getPasswordEncoder().encode("regularUser"))
                .authorities("ROLE_USER")
                .build();

        UserDetails adminUser = User
                .builder()
                .username("adminUser")
                .password(getPasswordEncoder().encode("adminUser"))
                .authorities("ROLE_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(regularUser, adminUser);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
