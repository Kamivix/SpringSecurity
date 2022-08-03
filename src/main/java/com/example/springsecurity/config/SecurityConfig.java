package com.example.springsecurity.config;

import com.example.springsecurity.controller.UserController;
import com.example.springsecurity.permission.Perm;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http


                .csrf().disable()
                .httpBasic();
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/user" )
//                .hasAnyRole("USER","ADMIN")
//                .antMatchers("/api/admin" )
//                .hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
        return http.build();
    }




    @Bean
    protected UserDetailsService userDetailsService() {
//        UserDetails user=
//                User.builder()
//                        .username("user")
//                        .password(encoder().encode("user"))
//                        .roles("USER")
//                        .build();
//UserDetails admin=
//        User.builder()
//                .username("admin")
//                .password(encoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(
//                user,
//                admin
//        );


        UserDetails user =
                User.builder()
                        .username("user")
                        .password(encoder().encode("user"))
                        .authorities(Perm.USER_EDIT.name(),Perm.USER_READ.name())
                        .build();

        UserDetails admin=
        User.builder()
                .username("admin")
                .password(encoder().encode("admin"))
                .authorities(Perm.ADMIN.name())
                .build();

        UserDetails spectator=
                User.builder()
                        .username("spectator")
                        .password(encoder().encode("spectator"))
                        .authorities(Perm.USER_EDIT.name())
                        .build();

        return new InMemoryUserDetailsManager(
                user,
                admin,
                spectator
        );

    }




    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(10);
    }
}
