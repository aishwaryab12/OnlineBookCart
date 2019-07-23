<%-- 
    Document   : Cart
    Created on : 24 Sep, 2017, 5:44:27 PM
    Author     : DELL
--%>

<%@page import="book.BookData"%>
<%@page import="book.BookList"%>
<%@page import="java.util.ArrayList"%>
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
        <br><br><br><br>
        <%
            ArrayList<String> cartlist=( ArrayList<String>)session.getAttribute("CART_LIST");
                  BookList objlist=new BookList();
                  ArrayList<BookData> book=objlist.getBookList();  
                  if(cartlist!=null)
                  {
        %>
       
            <table class="table table-striped table-bordered table-condensed">
                <tr class="info">
                    <td class="warning" colspan="3">
                      <%String username=(String)session.getAttribute("USER_NAME");%>
                      <h4><span class="glyphicon glyphicon-user"></span>&nbsp;<%=username%></h3>
                    </td>
                    
                    
                </tr>
               <tr>
                    <td><b>SR.NO</b></td>
                    <td><b>Name</b></td>
                    <td><b>Price</b></td>
                </tr>
                   
                <%
                  
                      
                  for(int i=0;i<cartlist.size();i++)
                  {
                %>
               <tr> 
                   <%
                    for(int j=0;j<book.size();j++)
                    {
                        if(cartlist.get(i).equals(book.get(j).getBookId()))
                        {
                   %>
                <td> <%= i+1 +". "%>  
               
                   
                </td>
                <td>
                    <%=book.get(j).getBookName()%>
                </td>
                <td><%=book.get(j).getBookPrice()%></td>
               </tr>   
                <%
                            break;
                        }
                    }
                  }
                %>
                        
                
               
                <tr>
                   <form action="EmptyCartServletURL">
                    <td align="center"> <a href="Home.jsp"><input type="button" name="AddMore" value="Add More">,</a></input></td>
                   
                    <td align="center"><a  href="Buy.jsp"> <input type="button" value="Buy"></a></input></td>
                    
                    <td align="center"><input type="Submit" value="Empty Cart"></input></td>
                    </form>
                </tr>
                 </table>
                    <%
                  }
                    else
                  {
                   %>
                   <table class="table table-striped table-bordered table-condensed">
                       <tr>
                           <td colspan="4"> CART IS EMPTY</td>
                           </tr>
                   </table>
                   <%
                      
                  }
                    %>
                    
                
           
        
    </body>
</html>
