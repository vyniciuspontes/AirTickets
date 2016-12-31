/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.AirfareDAO;
import com.vpontes.airtickets.dao.AirportFlightDAO;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.AirportFlight;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vyniciuspontes
 */
public class ResumeAirfareWS implements WebService{

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String airfareGoId = request.getParameter("airfareGoId");
        String airfareBackId = request.getParameter("airfareBackId");
        Integer passangersNumber = Integer.valueOf(request.getParameter("passangersNumber"));
        
        AirfareDAO airfareDAO = new AirfareDAO();
        
        Airfare airfareGo = airfareDAO.findById(Integer.valueOf(airfareGoId));
        Airfare airfareBack = airfareDAO.findById(Integer.valueOf(airfareBackId));
        
        AirportFlightDAO afDAO = new AirportFlightDAO();
        
        List<AirportFlight> airportFlights = afDAO.findByFlight(airfareGo.getFlight().getId());
        
        Airport originAirport = airportFlights.get(0).getAirport();
        Airport destinationAirport = airportFlights.get(1).getAirport();
        
        HttpSession session = request.getSession();
        session.setAttribute("airfareGoId", Integer.valueOf(airfareGoId));
        session.setAttribute("airfareBackId", Integer.valueOf(airfareBackId));
        session.setAttribute("passangersNumber", passangersNumber);
        
        request.setAttribute("originAirfare", airfareGo);
        request.setAttribute("destinationAirfare", airfareBack);
        request.setAttribute("originAirport", originAirport);
        request.setAttribute("destinationAirport", destinationAirport);
        
        Double totalPrice = airfareGo.getPrice().doubleValue() + airfareBack.getPrice().doubleValue() + 
                originAirport.getBoardingFee().doubleValue() + destinationAirport.getBoardingFee().doubleValue();
        
        totalPrice = totalPrice * passangersNumber;
        
        String totalPriceReturn = String.format("%10.2f", totalPrice);
        
        request.setAttribute("totalPrice", totalPriceReturn);
        
        RequestDispatcher rd = request.getRequestDispatcher("/resume.jsp");
        rd.forward(request, response);
    }
    
    
    
}
