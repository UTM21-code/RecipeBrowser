package com.example.foodproject;

import java.util.*;

public class INGMatching {
    private final UserPantry userPantry;
    private final HardCodedRecipe hardCodedRecipe;

    public INGMatching(UserPantry userPantry, HardCodedRecipe hardCodedRecipe){
        this.userPantry = userPantry;
        this.hardCodedRecipe = hardCodedRecipe;
    }

    /**
     * This is to 
     * @return
     */
    public Map<Recipe, Double> findMatchingRecipes(){
        Map<Recipe, Double> matches = new LinkedHashMap<>();
        LinkedList<String> userIngredients = userPantry.getIngredients();

        for (Recipe recipe : hardCodedRecipe.getAllRecipes().values()){
            double matchPer = calculateMatchPer(userIngredients,recipe);
            matches.put(recipe, matchPer);
        }
        return SortByMatchPer(matches);
    }

    /**
     * This takes the user ingredients and then the recipes and then takes the average of them and then matches the amount of how many ingredients the user has
     * and the matches them to the specific recipe and divides by  that and then returns it
     * @param userIngredients
     * @param recipe
     * @return
     */
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

    /**
     * This takes the entries and sorts them based upon the percentages using maps and hashmaps
     * @param matches
     * @return
     */
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
        if(matches.isEmpty()){
            System.out.println("no recipes");
            return;
        }
        for (Map.Entry<Recipe,Double> entry : matches.entrySet()){

            System.out.printf("%s: %.0f%% match%n", entry.getKey().getName(), entry.getValue());

            if (entry.getValue() < 100){
                System.out.println("Missing Ingredients");
                Set<String> RecipeIng = entry.getKey().getIngredients().keySet();
                LinkedList<String> userIng = userPantry.getIngredients();

                for (String ingredient : RecipeIng){
                    if (!containsIngredient(userIng, ingredient)){
                        System.out.println("- " + ingredient);
                    }
                }
            }
            System.out.println("\n");
        }
    }
}
