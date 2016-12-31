/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Booking;
import com.vpontes.airtickets.model.generated.OrderBooking;
import com.vpontes.airtickets.model.generated.Passanger;
import com.vpontes.airtickets.model.generated.UserSystem;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

/**
 *
 * @author vyniciuspontes
 */
public class BookingDAO extends BaseDAO{

    public BookingDAO(){
        super();
    }
    
    public Booking findByAirfareAndPassanger(Integer airfareId, Integer passangerId) {
        Query q = session.createQuery("From Booking where id.airfareId=:airfareId and id.passangerId=:passangerId");
        
        q.setParameter("airfareId", airfareId);
        q.setParameter("passangerId", passangerId);
        
        Booking b = (Booking) q.uniqueResult();
        
        return b; 
    }
    
    public List<Booking> findByUser(Integer userId){
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
        Root<Booking> bookingRoot = query.from(Booking.class); 
        
        Join<Booking, OrderBooking> obJoin = bookingRoot.join("orderBooking");
        Predicate p1 = 
                builder.equal(obJoin.get("userSystem").get("id"), userId);
        query.select(bookingRoot).where(p1);
        
        List<Booking> resultList = session.createQuery(query).getResultList();
        
        return resultList;
    }
    
    public List<Booking> findByPassport(String passportNumber){
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
        Root<Booking> bookingRoot = query.from(Booking.class); 
        
        Join<Booking, Passanger> passangerJoin = bookingRoot.join("passanger");
        Predicate p1 = 
                builder.equal(passangerJoin.get("passportNumber"), passportNumber);
        
        Predicate p2 = builder.equal(bookingRoot.get("checkIn"), false);
        
        Predicate p3 = builder.and(p1, p2);
        
        query.select(bookingRoot).where(p3);
        
        List<Booking> resultList = session.createQuery(query).getResultList();
        
        return resultList;
    }
    
    @Override
    public <X> List<X> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <X> X findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
