package com.example.foodproject;

import java.util.*;

public class INGMatching {
    private final UserPantry userPantry;
    private final txtRecipe TxtRecipe;

    public INGMatching(UserPantry userPantry, txtRecipe TxtRecipe){
        this.userPantry = userPantry;
        this.TxtRecipe = TxtRecipe;
    }

    public Map<Recipe, Double> findMatchingRecipes(){
        Map<Recipe, Double> matches = new LinkedHashMap<>();
        LinkedList<String> userIngredients = userPantry.getingredients();

        for (Recipe recipe : TxtRecipe.getAllRecipes().values()){
            double matchPer = calculateMatchPer(userIngredients,recipe);
            matches.put(recipe, matchPer);
        }
        return SortByMatchPer(matches);
    }

    private double calculateMatchPer(List<String> userIngredients, Recipe recipe){
        Set<String> recipeIngredients = recipe.getIngredients().keySet();
        if (recipeIngredients.isEmpty()) return 0.0;

        int matches = 0;
        for (String ingredient : recipeIngredients){
            if (containsIngredient(userIngredients, ingredient)){
                matches++;
            }
        }

        return (double) matches/ recipeIngredients.size() * 100;
    }

    private boolean containsIngredient(List<String> userIngredients, String recipeIngredients){
        String normalizeRecipe = recipeIngredients.toLowerCase().trim();

        for (String userIngredient : userIngredients){
            String normalizeUser= userIngredient.toLowerCase().toLowerCase();
            if (normalizeUser.equals(normalizeRecipe) || normalizeUser.contains(normalizeRecipe)
            || normalizeRecipe.contains(normalizeUser)){
                return true;
            }
        }
        return false;
    }
    private Map<Recipe, Double> SortByMatchPer(Map<Recipe, Double> matches){
        List<Map.Entry<Recipe, Double>> entries = new ArrayList<>(matches.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        Map<Recipe, Double> sortedMatches = new LinkedHashMap<>();
        for (Map.Entry<Recipe, Double> entry : entries){
            sortedMatches.put(entry.getKey(), entry.getValue());
        }
        return sortedMatches;
    }
    public void displayMatches(){
        Map<Recipe, Double> matches = findMatchingRecipes();

        System.out.println("\n Recipe Results");

        for (Map.Entry<Recipe,Double> entry : matches.entrySet()){
            System.out.printf("%s: .0f%", entry.getKey().getName(), entry.getValue());

            if (entry.getValue() < 100){
                System.out.println("Missing Ingredients");
                Set<String> recuoeUbgresd = entry.getKey().getIngredients().keySet();
                LinkedList<String> userIngred = userPantry.getingredients();

                for (String ingredient : recuoeUbgresd){
                    if (!containsIngredient(userIngred, ingredient)){
                        System.out.println("- " + ingredient);
                    }
                }
            }
            System.out.println("\n");
        }
    }
}
