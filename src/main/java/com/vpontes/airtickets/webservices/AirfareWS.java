/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.bo.PassangerBO;
import com.vpontes.airtickets.dao.AirfareDAO;
import com.vpontes.airtickets.dao.AirportDAO;
import com.vpontes.airtickets.dao.FlightDAO;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.Flight;
import com.vpontes.airtickets.model.generated.Passanger;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vyniciuspontes
 */
public class AirfareWS implements WebService{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        getAirfareList(request, response);
    }
    
    private void getAirfareList(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
        String airportOriginName = request.getParameter("originAirport");
        String airportDestinationName = request.getParameter("destinationAirport");
            
        AirportDAO aiportDAO = new AirportDAO();
        AirfareDAO dao = new AirfareDAO();

        Airport airportOrigin = aiportDAO.findByName(airportOriginName);
        Airport airportDestination = aiportDAO.findByName(airportDestinationName);

        List<Airfare> airfareList = dao.findByAirport(airportOrigin.getId(), airportDestination.getId());
        
        FlightDAO flightDAO = new FlightDAO();
        
        Flight flight = flightDAO.findById(airfareList.get(0).getFlight().getId());
        
        request.setAttribute("airportFlights", flight.getAirportFlights());
        request.setAttribute("airfareList", airfareList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/newjsp.jsp");
        dispatcher.forward(request, response);
       
    }
    
}
