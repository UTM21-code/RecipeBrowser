package com.example.foodproject;

import java.util.LinkedList;

public class UserPantry implements IngredientSource {
    /**
     * This is a class to give a source from where the user would insert in the items of their household
     * It assigns them to a linked list to and get ingredients and add ingredients which just adds thing to the list
     *
     */

   public LinkedList<String> ingredients = new LinkedList<String>();

    @Override
    public LinkedList<String> getIngredients() {
        return this.ingredients;
    }

   public void addIngredient(String NewIngredients){
       ingredients.add(NewIngredients);
    }
}
