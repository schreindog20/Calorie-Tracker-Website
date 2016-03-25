<%-- 
    Document   : signup
    Created on : Feb 27, 2016, 11:47:20 PM
    Author     : Odz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
  height: 300px;
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the Calorie Counter 3000</title>
    </head>
    
    <h2>Looks like your email isn't on file. <br> Let us get to know you.</h2>
    <body>
       
     <form action="signup" method="post">
         <input type="hidden" name="email" value=${email}>
         <input type="hidden" name="password" value=${pw}>
            <label>First Name</label>
            <input type="text" name="FName" required/><br>
            <label>Last Name</label>
            <input type="text" name="LName" required/><br>
            <label>Daily Calorie Goal</label>
            <input type="text" name="Goal" required/><br>
            
           <%--
            <p>How many meals did you consume?
            <input type="radio" name="numMeals" value="1">1
            <input type="radio" name="numMeals" value="2">2
            <input type="radio" name="numMeals" value="3" checked>3
            <input type="radio" name="numMeals" value="4">4</p>
           --%>
            <input type="submit" value="Sign Up"/>
        </form>
    </body>
</html>
