<%-- 
    Document   : admin
    Created on : Feb 28, 2016, 4:41:31 PM
    Author     : Odz
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
 <head>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
  
        <h1>Admin Page</h1>
        
         <table>
            <tr>
                <th>userID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>email</th>
                <th>password</th>
                <th>calorie goal</th>
                <th>clearance</th>  
                
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>
                        ${user.idUser}
                    </td>
                    <td class="right">
                        ${user.firstName}
                    </td>
                     <td class="right">
                        ${user.lastName}
                    </td>
                      <td class ="right">
                        ${user.email}
                    </td>
                    <td class="right">
                        ${user.password}
                    </td>
                     <td class="right">
                        ${user.goal}
                    </td>
                     <td class="right">
                        ${user.clearance}
                    </td>
                   <td class ="right">
                        
             
                       <form action="deleteUser" method="post" id = "delete ${user.idUser}">                   
                           <input type="hidden" name="id" value=${user.idUser}>                 
                       </form>                
                           <button type="submit" form="delete ${user.idUser}" value="Submit">Delete ${user.idUser}</button> 
              <%--     <input type ="button" onclick="formSubmit()" value ="delete ${meal.mealid}"> --%>
        
                        
                    </td>
                     <td class ="right">
                        
             <form action="makeAdmin" method="post" id = "makeAdmin ${user.idUser}">  
                 <input type="hidden" name="id" value=${user.idUser}>
                 </form>
                <button type="submit" form="makeAdmin ${user.idUser}" value="Submit">makeAdmin ${user.idUser}</button> 
              <%--     <input type ="button" onclick="formSubmit()" value ="delete ${meal.mealid}"> --%>
        
                        
                    </td>
                </tr>
                
                
            </c:forEach>             
             
        </table>
        
 
</html>
