<%-- 
    Document   : logout
    Created on : 7 Oct, 2017, 5:51:15 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>YOU ARE LOGOUT !</h1>
        <%
            Integer visitcount;
            visitcount=(Integer) session.getAttribute("COUNT");
           visitcount++;
           session.setAttribute("COUNT", visitcount);
           
           
         Cookie[] cookies=request.getCookies();
        
           if(cookies!=null)
        {
            for(int i=0;i<cookies.length;i++)
            {
                if(cookies[i].getName().equals("AutoLoginCookie"))
                {
                  
                   cookies[i].setMaxAge(0);
                   response.addCookie(cookies[i]);
                    break;
                }
            }
        }
          
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
