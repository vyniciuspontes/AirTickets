/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.hibernate;

import com.vpontes.airtickets.dao.AirfareDAO;
import com.vpontes.airtickets.dao.utils.HibernateUtil;
import com.vpontes.airtickets.model.generated.Airfare;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vyniciuspontes
 */
public class HibernateTest {
    
    public HibernateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void hello() {
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        
        new AirfareDAO().findByAirport(1, 2);
        
        //System.out.println(airfare.getPrice());
        
        s.getTransaction().commit();
    }
}
