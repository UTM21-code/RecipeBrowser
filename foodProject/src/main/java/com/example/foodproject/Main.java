package com.example.foodproject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserPantry pantry = new UserPantry();
        pantry.addIngredient("Eggs");
        pantry.addIngredient("spaghetti");
        pantry.addIngredient("Parmesan Cheese");
        pantry.addIngredient("flour");
        pantry.addIngredient("butter");


        HardCodedRecipe recipe = new HardCodedRecipe();

        INGMatching matcher = new INGMatching(pantry, recipe);

        System.out.println("user Pantry");
        for (String ingredients: pantry.getIngredients()){
            System.out.println("- " + ingredients);
        }

        System.out.println("\n Recipe Matching result:");
        matcher.displayMatches();
        /**
        txtRecipe Txt = new txtRecipe("C:\\Users\\rover\\IdeaProjects\\foodProject\\src\\main\\java\\com\\example\\foodproject\\recipes.txt");
        try {
            Txt.loadRec();
            INGMatching matcher = new INGMatching(pantry,Txt);
            matcher.displayMatches();
            Map<String, Recipe> recipes = Txt.getAllRecipes();
            System.out.println("Loaded " + recipes.size() + " recipes");

            // Print all ingredients
            System.out.println("\nAll ingredients:");
            for (String ing : Txt.getIngredients()) {
                System.out.println("- " + ing);
            }
        } catch (IOException e) {
            System.err.println("error" + e.getMessage());
            return;
        }
        Txt.getAllRecipes();
        */
    }

}
