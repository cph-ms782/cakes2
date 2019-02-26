/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cakes.data;

/**
 *
 * @author martin
 */
public class ingredientDAO {

    public ingredientDTO getingredient(int ingredient_id, int recipe_id,
            String ingredient, String amount) {
        return new ingredientDTO(ingredient_id, recipe_id, ingredient, amount);
    }

}
