package com.xzinoviou.authservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzinoviou.authservice.domain.UserCredentials;
import com.xzinoviou.common.microservices.demo.security.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

/** @author xzinoviou created 18/7/2019 */
public class JwtUsernameAndPasswordAuthenticationFilter
    extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;
  private final JwtConfig jwtConfig;

  public JwtUsernameAndPasswordAuthenticationFilter(
      AuthenticationManager authenticationManager, JwtConfig jwtConfig) {
    this.authenticationManager = authenticationManager;
    this.jwtConfig = jwtConfig;

    /** Override default /login path. */
    this.setRequiresAuthenticationRequestMatcher(
        new AntPathRequestMatcher(jwtConfig.getUri(), HttpMethod.POST.name()));
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    try {

      /** Get credentials. */
      UserCredentials credentials =
          new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

      /** Create auth object. */
      UsernamePasswordAuthenticationToken authToken =
          new UsernamePasswordAuthenticationToken(
              credentials.getUsername(), credentials.getPassword(), Collections.emptyList());

      return authenticationManager.authenticate(authToken);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws IOException, ServletException {

    Long now = System.currentTimeMillis();
    String token =
        Jwts.builder()
            .setSubject(authResult.getName())
            .claim(
                "authorities",
                authResult.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setIssuedAt(new Date(now))
            .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))
            .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
            .compact();

    response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
  }
}
