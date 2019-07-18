package com.xzinoviou.authservice.security;

import com.xzinoviou.common.microservices.demo.security.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

/** @author xzinoviou created 18/7/2019 */
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {

  @Autowired private JwtConfig jwtConfig;

  @Autowired private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(
            (req, resp, e) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
        .and()
        .addFilter(
            new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, jwtConfig.getUri())
        .permitAll()
        .anyRequest()
        .authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public JwtConfig jwtConfig() {
    return new JwtConfig();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
