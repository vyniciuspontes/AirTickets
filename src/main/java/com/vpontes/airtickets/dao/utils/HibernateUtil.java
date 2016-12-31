/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author vyniciuspontes
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            //return new Configuration().configure().buildSessionFactory();
           Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = 
                    new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml");
            SessionFactory factory = configuration.buildSessionFactory(builder.build());
            
            /*return new MetadataSources(
                new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build()
                ).buildMetadata().buildSessionFactory();*/
            
            return factory;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void close(){
        
        sessionFactory.close();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
