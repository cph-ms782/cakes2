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
public class imageDAO {
    
    public imageDTO getImages(String image, int recipe_id) {
        return new imageDTO(image, recipe_id);
    }
    
}
