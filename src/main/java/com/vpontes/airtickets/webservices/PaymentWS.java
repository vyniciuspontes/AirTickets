/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.AirfareDAO;
import com.vpontes.airtickets.model.generated.Airfare;
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
public class PaymentWS implements WebService{

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Integer airfareGoId = (Integer) session.getAttribute("airfareGoId");
        Integer airfareBackId = (Integer) session.getAttribute("airfareBackId");
        Integer passangersNumber = (Integer) session.getAttribute("passangersNumber");
        
        setUnavaliable(airfareGoId, airfareBackId, passangersNumber);
        
        RequestDispatcher rd = request.getRequestDispatcher("/passangerRegistration.jsp");
        
        rd.forward(request, response);
    }
    
    public void setUnavaliable(Integer airfareGoId, Integer airfareBackId, Integer passangersNumber){
        AirfareDAO airfareDAO = new AirfareDAO();
        
        Airfare airfareGo = airfareDAO.findById(airfareGoId);
        Airfare airfareBack = airfareDAO.findById(airfareBackId);
        
        Integer avaliableGo = airfareGo.getAvaliable();
        Integer avaliableBack = airfareBack.getAvaliable();
        
        airfareGo.setAvaliable(avaliableGo - passangersNumber);
        airfareBack.setAvaliable(avaliableBack - passangersNumber);
        
        airfareDAO.update(airfareGo);
        airfareDAO.update(airfareGo);
    }
}
