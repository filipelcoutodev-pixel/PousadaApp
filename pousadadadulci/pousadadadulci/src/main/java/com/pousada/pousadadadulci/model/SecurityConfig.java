/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pousada.pousadadadulci.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author FilipeLuizCouto
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Criptografa a senha com BCrypt
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Deixa a página inicial, imagens, CSS e cadastro 100% abertos para qualquer visitante
                .requestMatchers("/", "/index", "/cadastro", "/css/**", "/js/**", "/*.css", "/*.png").permitAll() 
                // Qualquer outra rota (como painel administrativo ou páginas restritas) precisará de login
                .anyRequest().authenticated() 
            )
            .formLogin(form -> form
                .loginPage("/login") // Nossa tela customizada de login
                .defaultSuccessUrl("/", true) // Após logar com sucesso, volta para a página inicial
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/?logout")
                .permitAll()
            );

        return http.build();
    }
}
