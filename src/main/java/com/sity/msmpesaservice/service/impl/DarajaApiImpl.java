package com.sity.msmpesaservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sity.msmpesaservice.config.MpesaConfig;
import com.sity.msmpesaservice.model.AccessTokenResponse;
import com.sity.msmpesaservice.service.DarajaApi;
import com.sity.msmpesaservice.utils.HelperUtility;
import static com.sity.msmpesaservice.utils.Constants.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class DarajaApiImpl  implements DarajaApi {

    private final MpesaConfig mpesaConfig;
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public DarajaApiImpl(MpesaConfig mpesaConfig, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        this.mpesaConfig = mpesaConfig;
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public AccessTokenResponse getAccessToken() {

        String encodedCredentials = HelperUtility.toBase64String(String.format("%s:%s",
                mpesaConfig.getConsumerKey(), mpesaConfig.getConsumerSecret()));

        Request request = new Request.Builder()
                .url(String.format("%s?grant_type=%s", mpesaConfig.getOauthEndpoint(), mpesaConfig.getGrantType()))
                .get()
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodedCredentials))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            System.out.println(request);
            System.out.println(response);
            return objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
        } catch (IOException e) {
            log.error(String.format("Could not get access token. -> %s", e.getLocalizedMessage()));
            return null;
        }

    }
}
