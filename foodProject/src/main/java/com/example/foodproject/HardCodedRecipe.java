package com.example.foodproject;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HardCodedRecipe implements RecipeProvider{
    private Map<String, Recipe> recipes;
    private LinkedList<String> allIngredients;

    public HardCodedRecipe() {
        this.recipes = new LinkedHashMap<>();
        this.allIngredients = new LinkedList<>();
        initializeRecipes();
    }

    private void initializeRecipes() {
        // Recipe 1: Spaghetti Carbonara
        Recipe carbonara = new Recipe();
        carbonara.setName("Spaghetti Carbonara");

        Map<String, String> carbonaraIngredients = new LinkedHashMap<>();
        carbonaraIngredients.put("Spaghetti", "400g");
        carbonaraIngredients.put("Eggs", "3");
        carbonaraIngredients.put("Pancetta", "150g");
        carbonaraIngredients.put("Parmesan cheese", "50g");
        carbonaraIngredients.put("Black pepper", "to taste");
        carbonara.setIngredients(carbonaraIngredients);

        List<String> carbonaraInstructions = new LinkedList<>();
        carbonaraInstructions.add("Boil spaghetti according to package instructions");
        carbonaraInstructions.add("Fry pancetta until crispy");
        carbonaraInstructions.add("Beat eggs with grated Parmesan");
        carbonaraInstructions.add("Drain spaghetti and mix with pancetta");
        carbonaraInstructions.add("Add egg mixture and stir quickly to create creamy sauce");
        carbonaraInstructions.add("Season with black pepper");
        carbonara.setInstructions(carbonaraInstructions);

        recipes.put(carbonara.getName(), carbonara);

        // Recipe 2: Chocolate Chip Cookies
        Recipe cookies = new Recipe();
        cookies.setName("Chocolate Chip Cookies");

        Map<String, String> cookiesIngredients = new LinkedHashMap<>();
        cookiesIngredients.put("Flour", "2.5 cups");
        cookiesIngredients.put("Butter", "1 cup");
        cookiesIngredients.put("Sugar", "1.5 cups");
        cookiesIngredients.put("Chocolate chips", "2 cups");
        cookiesIngredients.put("Eggs", "2");
        cookies.setIngredients(cookiesIngredients);

        List<String> cookiesInstructions = new LinkedList<>();
        cookiesInstructions.add("Preheat oven to 375°F (190°C)");
        cookiesInstructions.add("Cream butter and sugars together");
        cookiesInstructions.add("Beat in eggs");
        cookiesInstructions.add("Stir in flour and chocolate chips");
        cookiesInstructions.add("Drop spoonfuls onto baking sheet");
        cookiesInstructions.add("Bake for 9-11 minutes");
        cookies.setInstructions(cookiesInstructions);

        recipes.put(cookies.getName(), cookies);

        // Populate allIngredients list
        for (Recipe recipe : recipes.values()) {
            for (String ingredient : recipe.getIngredients().keySet()) {
                if (!allIngredients.contains(ingredient)) {
                    allIngredients.add(ingredient);
                }
            }
        }
    }
    @Override
    public LinkedList<String> getIngredients() {
        return allIngredients;
    }

    @Override
    public Map<String, Recipe> getAllRecipes() {
        return recipes;
    }
}
