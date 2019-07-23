<%-- 
    Document   : error
    Created on : 24 Sep, 2017, 12:23:21 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error......</h1>
        
            <%
                
                String un=(String)session.getAttribute("USER_NAME");
                out.print("user name=="+un);
               
                ArrayList<String> list=(ArrayList<String>)session.getAttribute("USER_LIST");
                
               
            %>
            <table border="1">
                <%
                  for(int i=0;i<list.size();i++)
                  {
                %>
                <tr>
                    <td><%= i+1 +". "%></td>
                    <td><%= list.get(i)%></td>
                </tr>
                <%
                  }
                 %>
        </table>
    </body>
</html>
