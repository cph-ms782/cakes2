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
    private List<recipeDTO> recipes = new ArrayList();

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
                recipe = new recipeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructions"),
                        rs.getString("ratings")
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
            ResultSet rs = connector.getConnection().createStatement().executeQuery(query);
            while (rs.next()) {
                recipes.add(new recipeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructions"),
                        rs.getString("ratings")
                ));
            }
        } catch (SQLException ex) {

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
