package com.smart.result.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //crsf
//        httpSecurity.csrf(e->e.disable());
        //cors
//        httpSecurity.cors(e->e.disable());


        // pages /apis/urls
        httpSecurity.authorizeHttpRequests(request->
//                request.requestMatchers("/login","/about","/").permitAll().anyRequest().authenticated()
                request.requestMatchers("/results/add").authenticated().anyRequest().permitAll()
        )
                .formLogin(form->
                        form.loginPage("/login")

                                .loginProcessingUrl("/process-login")
                                .defaultSuccessUrl("/results/add",true)
                                .permitAll()
                        )
                .logout(
                        logout->
                                logout.logoutUrl("/logout")
                                        .logoutSuccessUrl("/login?logout=true")
                                        .invalidateHttpSession(true)
                                        .clearAuthentication(true)
                                        .permitAll()
                );
        return httpSecurity.build();
    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//     UserDetails user1=  User.builder().username("vikash").password("{noop}vikash123").roles("USER").build();
//        UserDetails user2=  User.builder().username("akash").password("{noop}akash123").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
}
