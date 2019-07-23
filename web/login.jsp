<%-- 
    Document   : index
    Created on : 24 Sep, 2017, 5:35:28 PM
    Author     : DELL
--%>

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
         <br><br>
    <center>
       
        <div class="container">
        <div class=" jumbotron"> 
        <form action="LoginServletURL" class="form-horizontal">
            <table  class="table">
             
                <%
                   
                    if(session.getAttribute("COUNT")==null)
                    {
                        session.setAttribute("COUNT", 1);
                    }

                   
                   String error=(String)session.getAttribute("ERROR_LOGIN_PAGE");
                   
                   Integer count=(Integer)session.getAttribute("COUNT");
                 
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
                  
                   
                      
                   
                  
                   session.removeAttribute("ERROR_LOGIN_PAGE");
                %>
              
               <tr>
                   <td align="right"> No of users:<%=count%></td>
               </tr>
                <tr>
                    
                    <td align="right" class="form-group"><b>UserName</b></td>
                    <td  class="form-group"><input tye="text" class="form-control" name="Username">
                        
                </tr>
               
              
                <tr>
                    <td align="right" class="form-group"><b>Password</b></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <td class="form-group"><input type="password" class="form-control" name="Password">
                </tr>
              
                <tr class="form-group">
                    <td align="center">AutoLogin
                        <input TYPE="text" name="AutoLogin">
                    </td>
                </tr>
               
                <tr class="form-group">
                    <td  align="center"><button type="submit" class="btn btn-primary btn-md">Login</button></td>
                </tr>
                <tr class="form-group">
                    <td colspan="2" align="center">
                      <a href="Register.jsp"> Register</a>
                    </td>
                </tr>
               
            </table>
        </form>
                </div>
                </div>
    </center>
    
    </body>
</html>
