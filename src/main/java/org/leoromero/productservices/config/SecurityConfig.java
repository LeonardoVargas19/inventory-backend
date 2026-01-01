package org.leoromero.productservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                // 1. Desactivar CSRF (Por ahora, para APIs REST simples es estándar desactivarlo)
                .csrf(csrf -> csrf.disable())
                // 2. Configurar las reglas de quién entra
                .authorizeHttpRequests(aut -> aut
                                // Permitir que CUALQUIERA (permitAll) haga GET a /api/product
                                .requestMatchers(HttpMethod.GET, "/api/product").permitAll()
                                // Para TODO lo demás (POST, DELETE, etc.), pedir contraseña
                                .requestMatchers(HttpMethod.POST, "/api/product/").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/product/stock").permitAll()
                                .requestMatchers("/error").permitAll()
                                .anyRequest().authenticated()

                        // 3. Activar la autenticación básica (Usuario y Pass)
                ).httpBasic(Customizer.withDefaults())
                .build();

    }
}
