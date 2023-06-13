package com.sity.msmpesaservice.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.PrivateKey;

@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "mpesa.daraja")
public class MpesaConfig {
    private String consumerKey;
    private String consumerSecret;
    private String grantType;
    private String oauthEndpoint;

}
