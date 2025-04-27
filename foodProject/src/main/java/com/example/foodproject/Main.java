package com.example.foodproject;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        UserPantry pantry = new UserPantry();
        pantry.addIngredient("Flour");
        pantry.addIngredient("Sugar");

        LinkedList<String> ingredients = pantry.getingredients();
        System.out.println(ingredients);
    }

}
