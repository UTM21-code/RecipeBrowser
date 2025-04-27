package com.example.foodproject;

import java.util.Map;

public class INGMatching {
    private final UserPantry userPantry;
    private final txtRecipe TxtRecipe;

    public INGMatching(UserPantry userPantry, txtRecipe TxtRecipe){
        this.userPantry = userPantry;
        this.TxtRecipe = TxtRecipe;
    }

    public Map<Recipe, Double> findMatchingRecipes(){
        Map<Recipe, Double> matches
    }
}
