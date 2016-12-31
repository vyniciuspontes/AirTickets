/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.dao.utils.HibernateUtil;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.AirportFlight;
import com.vpontes.airtickets.model.generated.Flight;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author vyniciuspontes
 */
public class AirportFlightDAO extends BaseDAO{

    public AirportFlightDAO(){
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
    
    public List<AirportFlight> findByFlight(Integer flightId){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AirportFlight> query = builder.createQuery(AirportFlight.class);

        Root<AirportFlight> airportFlightRoot = query.from(AirportFlight.class);
        
        Predicate p1 = builder.equal(airportFlightRoot.get("flight").get("id"), flightId);
        
        Order o = builder.asc(airportFlightRoot.get("airportFlightProfile").get("id"));
        
        query.select(airportFlightRoot).where(p1).orderBy(o);
        
        List<AirportFlight> airportFlights = session.createQuery(query).getResultList();
        
        return airportFlights;
    }
    
    public List<AirportFlight> findByFlight(Flight flight){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AirportFlight> query = builder.createQuery(AirportFlight.class);

        Root<AirportFlight> airportFlightRoot = query.from(AirportFlight.class);
        
        Predicate p1 = builder.equal(airportFlightRoot.get("flight"), flight);
        
        Order o = builder.asc(airportFlightRoot.get("airportFlightProfile").get("id"));
        
        query.select(airportFlightRoot).where(p1).orderBy(o);
        
        List<AirportFlight> airportFlights = session.createQuery(query).getResultList();
        
        return airportFlights;
    }
    
}
