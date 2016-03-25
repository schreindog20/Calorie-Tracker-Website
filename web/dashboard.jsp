<%-- 
    Document   : dashboard
    Created on : Feb 28, 2016, 6:46:34 PM
    Author     : Odz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:import url="/includes/header.jsp" />


<!DOCTYPE HTML>
<html>
<head>
      <link rel="stylesheet" href="styles/main.css" type="text/css"/>
<script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
	window.onload = function () {
		var chart = new CanvasJS.Chart("chartContainer",
		{
			zoomEnabled: false,
                        animationEnabled: true,
			title:{
				text: "Calorie Timeline (Last 7 Days)"
			},
			axisY2:{
                    <%--valueFormatString:"0.0 bn",
				
				maximum: 1.2,
				interval: .2,
                    --%>
				interlacedColor: "#F5F5F5",
				gridColor: "#D7D7D7",      
	 			tickColor: "#D7D7D7"								
			},
                        theme: "theme2",
                        toolTip:{
                                shared: true
                        },
			legend:{
				verticalAlign: "bottom",
				horizontalAlign: "center",
				fontSize: 15,
				fontFamily: "Lucida Sans Unicode"

			},
			data: [
			{   
                            
				type: "line",
				lineThickness:3,
				axisYType:"secondary",
				showInLegend: true,           
				name: "Calories", 
				dataPoints: [
                                    
                 <%-- TODO: change userList to mealList of the current user. Fill in appropriate dates
                 Make another line with the same dates but as the user's goal as their goal line
                 --%>
                                    
                                <c:forEach items="${mealListByDay7}" var="meal" varStatus="status">
				{ x: new Date(${meal.YYYY}, ${meal.MM}-1, ${meal.DD}), y: ${meal.calories} }
                                        <c:if test="${not (status.count eq listSize)}">,</c:if>
                                </c:forEach>    
				]
			}<%--,
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "China",
				axisYType:"secondary",
				dataPoints: [
				{ x: new Date(2001, 00), y: 0.18 },
				{ x: new Date(2002, 00), y: 0.2 },
				{ x: new Date(2003, 0), y: 0.25},
				{ x: new Date(2004, 0), y: 0.35 },
				{ x: new Date(2005, 0), y: 0.42 },
				{ x: new Date(2006, 0), y: 0.5 },
				{ x: new Date(2007, 0), y: 0.58 },
				{ x: new Date(2008, 0), y: 0.67  },
				{ x: new Date(2009, 0), y: 0.78},
				{ x: new Date(2010, 0), y: 0.88 },
				{ x: new Date(2011, 0), y: 0.98 },
				{ x: new Date(2012, 0), y: 1.04 }


				]
			} --%>,
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "Goal",        
				axisYType:"secondary",
				dataPoints: [
				<c:forEach items="${mealListByDay7}" var="meal" varStatus="status">
				{ x: new Date(${meal.YYYY}, ${meal.MM}-1, ${meal.DD}), y: ${currentUser.goal} }
                                        <c:if test="${not (status.count eq listSize)}">,</c:if>
                                </c:forEach>                                   
                                            
                                                 <%-- get last meal and put it here--%>
				




				]
			}



                        
                                        ],
        
legend: {
            cursor:"pointer",
            itemclick : function(e) {
              if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
              e.dataSeries.visible = false;
              }
              else {
                e.dataSeries.visible = true;
              }
              chart.render();
            }
          }
        });

chart.render();

var chart = new CanvasJS.Chart("chartContainer2",
		{
			zoomEnabled: false,
                        animationEnabled: true,
			title:{
				text: "Calorie Timeline (Last 30 Days)"
			},
			axisY2:{
                    <%--valueFormatString:"0.0 bn",
				
				maximum: 1.2,
				interval: .2,
                    --%>
				interlacedColor: "#F5F5F5",
				gridColor: "#D7D7D7",      
	 			tickColor: "#D7D7D7"								
			},
                        theme: "theme2",
                        toolTip:{
                                shared: true
                        },
			legend:{
				verticalAlign: "bottom",
				horizontalAlign: "center",
				fontSize: 15,
				fontFamily: "Lucida Sans Unicode"

			},
			data: [
			{   
                            
				type: "line",
				lineThickness:3,
				axisYType:"secondary",
				showInLegend: true,           
				name: "Calories", 
				dataPoints: [
                                    
                 <%-- TODO: change userList to mealList of the current user. Fill in appropriate dates
                 Make another line with the same dates but as the user's goal as their goal line
                 --%>
                                    
                                <c:forEach items="${mealListByDay30}" var="meal" varStatus="status">
				{ x: new Date(${meal.YYYY}, ${meal.MM}-1, ${meal.DD}), y: ${meal.calories} }
                                        <c:if test="${not (status.count eq listSize)}">,</c:if>
                                </c:forEach>    
				]
			}<%--,
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "China",
				axisYType:"secondary",
				dataPoints: [
				{ x: new Date(2001, 00), y: 0.18 },
				{ x: new Date(2002, 00), y: 0.2 },
				{ x: new Date(2003, 0), y: 0.25},
				{ x: new Date(2004, 0), y: 0.35 },
				{ x: new Date(2005, 0), y: 0.42 },
				{ x: new Date(2006, 0), y: 0.5 },
				{ x: new Date(2007, 0), y: 0.58 },
				{ x: new Date(2008, 0), y: 0.67  },
				{ x: new Date(2009, 0), y: 0.78},
				{ x: new Date(2010, 0), y: 0.88 },
				{ x: new Date(2011, 0), y: 0.98 },
				{ x: new Date(2012, 0), y: 1.04 }


				]
			} --%>,
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "Goal",        
				axisYType:"secondary",
				dataPoints: [
				<c:forEach items="${mealListByDay30}" var="meal" varStatus="status">
				{ x: new Date(${meal.YYYY}, ${meal.MM}-1, ${meal.DD}), y: ${currentUser.goal} }
                                        <c:if test="${not (status.count eq listSize)}">,</c:if>
                                </c:forEach>                                   
                                            
                                                 <%-- get last meal and put it here--%>
				




				]
			}



                        
                                        ],
        
legend: {
            cursor:"pointer",
            itemclick : function(e) {
              if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
              e.dataSeries.visible = false;
              }
              else {
                e.dataSeries.visible = true;
              }
              chart.render();
            }
          }
        });

chart.render();

var chart = new CanvasJS.Chart("chartContainer3",
		{
			zoomEnabled: false,
                        animationEnabled: true,
			title:{
				text: "Calorie Timeline (All Time)"
			},
			axisY2:{
                    <%--valueFormatString:"0.0 bn",
				
				maximum: 1.2,
				interval: .2,
                    --%>
				interlacedColor: "#F5F5F5",
				gridColor: "#D7D7D7",      
	 			tickColor: "#D7D7D7"								
			},
                        theme: "theme2",
                        toolTip:{
                                shared: true
                        },
			legend:{
				verticalAlign: "bottom",
				horizontalAlign: "center",
				fontSize: 15,
				fontFamily: "Lucida Sans Unicode"

			},
			data: [
			{   
                            
				type: "line",
				lineThickness:3,
				axisYType:"secondary",
				showInLegend: true,           
				name: "Calories", 
				
        dataPoints: [ 
                    <c:forEach items="${mealListByDay}" var="meal" varStatus="status">
    { x: new Date(${meal.YYYY}, ${meal.MM}-1, ${meal.DD}), y: ${meal.calories} }
    <c:if test="${not (status.count eq listSize)}">,</c:if>
                    </c:forEach> 
]
			}<%--,
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "China",
				axisYType:"secondary",
				dataPoints: [
				{ x: new Date(2001, 00), y: 0.18 },
				{ x: new Date(2002, 00), y: 0.2 },
				{ x: new Date(2003, 0), y: 0.25},
				{ x: new Date(2004, 0), y: 0.35 },
				{ x: new Date(2005, 0), y: 0.42 },
				{ x: new Date(2006, 0), y: 0.5 },
				{ x: new Date(2007, 0), y: 0.58 },
				{ x: new Date(2008, 0), y: 0.67  },
				{ x: new Date(2009, 0), y: 0.78},
				{ x: new Date(2010, 0), y: 0.88 },
				{ x: new Date(2011, 0), y: 0.98 },
				{ x: new Date(2012, 0), y: 1.04 }


				]
			} --%>,
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "Goal",        
				axisYType:"secondary",
				dataPoints: [
				<c:forEach items="${mealListByDay}" var="meal" varStatus="status">
				{ x: new Date(${meal.YYYY}, ${meal.MM}-1, ${meal.DD}), y: ${currentUser.goal} }
                                        <c:if test="${not (status.count eq listSize)}">,</c:if>
                                </c:forEach>                                   
                                            
                                                 <%-- get last meal and put it here--%>
				




				]
			}



                        
                                        ],
        
legend: {
            cursor:"pointer",
            itemclick : function(e) {
              if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
              e.dataSeries.visible = false;
              }
              else {
                e.dataSeries.visible = true;
              }
              chart.render();
            }
          }
        });

chart.render();
}

</script>
  <script type="text/javascript" src="/assets/script/canvasjs.min.js"></script>
  
  
</head>
<h1>Dashboard</h1>
<body>
     <br><br>
 
	<div id="chartContainer" style="height: 300px; width: 100%;">
	</div>
    <div id="chartContainer2" style="height: 300px; width: 100%;">
	</div>
    <div id="chartContainer3" style="height: 300px; width: 100%;">
	</div>
</body>
</html>
