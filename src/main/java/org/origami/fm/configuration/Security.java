package org.origami.fm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Публичные страницы (доступны всем)
                        .requestMatchers("/css/**", "/css/*.css", "/js/**", "/images/**", "/webjars/**", "/static/**").permitAll()
                        .requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/register", "/about","/login","/").permitAll()

                        // Страницы только для аутентифицированных пользователей
                        .requestMatchers("/profile", "/profile/**","/user/**").hasAnyRole("USER", "ADMIN")

                        // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated()
//                                .anyRequest().permitAll()
                )
                // 2. НАСТРОЙКА ФОРМЫ ЛОГИНА
                .formLogin(form -> form
                        .loginPage("/login")          // Страница логина
                        .loginProcessingUrl("/login") // URL для обработки формы
                        .defaultSuccessUrl("/profile", true) // Куда перенаправлять после успешного входа
                        .failureUrl("/login?error=true")     // Куда перенаправлять при ошибке
                        .permitAll()                         // Разрешить доступ всем к странице логина
                )


                // 4. ДОПОЛНИТЕЛЬНЫЕ НАСТРОЙКИ
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedPage("/access-denied")  // Страница при отказе в доступе
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
