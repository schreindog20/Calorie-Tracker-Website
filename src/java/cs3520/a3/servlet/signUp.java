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
public class signUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/dashboard.jsp";
        User currentUser = new User();
         int ID;
         Meal newestMeal;
          List<Meal> mealList = new ArrayList<>();
          List<Meal> mealListByDay = new ArrayList<>();
       // int numMeals = Integer.valueOf(request.getParameter("numMeals"));
       // request.setAttribute("numMeals", numMeals);
        //User newUser2;
       // newUser2 = request.getSession().getAttribute(newUser);
        //String Email = request.getSession().getAttribute(email);
        
         String email = request.getParameter("email");
        String password = request.getParameter("password");
        String FName = request.getParameter("FName");
          String LName = request.getParameter("LName");
          int goal = Integer.valueOf(request.getParameter("Goal"));
          
          User newUser = new User(FName, LName, email, password, goal);
          
        try {
            //add user to DB
            DButil.addUser(newUser);
           
            ID = DButil.getIDfromEmail(email);
                System.out.println(ID);
                String temp = "" + ID;
                mealList = DButil.getMealOrder(temp);
               mealListByDay = DButil.getMealOrderByDay(temp);
               
            request.getSession().setAttribute("mealList", mealList);
            request.getSession().setAttribute("mealListByDay", mealListByDay);
            
            newestMeal = DButil.getNewestMeal(temp);
                 request.getSession().setAttribute("newestMeal", newestMeal);
            //User(String firstName, String lastName, String email, String password, int goal)
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
        try {
            /*
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            request.getSession().setAttribute("user", user);
            */
                            
            currentUser = DButil.getCurrentUser(email);
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        request.getSession().setAttribute("currentUser", currentUser);
       
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

   