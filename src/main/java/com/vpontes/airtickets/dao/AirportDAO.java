/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.dao.utils.HibernateUtil;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.AirportFlight;
import com.vpontes.airtickets.model.generated.Flight;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author vyniciuspontes
 */
public class AirportDAO extends BaseDAO{

    public AirportDAO(){
        super();
    }
    
    @Override
    public <X> X findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <X> List<X> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Airport findByName(String name){
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Airport> query = builder.createQuery(Airport.class);
        Root<Airport> airportRoot = query.from(Airport.class); 
        
        Predicate p1 = builder.equal(airportRoot.get("name"), name);
        
        query.select(airportRoot).where(p1);
        
        return session.createQuery(query).getSingleResult();
        
    }
    
    public List<Airport> findByFlight(Integer flightId){
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Airport> query = builder.createQuery(Airport.class);
        Root<Airport> airportRoot = query.from(Airport.class);
        
        Join<Airport, AirportFlight> afs1 = airportRoot.join("airportFlights");
        
        Predicate p1 = builder.equal(afs1.get("id").get("flightId"), flightId);
        
        Order o = builder.asc(afs1.get("airportFlightProfile").get("id"));
        
        query.select(airportRoot).where(p1).orderBy(o);
        
        List<Airport> result = session.createQuery(query).list();
        
        return result;
    }
    
}
