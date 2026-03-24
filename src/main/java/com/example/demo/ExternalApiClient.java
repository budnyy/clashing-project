package com.example.demo;

import com.example.demo.card.CardResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExternalApiClient {

    @Value("${API_TOKEN}")
    private String apiToken;

    RestClient restClient = RestClient.builder().build();

    //change here to CardResponse type
    public CardResponse getCards(){
        return restClient.get()
                .uri("https://api.clashroyale.com/v1/cards")
                .header("Authorization", apiToken)
                .retrieve().body(CardResponse.class);
    }

}
