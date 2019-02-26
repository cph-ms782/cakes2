/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cakes.data;

import java.util.ArrayList;
import java.util.List;

/**
 *	`id` int NOT NULL,
	`name` VARCHAR(45) NOT NULL,
	`instructions` VARCHAR(300) NOT NULL,
	`ratings` VARCHAR(5) NOT NULL DEFAULT '0%',
 * @author martin
 */
public class recipeDTO {

    private int id;
    private String name;
    private String instructions;
    private String ratings;
    List<String> ingredients = new ArrayList();

    public recipeDTO(int id, String name, String instructions, String ratings) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getRatings() {
        return ratings;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
