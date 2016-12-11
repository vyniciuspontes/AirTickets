/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.model.generated.Airfare;
import com.vpontes.airtickets.model.generated.Passanger;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author vyniciuspontes
 */
public class PassangerDAO extends BaseDAO{

    
    
    @Override
    public <X> X findById(Integer id) {
        
        return null;
    }

    @Override
    public <X> List<X> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Passanger findByPassportOrIdentity(String passportNumber, String identityNumber){
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
           CriteriaQuery<Passanger> query = builder.createQuery(Passanger.class);
           Root<Passanger> fromItem = query.from(Passanger.class);
           query.select(fromItem).where(
               builder.equal(fromItem.get("passport_number"), passportNumber),
                   builder.or(builder.equal(fromItem.get("identity_number"), passportNumber))
           );
           
           Passanger passanger = session.createQuery(query).getSingleResult();
           
        return passanger;
    }
    
    
}
