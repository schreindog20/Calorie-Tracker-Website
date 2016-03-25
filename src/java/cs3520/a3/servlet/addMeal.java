/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3520.a3.servlet;

import Utils.DButil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class addMeal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        Calendar cal = Calendar.getInstance();    
        int yr = cal.get(Calendar.YEAR);    
        int mon = cal.get(Calendar.MONTH) + 1; //Months start from zero  
        int day = cal.get(Calendar.DAY_OF_MONTH);        
        String YYYY = "" + yr;    
        String MM = "" + mon;    
        String DD = "" + day;
        
     List<Meal> todaysMeals = new ArrayList<>();
     User currentUser = new User();
     
    
      String url = "/daily.jsp";
    List<Meal> mealList = new ArrayList<>();
     List<Meal> mealListByDay = new ArrayList<>();
       List<Meal> mealListByDay7 = new ArrayList<>();
         List<Meal> mealListByDay30 = new ArrayList<>();
        String ID = request.getParameter("id"); 
         String email = request.getParameter("email"); 
        String name = request.getParameter("mealName");
          String mealCals = request.getParameter("mealCals");
          Meal newestMeal;
         int mealMM = Integer.valueOf(request.getParameter("mealMM"));
               int mealDD = Integer.valueOf(request.getParameter("mealDD"));
                     int mealYYYY = Integer.valueOf(request.getParameter("mealYYYY"));
                     
                     String d = mealDD + "-" + mealMM + "-" + mealYYYY;
                     
     // Date d = new Date(mealYYYY+1900, mealMM-1, mealDD);
        try {
            DButil.addMeal(name, mealCals, ID, d, mealYYYY, mealMM, mealDD);
            mealList = DButil.getMealOrder(ID);
            mealListByDay = DButil.getMealOrderByDay(ID);
               mealListByDay7 = DButil.getMealOrderByDayLast7(ID);
                mealListByDay30 = DButil.getMealOrderByDayLast30(ID);
                  request.getSession().setAttribute("mealListByDay7", mealListByDay7);
                   request.getSession().setAttribute("mealListByDay30", mealListByDay30);
                   
            request.getSession().setAttribute("mealList", mealList);
            request.getSession().setAttribute("mealListByDay", mealListByDay);
            newestMeal = DButil.getNewestMeal(ID);
                 request.getSession().setAttribute("newestMeal", newestMeal);
                 
                 todaysMeals = DButil.getMealsByDate(ID, YYYY, MM, DD);
                 request.getSession().setAttribute("todaysMeals", todaysMeals);
                     int todaysCals = DButil.totalCalsByDate(ID,YYYY, MM,DD);
                   
                    request.getSession().setAttribute("todaysCals", todaysCals);
                    
      //TODAYS DIFFERENCE int difference = ${currentUser.goal} - ${todaysCals};
             currentUser = DButil.getCurrentUser(email);  
                int todaysDiff = currentUser.getGoal() - todaysCals;
                String exceed = "";
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
        
              
        
        //request.getSession().setAttribute("userList", userList);
           // request.setAttribute("totalCal", totalCal);
            getServletContext().getRequestDispatcher(url).forward(request,response);
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

   