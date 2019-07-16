package com.forezp.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.Assert;
/**
 * The class O auth 2 feign request interceptor.
 *
 * @author paascloud.net @gmail.com
 */
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_TYPE = "bearer";
    private static final String SCOPE_HEADER = "scope";
    private final OAuth2RestTemplate oAuth2RestTemplate;
    @Autowired
    private OAuth2ClientContext context;
    /**
     * Instantiates a new O auth 2 feign request interceptor.
     *
     * @param oAuth2RestTemplate the o auth 2 rest template
     */
     OAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
         Assert.notNull(oAuth2RestTemplate, "Context can not be null");
         this.oAuth2RestTemplate = oAuth2RestTemplate;
     }
     /**
     * Apply.
     *
     * @param template the template
     */
     @Override
     public void apply(RequestTemplate template) {
         if(context.getAccessToken() != null && context.getAccessToken().getValue() != null && OAuth2AccessToken.BEARER_TYPE.equalsIgnoreCase(context.getAccessToken().getTokenType()) ){
             template.header(AUTHORIZATION_HEADER, String.format("%s %s", OAuth2AccessToken.BEARER_TYPE, context.getAccessToken().getValue()));
             template.header(SCOPE_HEADER,"server");
         }
     }
}

