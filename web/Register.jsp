<%-- 
    Document   : Register
    Created on : 24 Sep, 2017, 5:41:23 PM
    Author     : DELL
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <br><br><br>
        <div class="container">
        <div class=" jumbotron"> 
       <form action="RegisterServletURL">
            <table  class="table table-hover">
                <%
                    StringBuffer error=(StringBuffer)session.getAttribute("REGISTER_ERRORS");
                    if(error!=null)
                    {
                %>
                <tr>
                    <td align="center" colspan="2" class="alert alert-danger">
                        <%=error%>
                    </td>
                </tr>
                <%
                    }
                session.removeAttribute("REGISTER_ERRORS");
                %>
                <tr>
                    <td align="center" colspan="2" class="form-group"> Registration Form</td>
                </tr>
                
                <tr>
                    <td align="right" class="form-group"> UserName</td>
                    <td class="form-group"><input type="text" class="form-group" name="Username">
                </tr>
                
                <tr>
                    <td align="right" class="form-group">DOB</td>
                    <td class="form-group"><input type="text" class="form-group" name="DOB">
                </tr>
                <tr>
                    <td align="right" class="form-group">Age</td>
                     <td class="form-group"><input type="text" class="form-group" name="Age" value="123" readonly>
                </tr>
                
                <tr >
                    <td align="right" class="form-group"> Gender </td>
                      <td  class="form-group">
                      <input type="radio" name="gender" value="male"> Male
                      <input type="radio" name="gender" value="female"> Female
                      <input type="radio" name="gender" value="other"> Other 
                      </td>
                </tr>
                 <tr>
                    <td align="right" class="form-group">Address</td>
                     <td class="form-group"><input type="text" class="form-group" name="Address">
                </tr>
                
                <tr>
                    <td align="right" class="form-group">Email</td>
                    <td class="form-group"><input type="text" class="form-group" name="Email">
                </tr>
                
                <tr>
                    <td align="right" class="form-group">Contact No.</td>
                    <td class="form-group"><input type="text" class="form-group" name="Contact_No">
                </tr>
                <tr>
                    <td align="right" class="form-group">Password</td>
                    <td class="form-group"><input type="text" class="form-group" name="Password">
                </tr>
                 <tr>
                    <td align="right" class="form-group">Confirm Password</td>
                    <td class="form-group"><input type="text" class="form-group" name="Confirm_Password">
                </tr>
                 <tr>
                     <%
                     Random rand = new Random();
                     int rand_int1 = rand.nextInt(1000);
                    
                     %>
                     <td align="right" class="form-group">        </td>
                    <td class="form-group"><input type="text" class="form-group" name="cap" value="<%= rand_int1 %>" readonly>
                </tr>
                    <td align="right" class="form-group">Enter content shown as it is: </td>
                    <td class="form-group"><input type="text" class="form-group" name="cap_enter">
                <tr>
                </tr>
                
                <tr>
                    <td align="center" colspan="2" class="form-group"> <button type="submit" class="btn btn-primary btn-md">Register</button></td>
                </tr>  
                
               
            </table>
        </form>
        </div>
        </div>
    </body>
</html>
