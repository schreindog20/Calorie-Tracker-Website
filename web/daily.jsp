<%-- 
    Document   : daily
    Created on : Feb 28, 2016, 7:41:30 PM
    Author     : Odz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:import url="/includes/header.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daily Input</title>
        <script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
        


<script type="text/javascript">
  window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Today's Calorie Consumption"
		},
                animationEnabled: true,
		legend:{
			verticalAlign: "center",
			horizontalAlign: "left",
			fontSize: 20,
			fontFamily: "Helvetica"        
		},
		theme: "theme2",
		data: [
		{        
			type: "pie",       
			indexLabelFontFamily: "Garamond",       
			indexLabelFontSize: 20,
			indexLabel: "{name}: {y} calories",
			startAngle:-20,      
			showInLegend: true,
			toolTipContent:"{name}: {y} calories",
			dataPoints: [
                            <c:forEach items="${todaysMeals}" var="meal">
				{  y: ${meal.calories}, name: "${meal.meal}"},                                                        
                            </c:forEach> 				
				{  y: ${todaysDiff}, name: "Free"}
			]          
		}
		]
	});
	chart.render();
}
</script>
<%--  
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Today's Calorie Consumption",
			fontFamily: "arial black"
		},
                animationEnabled: true,
		legend: {
			verticalAlign: "bottom",
			horizontalAlign: "center"
		},
		theme: "theme1",
		data: [
		{        
			type: "pie",
			indexLabelFontFamily: "Garamond",       
			indexLabelFontSize: 20,
			indexLabelFontWeight: "bold",
			startAngle:0,
			indexLabelFontColor: "MistyRose",       
			indexLabelLineColor: "darkgrey", 
			indexLabelPlacement: "inside", 
                        indexLabel:"{name} {y}cals",
			
			showInLegend: true,
                        toolTipContent:"{name} {y}cals",
			indexLabel: "#percent%", 
			dataPoints: [
                            <c:forEach items="${todaysMeals}" var="meal">
				{  y: ${meal.calories}, name: "${meal.meal}"},                                                        
                            </c:forEach> 				
				{  y: ${todaysDiff}, name: "Free Calories"}
			]                        
                        
		}
		]
	});
	chart.render();
}
</script>

--%>
<%-- dataPoints: [
				{  y: 52, name: "Time At Work", legendMarkerType: "triangle"},
				{  y: 44, name: "Time At Home", legendMarkerType: "square"},
				{  y: -12, name: "Time Spent Out", legendMarkerType: "circle"}
			]
		}
		]
	});
	chart.render();
} 
--%>
<style>
    h2 {
  text-align: center;
}

form {
  background: -webkit-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
  background: -moz-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
  background: linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
  margin: auto;
  position: relative;
  width: 450px;
  height: 400px;
  font-family: Tahoma, Geneva, sans-serif;
  font-size: 14px;
  font-style: italic;
  line-height: 24px;
  font-weight: bold;
  color: #09C;
  text-decoration: none;
  border-radius: 10px;
  padding: 10px;
  border: 1px solid #999;
  border: inset 1px solid #333;
  -webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
  -moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
}

input {
  width: 375px;
  display: block;
  border: 1px solid #999;
  height: 25px;
  -webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
  -moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
}

textarea#feedback {
  width: 375px;
  height: 150px;
  display: block;
}

submit {
  width: 100px;
  position: absolute;
  right: 20px;
  bottom: 20px;
  background: #09C;
  color: #fff;
  font-family: Tahoma, Geneva, sans-serif;
  height: 30px;
  border-radius: 15px;
  border: 1p solid #999;
}

input.submit:hover {
  background: #fff;
  color: #09C;
}
input[type=submit] {
    padding:5px 15px; 
    background:#fff; 
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
    color: #09C;
}
</style>

<script type="text/javascript" src="/assets/script/canvasjs.min.js"></script>
</head>
   
    <body>
        <h1>Daily Input</h1>
        <br>
        
        <form action="daily" method="post">
             <input type="hidden" name="id" value=${currentUser.idUser}>
             <input type="hidden" name="email" value="${currentUser.email}">
             
            <label>What did you eat?</label>
            <input type="text" name="mealName" required/><br>
            <label>Calorie count:</label>
            <input type="text" name="mealCals" required/><br>
            <label>Date</label> <br>
            <label>MM</label>
            <input type="text" name="mealMM" value = "${mon}" required/><br>
            <label>DD</label>
            <input type="text" name="mealDD" value = "${day}" required/><br>
            <label>YYYY</label>
            <input type="text" name="mealYYYY" value = "${yr}" required/><br>
           <%--
            It's ${mon} / ${day} / ${yr}
            <p>How many meals did you consume?
            <input type="radio" name="numMeals" value="1">1
            <input type="radio" name="numMeals" value="2">2
            <input type="radio" name="numMeals" value="3" checked>3
            <input type="radio" name="numMeals" value="4">4</p>
           --%>
            <input type="submit" value="Add Meal"/>
        </form>
            <br>
            ${exceed}
            <div id="chartContainer" style="height: 400px; width: 100%;"></div>
    </body>
</html>
