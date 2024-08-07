package com.example.Testing.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity

public class SecurityConfig {

        @Bean
        public UserDetailsService userDetailsService() {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

            UserDetails user = User.withUsername("user")
                    .password(encoder.encode("user"))
                    .roles("USER")
                    .build();

            UserDetails admin = User.withUsername("admin")
                    .password(encoder.encode("admin"))
                    .roles("ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(user, admin);
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(authorizeRequests ->
                            authorizeRequests
                                    .requestMatchers("/login").permitAll()
                                    .anyRequest().authenticated()
                    )
                    .formLogin(formLogin ->
                            formLogin
                                    .loginPage("/login")
                                    .defaultSuccessUrl("/all", true) // Redirect to home page after successful login
                                    .permitAll()
                    )
                    .logout(logout ->
                            logout
                                    .logoutUrl("/logout")
                                    .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                                    .permitAll()
                    )
                    .csrf(AbstractHttpConfigurer::disable); // Disable CSRF for simplicity in this example; enable in production

            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    }



