package com.vpontes.airtickets.model.generated;
// Generated 31/12/2016 15:45:09 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SeatProfile generated by hbm2java
 */
public class SeatProfile  implements java.io.Serializable {


     private int id;
     private String name;
     private Set airfares = new HashSet(0);

    public SeatProfile() {
    }

	
    public SeatProfile(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public SeatProfile(int id, String name, Set airfares) {
       this.id = id;
       this.name = name;
       this.airfares = airfares;
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
    public Set getAirfares() {
        return this.airfares;
    }
    
    public void setAirfares(Set airfares) {
        this.airfares = airfares;
    }




}


