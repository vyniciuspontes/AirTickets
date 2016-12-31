/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.AirfareDAO;
import com.vpontes.airtickets.dao.AirportFlightDAO;
import com.vpontes.airtickets.dao.BookingDAO;
import com.vpontes.airtickets.dao.OrderBookingDAO;
import com.vpontes.airtickets.dao.PassangerDAO;
import com.vpontes.airtickets.dao.UserSystemDAO;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.AirportFlight;
import com.vpontes.airtickets.model.generated.Booking;
import com.vpontes.airtickets.model.generated.BookingId;
import com.vpontes.airtickets.model.generated.OrderBooking;
import com.vpontes.airtickets.model.generated.Passanger;
import com.vpontes.airtickets.model.generated.UserSystem;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vyniciuspontes
 */
public class PassangersRegistrationWS implements WebService {

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer airfareGoId = (Integer) session.getAttribute("airfareGoId");
        Integer airfareBackId = (Integer) session.getAttribute("airfareBackId");
        Integer passangersNumber = (Integer) session.getAttribute("passangersNumber");
        Integer userId = (Integer) session.getAttribute("userId");
        
        String[] first_names = request.getParameterValues("firstName");
        String[] last_names = request.getParameterValues("lastName");
        String[] nationalities = request.getParameterValues("nationality");
        String[] identities = request.getParameterValues("identity");
        String[] passports = request.getParameterValues("passport");
        String[] phones = request.getParameterValues("phone");
        String[] seatCodesGo = request.getParameterValues("seatCodeGo");
        String[] seatCodesBack = request.getParameterValues("seatCodeBack");
        
        PassangerDAO passangerDAO = new PassangerDAO();
        
        AirfareDAO airfareDAO = new AirfareDAO();
        Airfare airfareGo = airfareDAO.findById(airfareGoId);
        Airfare airfareBack = airfareDAO.findById(airfareBackId);
        
        BigDecimal fullPrice = calculateFullPrice(airfareGo,airfareBack, passangersNumber);
        
        OrderBooking ob = new OrderBooking();
        ob.setQuantity(passangersNumber);
        UserSystemDAO userSystemDAO = new UserSystemDAO();
        UserSystem us =  userSystemDAO.findById(userId);
        ob.setUserSystem(us);
        ob.setQuantity(passangersNumber);
        ob.setTotalPrice(fullPrice);
        
        OrderBookingDAO obDAO = new OrderBookingDAO();
        obDAO.insert(ob);
        
        BookingDAO bookingDAO = new BookingDAO();
        
        for (int i = 0; i < passangersNumber; i++) {
            
            Passanger passanger = new Passanger();
                        passanger.setFirstName(first_names[i]);
            passanger.setLastName(last_names[i]);
            passanger.setNationality(nationalities[i]);
            passanger.setIdentityNumber(identities[i]);
            passanger.setPassportNumber(passports[i]);
            passanger.setPhone(phones[i]);
            if(request.getParameter("deficient" + i) == null)
                passanger.setDeficient(true);
            
            passangerDAO.insert(passanger);
            
            Booking bookingGo = new Booking();
            bookingGo.setAirfare(airfareGo);
            bookingGo.setOrderBooking(ob);
            bookingGo.setSeatCode(seatCodesGo[i]);
            bookingGo.setPassanger(passanger);
            BookingId bookingGoId = new BookingId();
            bookingGoId.setAirfareId(airfareGo.getId());
            bookingGoId.setPassangerId(passanger.getId());
            bookingGo.setId(bookingGoId);
            
            Booking bookingBack = new Booking();
            bookingBack.setAirfare(airfareBack);
            bookingBack.setOrderBooking(ob);
            bookingBack.setSeatCode(seatCodesBack[i]);
            bookingBack.setPassanger(passanger);
            BookingId bookingBackId = new BookingId();
            bookingBackId.setAirfareId(airfareBack.getId());
            bookingBackId.setPassangerId(passanger.getId());
            bookingBack.setId(bookingBackId);
            
            bookingDAO.insert(bookingGo);
            bookingDAO.insert(bookingBack);
        }
        
        String path = "/AirTickets/Search";
        response.sendRedirect(path);
        
        //RequestDispatcher rd = request.getRequestDispatcher("/AirTickets/Home");
        
        //rd.forward(request, response);
    }
    
    private BigDecimal calculateFullPrice(Airfare airfareGo, Airfare airfareBack, Integer passangersNumber){
        
        BigDecimal total = new BigDecimal(0);
        
        AirportFlightDAO afDAO = new AirportFlightDAO();
        
        BigDecimal goFee = afDAO.findByFlight(airfareGo.getFlight().getId())
                .get(0).getAirport().getBoardingFee();
        total = total.add(goFee);
        
        BigDecimal backFee = afDAO.findByFlight(airfareBack.getFlight().getId())
                .get(0).getAirport().getBoardingFee();
        total = total.add(backFee);
        
        total = total.add(airfareGo.getPrice());
        total = total.add(airfareBack.getPrice());
        total = total.multiply(BigDecimal.valueOf(passangersNumber));
        
        return total;
    }
    
}
