/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cakes.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class recipeDAO {

    private DB connector = null;
    private DB connector2 = null;
    private List<recipeDTO> recipes = new ArrayList();
    private List<ingredientDTO> ingredients;

    public recipeDTO getRecipe(String recipeName)
    {
        recipeDTO recipe = null;
        String query 
                = "SELECT *"
                + "FROM `recipes`"
                + "WHERE `name` = \""+recipeName+"\";";
        try {
            connector = new DB();
            ResultSet rs = connector.getConnection().createStatement().executeQuery(query);
            while (rs.next()) {
                        ingredients = new ArrayList();
                recipe = new recipeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructions"),
                        rs.getString("ratings"),
                        ingredients
                );
            }
        } catch (SQLException ex) {

        }
        return recipe;
    }
    
    public List<recipeDTO> getRecipes() {

        String query = "SELECT * FROM `recipes`;";

        try {
            connector = new DB();
            connector2 = new DB();
            ResultSet rs = connector.getConnection().createStatement().executeQuery(query);
            while (rs.next()) {
//                String query_ingr = "SELECT * FROM cakes.ingredients where `recipe_id` = 1;";
                int s = rs.getInt("id");
                if (s > 0) {
                    String query_ingr = "SELECT * FROM cakes.ingredients where `recipe_id` = " + s + ";";
                    ResultSet rs_ingredients = connector2.getConnection().createStatement().executeQuery(query_ingr);
                    while (rs_ingredients.next()) {
                        ingredients = new ArrayList();
                        ingredients.add(new ingredientDTO(
                                rs_ingredients.getInt("ingredients_id"),
                                rs_ingredients.getInt("recipe_id"),
                                rs_ingredients.getString("ingredient"),
                                rs_ingredients.getString("amount")));
                    }
                }
                recipes.add(new recipeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructions"),
                        rs.getString("ratings"),
                        ingredients
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Fejl recipeDAO " + ex);
        }
        return recipes;
    }

//    public recipeDTO getRecipe(int id, String name, String ratings) {
//
//        String query = "SELECT * FROM `recipes`;";
//        try {
//            connector = new DB();
//            ResultSet rs = connector.getConnection().createStatement().executeQuery(query);
//            while (rs.next()) {
//                recipes.add(new Frame(
//                        rs.getString("quality"),
//                        rs.getInt("frame_price")
//                ));
//                glassPrice = rsFrame.getInt("glass_price");
//            }
//        } catch (SQLException ex) {
//
//        }
//        return new recipeDTO(id, name, instructions, ratings);
//    }
}
