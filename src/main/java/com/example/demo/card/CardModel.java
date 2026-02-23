package com.example.demo.card;

public class CardModel {

    private String name;
    private Long id;
    private Integer elixirCost;

    public CardModel(String name, Long id, Integer elixirCost){
        this.name = name;
        this.id = id;
        this.elixirCost = elixirCost;
    }

    public String getName(){return this.name;}

    public Long getId(){return this.id;}

    public Integer getElixirCost(){return this.elixirCost;}

    public void setName(String name){this.name = name;}

    public void setElixirCost(Integer elixirCost){this.elixirCost = elixirCost;}
}
