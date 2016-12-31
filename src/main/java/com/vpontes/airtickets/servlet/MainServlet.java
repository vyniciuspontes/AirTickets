/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpontes.airtickets.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vpontes.airtickets.webservices.WebService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author vyniciuspontes
 */
@WebServlet(name = "AirTickets", urlPatterns = {"/Checkin", "/Search", "/Login", "/Server/*"})
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException, IOException {
       
        String pathInfo = request.getPathInfo();
        if(pathInfo != null) {
            
            String path = pathInfo;
            String[] pathContent = path.split("/");
            
            if(pathContent[1].equals("Service")){
                String wsName = pathContent[2];
                String className = "com.vpontes.airtickets.webservices." + wsName;
                Class currentClass = Class.forName(className);
                WebService ws = (WebService) currentClass.newInstance();
                ws.run(request, response);
            }
        } else if(request.getServletPath().equals("/Search")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/searchAirtickets.jsp");
            dispatcher.forward(request, response);
            
            //response.sendRedirect("AirTickets/serverUp.jsp");
        }else if(request.getServletPath().equals("/Login")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            
            //response.sendRedirect("AirTickets/serverUp.jsp");
        }else if(request.getServletPath().equals("/Checkin")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/checkin.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            processRequest(request, response);
        } catch (InstantiationException | ClassNotFoundException 
                | IllegalAccessException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
         } catch (InstantiationException | ClassNotFoundException 
                | IllegalAccessException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
