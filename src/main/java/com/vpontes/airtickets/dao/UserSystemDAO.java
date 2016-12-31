/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.dao.utils.HibernateUtil;
import com.vpontes.airtickets.model.generated.UserSystem;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author vyniciuspontes
 */
public class UserSystemDAO extends BaseDAO {

    public UserSystemDAO(){
        super();
    }
    
    @Override
    public UserSystem findById(Integer id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        return session.find(UserSystem.class, id);
    }
    
    public UserSystem findByEmail(String email){
        
        Query q = session.createQuery("From UserSystem where email=:emailParameter");
        
        q.setParameter("emailParameter", email);
        
        UserSystem us = (UserSystem) q.uniqueResult();
        
        return us;
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
