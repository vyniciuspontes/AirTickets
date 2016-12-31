package com.vpontes.airtickets.model.generated;
// Generated 31/12/2016 15:45:09 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Passanger generated by hbm2java
 */
public class Passanger  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String lastName;
     private String passportNumber;
     private String identityNumber;
     private String phone;
     private int age;
     private Boolean deficient;
     private String nationality;
     private Set bookings = new HashSet(0);

    public Passanger() {
    }

	
    public Passanger(int id, String firstName, String lastName, String phone, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
    }
    public Passanger(int id, String firstName, String lastName, String passportNumber, String identityNumber, String phone, int age, Boolean deficient, String nationality, Set bookings) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.passportNumber = passportNumber;
       this.identityNumber = identityNumber;
       this.phone = phone;
       this.age = age;
       this.deficient = deficient;
       this.nationality = nationality;
       this.bookings = bookings;
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
    public String getPassportNumber() {
        return this.passportNumber;
    }
    
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public String getIdentityNumber() {
        return this.identityNumber;
    }
    
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public Boolean getDeficient() {
        return this.deficient;
    }
    
    public void setDeficient(Boolean deficient) {
        this.deficient = deficient;
    }
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public Set getBookings() {
        return this.bookings;
    }
    
    public void setBookings(Set bookings) {
        this.bookings = bookings;
    }




}

