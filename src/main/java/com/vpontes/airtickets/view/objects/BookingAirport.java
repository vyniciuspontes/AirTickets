/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.view.objects;

import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.Booking;
import java.util.List;

/**
 *
 * @author vyniciuspontes
 */
public class BookingAirport {
    
    private Booking booking;
    private List<Airport> airports;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
    
    public BookingAirport(){
        
    }
}
