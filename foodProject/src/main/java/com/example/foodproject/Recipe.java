package com.example.foodproject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    private String name;
    private Map<String, String> ingredients;
    private List<String> instructions;



    public Recipe(){
        this.ingredients = new LinkedHashMap<>();
        this.instructions= new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, String> getIngredients(){return ingredients;}

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
}
