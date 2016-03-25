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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class LoginServlet extends HttpServlet {
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
    
        String url = "/signup.jsp";
        String back = " back";
        String pwError = "";
        String admin = "";
        int ID;
         request.getSession().setAttribute("admin", admin);
         User newUser;       
        User currentUser;
         List<User> userList = new ArrayList<>();
         List<Meal> mealList = new ArrayList<>();
          List<Meal> mealListByDay = new ArrayList<>();
           List<Meal> mealListByDay7 = new ArrayList<>();
            List<Meal> mealListByDay30 = new ArrayList<>();
            List<Meal> todaysMeals = new ArrayList<>();
         Meal newestMeal;
       int clearance;
       // int numMeals = Integer.valueOf(request.getParameter("numMeals"));
       // request.setAttribute("numMeals", numMeals);
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        System.out.println(email);
        System.out.println(password);
        
         newUser = new User("", "", email, password, 0);
        //check if user exists already
        //if so, check if user or admin
        //if not, sign them up
        try {
            
            if (DButil.checkExist(email, password) == 0) { 
                //sign up
                url = "/signup.jsp";
            } else if (DButil.checkExist(email, password) == 2){
                //wrong PW
                pwError = "Incorrect Password!";
                url = "/index.jsp";              
            } else {
                //log in  
                ID = DButil.getIDfromEmail(email);
                System.out.println(ID);
                String temp = "" + ID;
                mealList = DButil.getMealOrder(temp);
                
                mealListByDay = DButil.getMealOrderByDay(temp);
                mealListByDay7 = DButil.getMealOrderByDayLast7(temp);
                mealListByDay30 = DButil.getMealOrderByDayLast30(temp);
                
                newestMeal = DButil.getNewestMeal(temp);
                todaysMeals = DButil.getMealsByDate(temp, YYYY, MM, DD);
               int todaysCals = DButil.totalCalsByDate(temp,YYYY, MM,DD);
               
                clearance = DButil.getClearance(email);
                currentUser = DButil.getCurrentUser(email);                
                request.getSession().setAttribute("currentUser", currentUser);                
                request.getSession().setAttribute("mealList", mealList);      
                
                   request.getSession().setAttribute("mealListByDay", mealListByDay);
                   request.getSession().setAttribute("mealListByDay7", mealListByDay7);
                   request.getSession().setAttribute("mealListByDay30", mealListByDay30);
                   
                 request.getSession().setAttribute("newestMeal", newestMeal);
                 request.getSession().setAttribute("todaysMeals", todaysMeals);
                 request.getSession().setAttribute("todaysCals", todaysCals);
                request.getSession().setAttribute("back", back);
                
                
                int todaysDiff = currentUser.getGoal() - todaysCals;                
                String exceed ="";                
                if (todaysDiff < 0) {                         
                    todaysDiff = 0;                         
                    exceed = "You have exceeded your daily calorie goal!"; 
                }                
                request.getSession().setAttribute("exceed", exceed);                
                request.getSession().setAttribute("todaysDiff", todaysDiff);
                
                
                if (clearance == 1) {
                    //user
                    url = "/dashboard.jsp";                
                } else {
                    //admin
                    admin = "admin";
                    request.getSession().setAttribute("admin", admin);
                    userList = DButil.getAllUsers();
                    request.getSession().setAttribute("userList", userList);
                    url = "/admin.jsp";                   
                }
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* 
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        request.getSession().setAttribute("user", user);
        */
       
       request.getSession().setAttribute("pwError", pwError);
     request.getSession().setAttribute("email", email);
     request.getSession().setAttribute("pw", password);
     //  request.getSession().setAttribute("newUser", email);
     
     
   //get current date

    
    System.out.println( mon + "/" + day + "/" + yr);
   
            int data = 666;
       request.getSession().setAttribute("data", data);
       request.getSession().setAttribute("yr", yr);
       request.getSession().setAttribute("mon", mon);
       request.getSession().setAttribute("day", day);
       
         getServletContext().getRequestDispatcher(url).forward(request,response);
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

   