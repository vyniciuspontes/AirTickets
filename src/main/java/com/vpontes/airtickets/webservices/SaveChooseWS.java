/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vyniciuspontes
 */
public class SaveChooseWS implements WebService{

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String query = request.getQueryString();
        session.setAttribute("searchQuery", query);
        
        String path = "/AirTickets/Login";
        response.sendRedirect(path);
        
        //RequestDispatcher rd = request.getRequestDispatcher("/Login");
        
        //rd.forward(request, response);
    }
    
}
