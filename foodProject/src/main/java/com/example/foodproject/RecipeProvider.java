package com.example.foodproject;

import java.util.LinkedList;

public interface RecipeProvider {
    LinkedList<String> getIngredients();
}
