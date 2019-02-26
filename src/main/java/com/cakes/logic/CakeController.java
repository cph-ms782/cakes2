/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cakes.logic;

import com.cakes.data.ingredientDAO;
import com.cakes.data.recipeDAO;
import com.cakes.data.recipeDTO;
import java.util.List;

/**
 *
 * @author martin
 */
public class CakeController {

//    public List<String> getIngredients();
//
//    public ingredientDAO getIngredient();

    public List<recipeDTO> getRecipes() {
        return new recipeDAO().getRecipes();
    }
    
    public recipeDTO getRecipe(String recipeName)
    {
        return new recipeDAO().getRecipe(recipeName);
    }
}
