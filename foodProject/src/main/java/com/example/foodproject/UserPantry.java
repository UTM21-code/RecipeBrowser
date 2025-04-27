package com.example.foodproject;

import java.util.LinkedList;

public class UserPantry implements IngredientSource {


   public LinkedList<String> ingredients = new LinkedList<String>();

    @Override
    public LinkedList<String> getingredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String Newingredients){
        ingredients.add(Newingredients);
    }
}
