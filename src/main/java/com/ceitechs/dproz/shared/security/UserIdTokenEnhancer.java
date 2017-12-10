package com.ceitechs.dproz.shared.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Enhances the tokens that are being generated to add userId information
 */
@Component
public class UserIdTokenEnhancer  implements TokenEnhancer{
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Object user = authentication.getPrincipal();

        if ( user instanceof  DprozUserDetail) {
            DprozUserDetail userDetail = (DprozUserDetail)user;
            final Map<String, Object> additionalInfo = new HashMap<>();
            additionalInfo.put("userReferenceId",userDetail.getUserReferenceId() );
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        }
        return accessToken;
    }
}
