package com.example.demo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableCaching
public class Config {
//    @Bean
//    HttpMessageConverter httpMessageConverter() {
////        MappingJackson2HttpMessageConverter: لتحويل الكائنات إلى JSON باستخدام Jackson.
////        GsonHttpMessageConverter: لتحويل الكائنات إلى JSON باستخدام Gson.
////        Jaxb2RootElementHttpMessageConverter: لتحويل الكائنات إلى XML باستخدام JAXB.
////        StringHttpMessageConverter: لتحويل النصوص (مثل String) بين Java و HTTP.
//        return new MappingJackson2HttpMessageConverter();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //WebSecurityConfigurerAdapter spring <6
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()  // السماح بالوصول للموارد العامة
                        .anyRequest().authenticated()              // تتطلب المصادقة لأي طلب آخر
                )
                .formLogin(withDefaults())
                //.loginpage("/log").permitAll();
                .logout(withDefaults());
//        .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true);
        // تمكين تسجيل الخروج الافتراضي
        http.cors(cors->
                cors.configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.addAllowedOrigin("*");
                    configuration.addAllowedHeader("*");
                    configuration.addAllowedMethod("*");
                    return configuration;
                        }
                ));

        return http.build();
    }
    //1. Cross-Site Request Forgery (CSRF)
    //Cross-Origin Resource Sharing (CORS)
   // 3. Content Security Policy (CSP) spring <6

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() throws Exception {
        return new InMemoryUserDetailsManager(
                User.withUsername("mostafa")
                        .password(passwordEncoder().encode("1234"))
                        .roles("ADMIN").build()
        );
    }


//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//                .authorizeExchange(exchanges -> exchanges
//                        .pathMatchers("/").permitAll()
//                        .anyExchange().authenticated()
//                )
//        .formLogin(withDefaults())
////                //.loginpage("/log").permitAll();
//         .logout(withDefaults())
//                .build();
//    }


}
