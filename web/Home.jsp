<%-- 
    Document   : Home
    Created on : 24 Sep, 2017, 5:43:07 PM
    Author     : DELL
--%>

<%@page import="book.BookData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="book.BookList"%>
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
        <%
            BookList objlist=new BookList();
                    ArrayList<BookData> book=objlist.getBookList();
        %>
        <br><br><br>
      
            <div class="container">
            <table class="table table-striped table-bordered table-condensed">
<!--                <tr>
                 <td><a href="Book_Details.jsp"> LetusC </a></td>
                <td align="center" colspan="2"> <input type="submit" name="Submit" value="Add"></td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><a href="Buy.jsp"><input type="button" value="Buy"></input></a></td>
                </tr>-->

                <tr class="info">
                    <td class="warning">
                      <%String username=(String)session.getAttribute("USER_NAME");%>
                      <h4><span class="glyphicon glyphicon-user"></span>&nbsp;<%=username%></h3>
                    </td>
                    <td><h4><span class="glyphicon glyphicon-shopping-cart"> <a href="Cart.jsp">Cart</a></h4></td>
                    <td> <h4><a href="Buy.jsp">Buy</a></h4></td>
                    <td><h4><span class="glyphicon glyphicon-log-out"> <a href="logout.jsp">logout</a></h4></td>
                    
                </tr>
                <tr>
                    <td><b>SR.NO</b></td>
                    <td><b>Name</b></td>
                    <td><b>Price</b></td>
                </tr>
                <%
                    
                    for(int i=0;i<book.size();i++)
                    {
                    %>
                    <tr>
                        <td> <%=i+1%></td>
                        <td><%=book.get(i).getBookName()%></td>
                        <td><%=book.get(i).getBookPrice()%></td>
                        <td>
                            <form action="URLController">
                                <input type="text" name="ID" value="<%= book.get(i).getBookId()%>" />
                                <input type="submit" name="BookDetail" value="Book Detail" />
                                <input type="submit" name="AddtoCart" value="Add to Cart" />
                                <input type="submit" name="Buy" value="Buy" />
                            </form>
                        </td>
                    </tr>
                <%
                    }
                %>
                
                <tr>
                    <td colspan="4" align="center">
                        <a href="Buy.jsp"><h4>BUY</h4></a>
                    </td>
                </tr>
                </div>
            </table>
       
    </body>
</html>
