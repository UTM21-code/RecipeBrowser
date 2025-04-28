package com.example.foodproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class txtRecipe implements RecipeProvider{


    private Map<String, Recipe> recipes;
    private LinkedList<String> allIngredients;
    private String filePath;

    /**
     *
     * @param filePath
     */
    public txtRecipe(String filePath){
        this.filePath = filePath;
        this.recipes = new LinkedHashMap<>();
        this.allIngredients = new LinkedList<>();
    }

    /**
     * This attempts to try and load all of the ingredients and the
     * @throws IOException
     */
    public void loadRec() throws IOException{
        List<Recipe> recipeList = readRecipesFromFile(filePath);
        for (Recipe recipe: recipeList){
            recipes.put(recipe.getName(), recipe);
            for(String ingredient : recipe.getIngredients().keySet()){
                if (!allIngredients.contains(ingredient)){
                            allIngredients.add(ingredient);
                }
            }
        }
    }

    /**
     * This Attempts to start reading from a file by using the buffered reader and then assign them
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<Recipe> readRecipesFromFile(String filePath) throws IOException{

        List<Recipe> recipes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        System.out.println("Attempting to read from: " + new File(filePath).getAbsolutePath());
        String line;
        Recipe currentRecipe = null;

        while((line = reader.readLine()) != null){
            line = line.trim();

            if (line.isEmpty() || line.startsWith("package") || line.startsWith("import")){
                continue;
            }
            if (line.startsWith("Recipes:")){
                if (currentRecipe != null){
                    recipes.add(currentRecipe);
                    System.out.println("Attempting to read fro.......m: ");
                }
                currentRecipe = new Recipe();
                currentRecipe.setName(line.substring(8).trim());

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
        return allIngredients;
    }

    public Map<String, Recipe> getAllRecipes(){
        return recipes;
    }
}
