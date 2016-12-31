package com.vpontes.airtickets.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author vyniciuspontes
 */
@WebListener
public class SessionListener implements HttpSessionListener{

    private final Logger logger = Logger.getLogger(SessionListener.class.getName());
    
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(400);
        logger.log(Level.INFO, "Session Created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.log(Level.INFO, "Session Destroyed");
    }
    
}
