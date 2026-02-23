package com.example.demo.card;

import java.util.List;

public class CardResponse {

    private List<CardModel> items;

    public CardResponse(){}

    public CardResponse(List<CardModel> items){
        this.items = items;
    }

    public List<CardModel> getItems(){
        return items;
    }

    public void setItems(List<CardModel> list){
        this.items = list;
    }
}
