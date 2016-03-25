<%-- 
    Document   : meals
    Created on : Feb 8, 2016, 4:59:58 PM
    Author     : Kathy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
        <h1>What did you eat yesterday?</h1>
        <form action="calorieCounter" method="post">
            <p>Meal 1:<br>
                <input type="hidden" name="numMeals" value="${numMeals}" />
                <label>Food</label>
                <input type="text" name="meal1" value="${meal1}" required/><br>
                <label>Calories</label>
                <input type="text" name="calorie1" value="${calorie1}" required/>
                <span class="error">${error1}</span>
            </p>
            <c:if test="${numMeals > 1}">
                <p>Meal 2:<br>
                    <label>Food</label>
                    <input type="text" name="meal2" value="${meal2}" required/><br>
                    <label>Calories</label>
                    <input type="text" name="calorie2" value="${calorie2}" required/>
                    <span class="error">${error2}</span>
                </p>
                <c:if test="${numMeals > 2}">
                    <p>Meal 3:<br>
                        <label>Food</label>
                        <input type="text" name="meal3" value="${meal3}" required/><br>
                        <label>Calories</label>
                        <input type="text" name="calorie3" value="${calorie3}" required/>
                        <span class="error">${error3}</span>
                    </p>
                    <c:if test="${numMeals > 3}">
                        <p>Meal 4:<br>
                            <label>Food</label>
                            <input type="text" name="meal4" value="${meal4}"required/><br>
                            <label>Calories</label>
                            <input type="text" name="calorie4" value="${calorie4}" required/>
                            <span class="error">${error4}</span>
                        </p>
                    </c:if>
                </c:if>
            </c:if>
            <input type="submit" value="Submit"/>
        </form>              
  

                
<c:import url="/includes/footer.jsp" />
