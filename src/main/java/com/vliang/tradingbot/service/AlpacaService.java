package com.vliang.tradingbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Value;

@Service
public class AlpacaService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${alpaca.api.endpoint}")
    private String apiEndpoint;

    @Value("${alpaca.api.key}")
    private String apiKey;

    @value("${alpaca.api.secert}")
    private String apiSecret;

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("APCA-API-KEY-ID", apiKey);
        headers.set("APCA-API-SECRET-KEY", apiSecret);
        return headers;
    }

    public String getAccountInfo() {
        String url = apiEndpoint + "/v2/account";
        HttpEntity<String> entity = new HttpEntity<>(createHeaders());
        return restTemplate.exchange(url, HttpMethod.get, entity, String.class).getBody();
    }

    // add more methods for other API operations

    // placing orders

    // fetching positions

    // etc....
}
