package com.vpontes.airtickets.model.generated;
// Generated 31/12/2016 15:45:09 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Flight generated by hbm2java
 */
public class Flight  implements java.io.Serializable {


     private int id;
     private Date departureTime;
     private Date arrivalTime;
     private Boolean hasConnection;
     private Set airportFlights = new HashSet(0);
     private Set airfares = new HashSet(0);

    public Flight() {
    }

	
    public Flight(int id, Date departureTime, Date arrivalTime) {
        this.id = id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
    public Flight(int id, Date departureTime, Date arrivalTime, Boolean hasConnection, Set airportFlights, Set airfares) {
       this.id = id;
       this.departureTime = departureTime;
       this.arrivalTime = arrivalTime;
       this.hasConnection = hasConnection;
       this.airportFlights = airportFlights;
       this.airfares = airfares;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getDepartureTime() {
        return this.departureTime;
    }
    
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
    public Date getArrivalTime() {
        return this.arrivalTime;
    }
    
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public Boolean getHasConnection() {
        return this.hasConnection;
    }
    
    public void setHasConnection(Boolean hasConnection) {
        this.hasConnection = hasConnection;
    }
    public Set getAirportFlights() {
        return this.airportFlights;
    }
    
    public void setAirportFlights(Set airportFlights) {
        this.airportFlights = airportFlights;
    }
    public Set getAirfares() {
        return this.airfares;
    }
    
    public void setAirfares(Set airfares) {
        this.airfares = airfares;
    }




}

