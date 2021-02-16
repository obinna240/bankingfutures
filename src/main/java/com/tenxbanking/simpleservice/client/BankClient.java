package com.tenxbanking.simpleservice.client;

import com.tenxbanking.simpleservice.model.BankDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@ConfigurationProperties(value = "bank.properties", ignoreUnknownFields = false)
public class BankClient {

    public final String BANK_API_ENDPOINT="/api/vi/bank";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BankClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BankDto getBankDtoById(String id ){
        return restTemplate.getForObject(apiHost+BANK_API_ENDPOINT+id, BankDto.class);
    }

    public URI doPost(BankDto bankDto ){
        return restTemplate.postForLocation(apiHost+BANK_API_ENDPOINT, BankDto.class);
    }
}
