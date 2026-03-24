package com.example.demo;

import com.example.demo.card.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import tools.jackson.databind.ObjectMapper;
import java.time.Duration;

@org.springframework.stereotype.Service
public class Service {

    private final ExternalApiClient externalApiClient;
    private final RedisTemplate<String, String> redisTemplate;


    @Autowired
    public Service(ExternalApiClient externalApiClient,  RedisTemplate<String, String> redisTemplate) {
        this.externalApiClient = externalApiClient;
        this.redisTemplate = redisTemplate;
    }

    public CardResponse getCards(){

        ObjectMapper om = new ObjectMapper();

        String cacheResponse = redisTemplate.opsForValue().get("cardlist");


        if(cacheResponse == null){
            CardResponse apiResponse = externalApiClient.getCards();
            String apiResponseJson = om.writeValueAsString(apiResponse);
            redisTemplate.opsForValue().set("cardlist", apiResponseJson);
            redisTemplate.expire("cardlist", Duration.ofDays(2L));
            return apiResponse;
        }
        else{
            return om.readValue(cacheResponse, CardResponse.class);
        }

    }
}
