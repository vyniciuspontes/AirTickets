package com.vpontes.airtickets.model.generated;
// Generated 31/12/2016 15:45:09 by Hibernate Tools 4.3.1



/**
 * Booking generated by hbm2java
 */
public class Booking  implements java.io.Serializable {


     private BookingId id;
     private Airfare airfare;
     private OrderBooking orderBooking;
     private Passanger passanger;
     private boolean checkIn;
     private String seatCode;

    public Booking() {
    }

	
    public Booking(BookingId id, Airfare airfare, OrderBooking orderBooking, Passanger passanger, boolean checkIn) {
        this.id = id;
        this.airfare = airfare;
        this.orderBooking = orderBooking;
        this.passanger = passanger;
        this.checkIn = checkIn;
    }
    public Booking(BookingId id, Airfare airfare, OrderBooking orderBooking, Passanger passanger, boolean checkIn, String seatCode) {
       this.id = id;
       this.airfare = airfare;
       this.orderBooking = orderBooking;
       this.passanger = passanger;
       this.checkIn = checkIn;
       this.seatCode = seatCode;
    }
   
    public BookingId getId() {
        return this.id;
    }
    
    public void setId(BookingId id) {
        this.id = id;
    }
    public Airfare getAirfare() {
        return this.airfare;
    }
    
    public void setAirfare(Airfare airfare) {
        this.airfare = airfare;
    }
    public OrderBooking getOrderBooking() {
        return this.orderBooking;
    }
    
    public void setOrderBooking(OrderBooking orderBooking) {
        this.orderBooking = orderBooking;
    }
    public Passanger getPassanger() {
        return this.passanger;
    }
    
    public void setPassanger(Passanger passanger) {
        this.passanger = passanger;
    }
    public boolean isCheckIn() {
        return this.checkIn;
    }
    
    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
    public String getSeatCode() {
        return this.seatCode;
    }
    
    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }




}

