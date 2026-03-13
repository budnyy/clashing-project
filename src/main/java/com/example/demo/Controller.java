package com.example.demo;

import com.example.demo.card.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@RequestMapping("/clashing")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {this.service = service;}

    @GetMapping("/cards")
    @ResponseBody
    public CardResponse getCards() {
        return service.getCards();
    }

}
