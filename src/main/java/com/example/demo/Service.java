package com.example.demo;

import com.example.demo.card.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

@org.springframework.stereotype.Service
public class Service {

    private final ExternalApiClient externalApiClient;

    @Autowired
    public Service(ExternalApiClient externalApiClient) {this.externalApiClient = externalApiClient;}

    @Cacheable("cards")
    public CardResponse getCards(){
        return externalApiClient.getCards();
    }
}
