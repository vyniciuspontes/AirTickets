/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.dao.utils.HibernateUtil;
import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Flight;
import java.util.List;

/**
 *
 * @author vyniciuspontes
 */
public class FlightDAO extends BaseDAO{

    public FlightDAO(){
        super();
    }
    
    @Override
    public Flight findById(Integer id) {
        //List<Airfare> result = session.createQuery("From Airfare").list();
        //Airfare airfare = result.get(0);
        Flight flight = session.find(Flight.class, id);
        return flight;   
    
    }

    @Override
    public <X> List<X> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <X> void insert(X object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <X> void update(X object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <X> void delete(X object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
