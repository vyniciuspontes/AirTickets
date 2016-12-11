/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vyniciuspontes
 */
public class SaveAirfareWS implements WebService{

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String airfareGoId = request.getParameter("goGroup");
        String airfareBackId = request.getParameter("backGroup");
        Integer passangersNumber = Integer.valueOf(request.getParameter("passangersNumber"));
        
    }
    
    
    
}
