<%-- 
    Document   : settings
    Created on : Feb 28, 2016, 7:40:34 PM
    Author     : Odz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:import url="/includes/header.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <style>
            form {
  background: -webkit-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
  background: -moz-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
  background: linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);

  width: 250px;
  height: 30px;
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

button {
  width: 200px;
 
  right: 20px;
  bottom: 20px;
  background: #09C;
  color: #fff;
  font-family: Tahoma, Geneva, sans-serif;
  height: 30px;
  border-radius: 15px;
  border: 1p solid #999;
}

input.button:hover {
  background: #fff;
  color: #09C;
}

move {
    font-family: Tahoma, Geneva, sans-serif;
  font-size: 20px;
  font-style: bold;
  color: #09C;
}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Settings</title>
    </head>
    <body>
        <h1>Settings</h1>
        
    <move>First Name: ${currentUser.firstName}</move> <br> 
        
        <form action="changeFName" method="post" id = "changeFName">      
           
                 <input type="hidden" name="id" value=${currentUser.idUser}>
                 <input type="text" name="FName" value="Enter New First Name">
                 </form>
                <button type="submit" form="changeFName" value="Submit">Change First Name</button>
                <br><br>
                
                <move>Last Name: ${currentUser.lastName}</move>  <br>
        <form action="changeLName" method="post" id = "changeLName">              
                 <input type="hidden" name="id" value=${currentUser.idUser}>
                 <input type="text" name="LName" value="Enter New Last Name">
                 </form>
                <button type="submit" form="changeLName" value="Submit">Change Last Name</button>
                <br><br>
                
                 <move>Password: ${currentUser.password}</move>  <br>
        <form action="changePW" method="post" id = "changePW">              
                 <input type="hidden" name="id" value=${currentUser.idUser}>
                 <input type="text" name="PW" value="Enter New Password">
                 </form>
                <button type="submit" form="changePW" value="Submit">Change Password</button>
                <br><br>
                
                 <move>Daily Calorie Goal: ${currentUser.goal}</move>  <br>
        <form action="changeGoal" method="post" id = "changeGoal">              
                 <input type="hidden" name="id" value=${currentUser.idUser}>
                 <input type="text" name="goal" value="Enter New Goal">
                 </form>
                <button type="submit" form="changeGoal" value="Submit">Change Calorie Goal</button>
                <br>
       
    </body>
</html>
