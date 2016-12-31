/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.PassangerDAO;
import com.vpontes.airtickets.model.generated.Passanger;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vyniciuspontes
 */
public class PassangerWS implements WebService{
    
    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) {
        getPassanger(request, response);
    }
    
    public void getPassanger(HttpServletRequest request, HttpServletResponse response){
        
        try {
            PassangerDAO dao = new PassangerDAO();

            String identity = request.getParameter("identity");
            String passport = request.getParameter("passport");

            Passanger passanger = dao.findByPassportOrIdentity(passport, identity);

            if(passanger == null)
            {
                passanger = new Passanger();
                passanger.setFirstName(request.getParameter("firstName"));
                passanger.setLastName(request.getParameter("lastName"));
                passanger.setIdentityNumber(request.getParameter("identityNumber"));
                passanger.setPassportNumber(request.getParameter("passportNumber"));
                passanger.setDeficient(Boolean.getBoolean(request.getParameter("deficient")));
                passanger.setPhone(request.getParameter("phone"));
                dao.insert(passanger);
            }
            request.setAttribute("passanger", passanger);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            //Logger.getLogger(PassangerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
