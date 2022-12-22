//package com.example.inventory.security;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class  SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(keycloakAuthenticationProvider());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.csrf().disable().cors().and().headers().frameOptions().disable()
//                .and()
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated();
//    }
//}
