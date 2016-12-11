package com.vpontes.airtickets.model.generated;
// Generated 10/12/2016 19:17:31 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * UserSystem generated by hbm2java
 */
public class UserSystem  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String lastName;
     private String email;
     private String password;
     private Serializable phone;
     private Set orderBookings = new HashSet(0);

    public UserSystem() {
    }

	
    public UserSystem(int id, String firstName, String lastName, String email, String password, Serializable phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public UserSystem(int id, String firstName, String lastName, String email, String password, Serializable phone, Set orderBookings) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.password = password;
       this.phone = phone;
       this.orderBookings = orderBookings;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Serializable getPhone() {
        return this.phone;
    }
    
    public void setPhone(Serializable phone) {
        this.phone = phone;
    }
    public Set getOrderBookings() {
        return this.orderBookings;
    }
    
    public void setOrderBookings(Set orderBookings) {
        this.orderBookings = orderBookings;
    }




}


