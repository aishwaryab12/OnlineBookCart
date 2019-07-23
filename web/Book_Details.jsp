<%-- 
    Document   : Book_Details
    Created on : 24 Sep, 2017, 5:42:39 PM
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
        <br><br><br><br>
        
            <table class="table table-hover">
                <tr>
                    <td>
                        <%String book_id=request.getParameter("ID");%>
                    </td>
                </tr>
                <tr class="info">
                    <td class="warning" colspan="2">
                      <%String username=(String)session.getAttribute("USER_NAME");%>
                      <h4><span class="glyphicon glyphicon-user"></span>&nbsp;<%=username%></h3>
                    </td>
                     <form action="URLController">
                    <td> <h4><a href="Cart.jsp">Cart</a></h4></td>
                    <td> <h4><input type="submit" value="Buy" Name="Buy"></h4></td>
                    <td> <h4><a href="logout.jsp">logout</a></h4></td>
                     
                </tr>
               
                <%
                    BookList objlist=new BookList();
                    ArrayList<BookData> book=objlist.getBookList();
                    for(int i=0;i<book.size();i++)
                    {
                        if(book.get(i).getBookId().equals(book_id))
                        {
                            
                    %>
                    
                        
                        <tr>
                        <td colspan="4">Book Name: </td><td><%=book.get(i).getBookName()%></td>
                        </tr>
                        <tr>
                        <td colspan="4">Book Author:</td><td> <%=book.get(i).getBookAuthor()%></td>
                        </tr>
                        <tr>
                        <td colspan="4">Book Publication:</td><td> <%=book.get(i).getBookPublication()%></td>
                        </tr>
                        <tr>
                        <td colspan="4">Book Edition :</td><td> <%=book.get(i).getBookEdition()%></td>
                        </tr>
                        <tr>
                        <td colspan="4">Book Price:</td><td> <%=book.get(i).getBookPrice()%></td>
                        </tr>
                    <tr>  
                
                   
                    <input type="hidden" name="ID" value="<%= book.get(i).getBookId()%>" />
                    </tr>
                     
                     
                    <tr>
                    <td colspan="5" align="center"> <a href="Home.jsp"><input type="button" value="Back to Purchase"></a></input></td>
                    </tr>
                    <tr>
                    <td  colspan="5" align="center"> <input type="submit" value="Add to Cart" name="AddtoCart"></td>
                    </tr>
                 </form>

                <%
                        }
                    }
                %>
     </table>
     </body>
     </html>
