package com.preet.security.config;

import com.preet.security.filtter.CustomAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Configuring Security for application");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(CustomAuthorizationFilter.AUTH_WHITELIST).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/authorization").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**").hasAnyAuthority("ROLE_ADMIN","ROLE_SUPER_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/**").hasAnyAuthority("ROLE_MANAGER");
        http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/**").hasAnyAuthority("ROLE_SUPER_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
