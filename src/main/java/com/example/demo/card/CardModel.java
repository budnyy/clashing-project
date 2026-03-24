package com.example.demo.card;

import java.io.Serializable;
import java.util.Map;

public class CardModel implements Serializable {

    private String name;
    private Long id;
    private Integer elixirCost;
    private Map<String, String> iconUrls;
    private String rarity;

    public CardModel(String name, Long id, Integer elixirCost, Map<String, String> iconUrls, String rarity){
        this.name = name;
        this.id = id;
        this.elixirCost = elixirCost;
        this.iconUrls = iconUrls;
        this.rarity = rarity;
    }

    public String getName(){
        return this.name;
    }

    public Long getId(){
        return this.id;
    }

    public Integer getElixirCost(){
        return this.elixirCost;
    }

    public Map<String, String> getIconUrls() {
        return iconUrls;
    }

    public String getRarity(){
        return rarity;
    }

    public void setIconUrls(Map<String, String> iconUrls) {
        this.iconUrls = iconUrls;
    }
}
