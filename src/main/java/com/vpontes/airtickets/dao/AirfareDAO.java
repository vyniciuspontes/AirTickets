
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.dao.utils.HibernateUtil;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Airport;
import com.vpontes.airtickets.model.generated.AirportFlight;
import com.vpontes.airtickets.model.generated.Flight;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

/**
 *
 * @author vyniciuspontes
 */
public class AirfareDAO extends BaseDAO{
    
    public AirfareDAO(){
        
    }
    
    @Override
    public Airfare findById(Integer id) {
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            //List<Airfare> result = session.createQuery("From Airfare").list();
            //Airfare airfare = result.get(0);
            Airfare airfare = session.find(Airfare.class, id);
            return airfare;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Airfare> findAll() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Airfare> query = builder.createQuery(Airfare.class);
            Root<Airfare> fromItem = query.from(Airfare.class);
            query.select(fromItem);
            List<Airfare> list = session.createQuery(query).getResultList();
            return list;
        }catch(Exception ex){
            Logger.getLogger(AirfareDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Airfare> findByAirport(int originAirportId, int destinationAirportId){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Airfare> query = builder.createQuery(Airfare.class);

        Root<Airfare> airfareRoot = query.from(Airfare.class); 

        Join<Airfare, Flight> fRoot = airfareRoot.join("flight");

        Join<Flight, AirportFlight> afs1 = fRoot.join("airportFlights");

        Join<Flight, AirportFlight> afs2 = fRoot.join("airportFlights");

        Predicate p1 = 
                builder.equal(afs1.get("flight").get("id"), afs2.get("flight").get("id"));

        Predicate p2 = builder.and(builder.equal(afs1.get("airport").get("id"), originAirportId), 
                builder.equal(afs1.get("airportFlightProfile").get("id"), 1));

        Predicate p3 = builder.and(builder.equal(afs2.get("airport").get("id"), destinationAirportId), 
                builder.equal(afs2.get("airportFlightProfile").get("id"), 2));

        Predicate p4 = builder.and(p1, p2, p3);

        query.select(airfareRoot).where(p4);

        List<Airfare> resultList = session.createQuery(query).getResultList();

        return resultList;
    }
}
