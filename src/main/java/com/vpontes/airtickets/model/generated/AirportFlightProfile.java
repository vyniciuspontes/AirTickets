package com.vpontes.airtickets.model.generated;
// Generated 31/12/2016 15:45:09 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AirportFlightProfile generated by hbm2java
 */
public class AirportFlightProfile  implements java.io.Serializable {


     private int id;
     private String name;
     private Set airportFlights = new HashSet(0);

    public AirportFlightProfile() {
    }

	
    public AirportFlightProfile(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public AirportFlightProfile(int id, String name, Set airportFlights) {
       this.id = id;
       this.name = name;
       this.airportFlights = airportFlights;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getAirportFlights() {
        return this.airportFlights;
    }
    
    public void setAirportFlights(Set airportFlights) {
        this.airportFlights = airportFlights;
    }




}

