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
import java.util.Calendar;
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
public class changeGoal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      Calendar cal = Calendar.getInstance();    
        int yr = cal.get(Calendar.YEAR);
    int mon = cal.get(Calendar.MONTH) + 1; //MONTHS START FROM ZERO
    int day = cal.get(Calendar.DAY_OF_MONTH);
    
    String YYYY = "" + yr;
    String MM = "" + mon;
    String DD = "" + day;
      String url = "/settings.jsp";
        //List<User> userList = new ArrayList<>();
        User currentUser = new User();
        String ID = request.getParameter("id"); 
        String newGoal = request.getParameter("goal");
        //System.out.println(ID);
        try {
            currentUser = DButil.changeGoal(ID, newGoal);
               String temp = "" + currentUser.getIdUser();
              int todaysCals = DButil.totalCalsByDate(temp,YYYY, MM,DD);
               int todaysDiff = currentUser.getGoal() - todaysCals;
            String exceed ="";
                if (todaysDiff < 0) {
                         todaysDiff = 0;
                         exceed = "You have exceeded your daily calorie goal!";
                          
                     }
                request.getSession().setAttribute("exceed", exceed);
                request.getSession().setAttribute("todaysDiff", todaysDiff);
            // getServletContext().getRequestDispatcher(url).forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(deleteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("currentUser", currentUser);
           // request.setAttribute("totalCal", totalCal);
        
          
           
                
           
            getServletContext().getRequestDispatcher(url).forward(request,response);
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

   