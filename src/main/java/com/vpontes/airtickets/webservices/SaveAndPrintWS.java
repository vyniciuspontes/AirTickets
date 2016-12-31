/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.AirportDAO;
import com.vpontes.airtickets.dao.BookingDAO;
import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.Booking;
import com.vpontes.airtickets.view.objects.BookingAirport;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vyniciuspontes
 */
public class SaveAndPrintWS implements WebService {
    

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String airfareId = request.getParameter("airfareId");
        String passangerId = request.getParameter("passangerId");
        String newSeatCode = request.getParameter("newSeatCode");
        
        BookingDAO bookingDAO = new BookingDAO();
        AirportDAO airportDAO = new AirportDAO();
        Booking booking = bookingDAO.findByAirfareAndPassanger(Integer.valueOf(airfareId),
                Integer.valueOf(passangerId));
        booking.setCheckIn(true);
        booking.setSeatCode(newSeatCode);
        bookingDAO.update(booking);
        
        BookingAirport ba = new BookingAirport();
                
        ba.setBooking(booking);
        List<Airport> airports = airportDAO.findByFlight(booking.getAirfare().getFlight().getId());
        ba.setAirports(airports);
        
        request.setAttribute("bookingAirport", ba);
            
        RequestDispatcher rd = request.getRequestDispatcher("/print.jsp");
        rd.forward(request, response);
    }
}
