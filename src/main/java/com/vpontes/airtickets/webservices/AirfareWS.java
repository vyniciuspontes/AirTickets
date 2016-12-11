/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.AirfareDAO;
import com.vpontes.airtickets.dao.AirportDAO;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Airport;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;

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
        
        String goDate = request.getParameter("goDate");
        String backDate = request.getParameter("backDate");
        
        AirportDAO aiportDAO = new AirportDAO();
        AirfareDAO dao = new AirfareDAO();

        Airport airportOrigin = aiportDAO.findByName(airportOriginName);
        Airport airportDestination = aiportDAO.findByName(airportDestinationName);

        Integer passangersNumber = Integer.valueOf(request.getParameter("passangersNumber"));
        
        DateTime goDateTime = new DateTime(goDate);
        
        List<Airfare> airfareGoList = dao.findByAirport(airportOrigin.getId(), 
                airportDestination.getId(), goDateTime, passangersNumber);
        
        DateTime backDateTime = new DateTime(backDate);
        List<Airfare> airfareBackList = dao.findByAirport(airportDestination.getId(), 
                airportOrigin.getId(), backDateTime, passangersNumber);
        
        request.setAttribute("airfareBackList", airfareBackList);
        request.setAttribute("airfareGoList", airfareGoList);
        
        request.setAttribute("passangersNumber", passangersNumber);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showAirfares.jsp");
        dispatcher.forward(request, response);
       
    }
    
}
