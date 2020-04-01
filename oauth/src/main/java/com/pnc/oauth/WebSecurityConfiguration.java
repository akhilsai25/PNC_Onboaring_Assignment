package com.pnc.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//package com.pnc.oauth;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
////    @Bean
////    @Override
////    public UserDetailsService userDetailsService () {
//////        UserDetails user = User.builder().Username("user").Password(passwordEncoder().Encoder("secret")).
//////                roles ("USER"). build ();
//////        UserDetails userAdmin = User.builder (). Username ("admin"). Password (passwordEncoder (). Encode ("secret")).
//////                roles ("ADMIN"). build ();
//////        return new InMemoryUserDetailsManager(user, userAdmin);
////
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("user")
////                        .password("password")
////                        .roles("USER")
////                        .build();
////
////        UserDetails userAdmin =
////                User.withDefaultPasswordEncoder()
////                        .username("admin")
////                        .password("secret")
////                        .roles("ADMIN")
////                        .build();
////
////        return new InMemoryUserDetailsManager(user, userAdmin);
////    }
//
////    @Autowired
////    PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("$2a$06$vVzyJ6B6hCU3CQtSSvHZo.XvrSrk722UyXIT5Aw7f9ljPsrFROEkm").roles("ADMIN").and()
//                .withUser("admin").password("$2a$06$vVzyJ6B6hCU3CQtSSvHZo.XvrSrk722UyXIT5Aw7f9ljPsrFROEkm").roles("USER");
//    }
//
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder () {
//        return new BCryptPasswordEncoder();
//    }
}