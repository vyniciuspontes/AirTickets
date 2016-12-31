/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.webservices;

import com.vpontes.airtickets.dao.UserSystemDAO;
import com.vpontes.airtickets.model.generated.UserSystem;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vyniciuspontes
 */
public class LoginWS implements WebService{

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserSystemDAO usDAO = new UserSystemDAO();
        UserSystem us = usDAO.findByEmail(email);
        
        if(us == null || !(us.getPassword().equals(password))){
            request.setAttribute("errorCode", 401);
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            //response.setStatus(401);
            //String path = "/AirTickets/Login";
            //response.sendRedirect(path);
        }else {
            
            HttpSession session = request.getSession();
            session.setAttribute("userId", us.getId());
            session.setAttribute("loginName", us.getFirstName());
            
            String searchQuery = (String) session.getAttribute("searchQuery");
            if(searchQuery != null){
                String path = "ResumeAirfareWS?" + searchQuery;
                response.sendRedirect(path);
            } else {
                String path = "/AirTickets/Search";
                response.sendRedirect(path);
            }
        }
    }
}
