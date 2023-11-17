//package com.gmc_team.e_commerse_platform.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class Security {
//
//    @Bean
//    SecurityFilterChain HttpfilterChain(HttpSecurity http) throws Exception {
//        http.
//                csrf(csrf->csrf.disable())
//                .authorizeHttpRequests(auth->auth.anyRequest().permitAll())
//                        .build();
//
//
//        return http.build();
//    }
//}
