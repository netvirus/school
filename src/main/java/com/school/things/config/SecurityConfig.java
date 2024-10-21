package com.school.things.config;

import com.school.things.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Отключаем CSRF для простоты
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()  // Разрешить доступ к публичным URL
                        .anyRequest().authenticated()  // Все остальные запросы требуют аутентификации
                )
                .addFilterBefore(jwtAuthenticationFilter, CorsFilter.class);  // Добавляем фильтр для JWT перед CORS

        return http.build();
    }
}
