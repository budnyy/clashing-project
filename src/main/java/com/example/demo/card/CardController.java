package com.example.demo.card;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClient;

@Controller
@RequestMapping("/clashing")
public class CardController {

    @Value("${API_TOKEN}")
    private String apiToken;

    RestClient restClient = RestClient.builder().build();

    @GetMapping("/cards")
    @ResponseBody
    public CardResponse getCards() {

        return restClient.get()
                .uri("https://api.clashroyale.com/v1/cards")
                .header("Authorization", apiToken)
                .retrieve().body(CardResponse.class);
    }
}
