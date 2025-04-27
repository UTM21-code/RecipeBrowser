package com.example.foodproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class txtRecipe implements RecipeProvider{
    public static List<Recipe> readRecipesFromFile(String filePath) throws IOException{
        List<Recipe> recipes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        Recipe currentRecipe = null;

        while((line = reader.readLine()) != null){
            line = line.trim();

            if (line.startsWith("Recipes:")){
                if (currentRecipe != null){
                    recipes.add(currentRecipe);
                }
                currentRecipe = new Recipe();
                currentRecipe.setName(line.substring(7).trim());

            } else if (line.startsWith("Ingredients:")) {
                if (currentRecipe != null){
                    currentRecipe.setIngredients(new LinkedHashMap<>());
                }
            } else if (line.startsWith("- ") && currentRecipe != null && currentRecipe.getIngredients() != null) {
                String[] parts = line.substring(2).split(":");

                if (parts.length == 2){
                    currentRecipe.getIngredients().put(parts[0].trim(), parts[1].trim());
                }
            } else if(line.startsWith("Instructions:")){
                if (currentRecipe != null){
                    currentRecipe.setInstructions(new ArrayList<>());
                }
            } else if(line.startsWith("> ") && currentRecipe != null && currentRecipe.getInstructions() != null){
                currentRecipe.getInstructions().add(line.substring(2).trim());
            }
        }
        if (currentRecipe != null){
            recipes.add(currentRecipe);
        }

        reader.close();
        return recipes;
    }

    @Override
    public LinkedList<String> getIngredients() {
        return null;
    }
}
