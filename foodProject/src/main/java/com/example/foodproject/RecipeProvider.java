package com.example.foodproject;

import java.util.LinkedList;
import java.util.Map;

public interface RecipeProvider {
    LinkedList<String> getIngredients();
    Map<String, Recipe> getAllRecipes();
}
