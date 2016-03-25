<%-- 
    Document   : header
    Created on : Feb 8, 2016, 11:17:02 AM
    Author     : Kathy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CS3520 Assignment 3</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <style>
a:link, a:visited {
    background-color: #f44336;
    color: white;
    
    text-align: center;
    text-decoration: none;
    display: inline-block;
}

a:hover, a:active {
    background-color: red;
}
</style>
    </head>
    
   
  <a href="admin.jsp">${admin}</a>
<a href="dashboard.jsp">Dashboard</a>
<a href="daily.jsp">Daily Input</a>
<a href="settings.jsp">Settings</a>
    
    
    <%--
    <body>
        <div class="content">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
        <c:if test="${user.firstName.isEmpty() == false}">
            <p class="head">Logged in as ${user.firstName} ${user.lastName}</p><br>
        </c:if>        
--%>