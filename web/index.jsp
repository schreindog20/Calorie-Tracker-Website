<%-- 
    Document   : index
    Created on : Feb 8, 2016, 11:10:36 AM
    Author     : Kathy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
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
  width: 550px;
  height: 200px;
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
</head>
        <h1>Calorie Tracker 3000</h1>
     
        <h2>Log in / Sign Up</h2>
      
        <form action="login" method="post">
            <label>Email</label>
            <input type="text" name="email" required/><br>
            <label>Password</label>
            <input type="password" name="password" required/><br>
       
            <input type="submit" value="Login / Sign Up"/>
        </form>
            ${pwError}
      
