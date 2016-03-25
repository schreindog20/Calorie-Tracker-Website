/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kathy
 */
public class Meal {
   
    private String meal;
    private int calories, mealid, user; //user id
    int YYYY, MM, DD;

    public Meal(String meal, int calories, int mealid, int user) {
        this.meal = meal;
        this.calories = calories;
        this.mealid = mealid;
        this.user = user;
    }

    public Meal(int calories, int YYYY, int MM, int DD) {
        this.calories = calories;
        this.YYYY = YYYY;
        this.MM = MM;
        this.DD = DD;
    }

    public Meal(int calories) {
        this.calories = calories;
    }
    

    public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
        this.meal = meal;
        this.calories = calories;
        this.mealid = mealid;
        this.user = user;
        this.YYYY = YYYY;
        this.MM = MM;
        this.DD = DD;
    }

    public int getYYYY() {
        return YYYY;
    }

    public int getMM() {
        return MM;
    }

    public int getDD() {
        return DD;
    }
    
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

 
    public Meal() {
        meal = "";
        calories = 0;
        
    }

    public Meal(String meal, int calories) {
        this.meal = meal;
        this.calories = calories;
 
    }
    
public Meal(String meal, int calories, int mealid) {
        this.meal = meal;
        this.calories = calories;
 this.mealid = mealid;
    }
    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
        public int getMealid() {
        return mealid;
    }

    public void setMealid(int mealid) {
        this.mealid = mealid;
    }
}
