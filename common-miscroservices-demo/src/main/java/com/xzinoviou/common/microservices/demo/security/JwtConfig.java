package com.xzinoviou.common.microservices.demo.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

/** @author xzinoviou created 18/7/2019 */
@Getter
public class JwtConfig {

  @Value("${security.jwt.uri:/auth/**}")
  private String uri;

  @Value("${security.jwt.header:Authorization}")
  private String header;

  @Value("${security.jwt.prefix:Bearer }")
  private String prefix;

  @Value("${security.jwt.expiration:#{24*60*60}}")
  private long expiration;

  @Value("${security.jwt.secret:JwtSecretKey}")
  private String secret;
}
