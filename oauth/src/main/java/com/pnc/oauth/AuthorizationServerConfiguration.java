package com.pnc.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {



    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public void configure (ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory ()
//                .withClient ("client")
//                .authorizedGrantTypes ("password", "authorization_code", "refresh_token", "implicit")
//                .authorities ("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER")
//                .scopes ("read", "write")
//                .autoApprove (true)
//                .secret ("$2a$06$zuAKXywwSmwN1B1r.zJwHOOmrrQlus4X4lvLZmWPEIwyxfQkVWRBC");


            clients.inMemory().withClient("javainuse-client-admin").secret("$2a$04$.kL9QfhwQkMqxFoiFbp8k.GIgJhosn5KjfI18cCaT6wvO1xdOf8nC")
                    .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                    .authorities ("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "ADMIN")
                    .scopes("read", "write")
                     .and()
                     .withClient("javainuse-client-user").secret("$2a$04$.kL9QfhwQkMqxFoiFbp8k.GIgJhosn5KjfI18cCaT6wvO1xdOf8nC")
                    .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                    .authorities ("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER")
                    .scopes("read", "write");


    }
//    @Bean
//    public PasswordEncoder passwordEncoder () {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public void configure (AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager (authenticationManager)
                .tokenStore (tokenStore);

    }

    @Bean
    public TokenStore tokenStore () {
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.checkTokenAccess("permitAll()");
    }

}