package com.xzinoviou.zuulservice.security;

import com.xzinoviou.common.microservices.demo.security.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/** @author xzinoviou created 18/7/2019 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private JwtConfig jwtConfig;

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
        .addFilterAfter(
            new JwtAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, jwtConfig.getUri())
        .permitAll()
        .antMatchers("/book" + "/admin/**")
        .hasRole("ADMIN")
        .anyRequest()
        .authenticated();
  }

  @Bean
  public JwtConfig jwtConfig() {
    return new JwtConfig();
  }
}
