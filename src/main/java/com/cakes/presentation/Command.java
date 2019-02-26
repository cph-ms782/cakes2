/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cakes.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martin
 */
public abstract class Command {

    public abstract void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    static public Command from(HttpServletRequest request) {
        Command c;
        String path = request.getPathInfo().substring(1);
        switch (path) {
            case "recipes":
            case "recipe":
            case "cakes":
                c = new RecipesCommand();
//                RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/LoginServlet/");
//                dispatch.forward(request, response);
                break;
            default:
                c = new UnknownCommand();
        }
        return c;
    }
}
