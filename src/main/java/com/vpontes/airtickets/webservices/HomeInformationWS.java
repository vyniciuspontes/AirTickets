/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.AirportDAO;
import com.vpontes.airtickets.dao.AirportFlightDAO;
import com.vpontes.airtickets.dao.BookingDAO;
import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.AirportFlight;
import com.vpontes.airtickets.model.generated.Booking;
import com.vpontes.airtickets.view.objects.BookingAirport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vyniciuspontes
 */
public class HomeInformationWS implements WebService{

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String passportNumber = request.getParameter("passportNumber");
        
        if(passportNumber == null){
            String path = "/Login";
            response.sendRedirect(path);
        } else {
            
            BookingDAO bookingDAO = new BookingDAO();
            List<Booking> bookings = bookingDAO.findByPassport(passportNumber);
            
            if(bookings.isEmpty()){
                RequestDispatcher rd = request.getRequestDispatcher("/checkin.jsp");
                rd.forward(request, response);
            }
            
            List<BookingAirport> bookingAirport = new ArrayList<>();
            AirportDAO airportDAO = new AirportDAO();
            
            for (Booking booking : bookings) {
                
                BookingAirport ba = new BookingAirport();
                
                ba.setBooking(booking);
                List<Airport> airports = airportDAO.findByFlight(booking.getAirfare().getFlight().getId());
                ba.setAirports(airports);
                
                bookingAirport.add(ba);
            }
            
            request.setAttribute("bookingAirportList", bookingAirport);
            
            RequestDispatcher rd = request.getRequestDispatcher("/checkin.jsp");
            rd.forward(request, response);
        }
    }
    
}
