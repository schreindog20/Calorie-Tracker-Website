/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3520.a3.servlet;

import Utils.DButil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Meal;
import model.User;


/**
 *
 * @author Kathy
 */
public class makeAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String url = "/admin.jsp";
        List<User> userList = new ArrayList<>();
        String ID = request.getParameter("id");   
        System.out.println(ID);
        try {
            userList = DButil.makeAdmin(ID);
            
            // getServletContext().getRequestDispatcher(url).forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(deleteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("userList", userList);
           // request.setAttribute("totalCal", totalCal);
            getServletContext().getRequestDispatcher(url).forward(request,response);
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

   