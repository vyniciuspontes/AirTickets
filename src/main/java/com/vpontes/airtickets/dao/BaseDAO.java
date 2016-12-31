/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao;

import com.vpontes.airtickets.dao.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vyniciuspontes
 */
abstract public class BaseDAO {
    
    protected Session session;
    
    abstract public <X extends Object> X findById(Integer id);
    abstract public <X extends Object> List<X> findAll();
    
    public BaseDAO(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public <X> void insert(X object) {
        session.save(object);
        session.flush();
    }

    public <X> void update(X object) {
        session.update(object);
        session.flush();
    }

    public <X> void delete(X object) {
        session.delete(object);
        session.flush();
    }
    
}
