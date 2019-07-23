<%-- 
    Document   : Buy
    Created on : 24 Sep, 2017, 5:44:41 PM
    Author     : DELL
--%>

<%@page import="db.DBController"%>
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
        <form >
            <table class="table table-hover">
    
    <%
    
    ArrayList<String> cartlist=(ArrayList<String>)session.getAttribute("CART_LIST");
    BookList objBookList=new BookList();
    ArrayList<BookData> books=objBookList.getBookList();
    String userName=(String)session.getAttribute("USER_NAME");
    StringBuffer productList=new StringBuffer();
    int totalPrice=0;
     ArrayList<String> userData=new ArrayList<String>();
     DBController objDBController=new DBController();
     userData=objDBController.getUserData(userName);
     //String id=(String)session.getAttribute("BOOK_ID_TO_BUY");
     String id;
     id=request.getParameter("ID");
     int qty=0;
     
  if(id!=null)
   {
     for(int i=0;i<books.size();i++)
     {
         if(id.equals(books.get(i).getBookId()))
         {
              productList.append(books.get(i).getBookName()+",");
              totalPrice=(Integer.parseInt(books.get(i).getBookPrice()));
              qty=1;
              break;
         }
     }
        // session.removeAttribute("BOOK_ID_TO_BUY");
   }
  else
   {
       request.setAttribute("a", 1);
       
    if(cartlist!=null)
    {
        qty=cartlist.size();
    for(int i=0;i<cartlist.size();i++)
             {
                 for(int j=0;j<books.size();j++)
                 {
                   if(cartlist.get(i).equals(books.get(j).getBookId()))
                   {
                      productList.append(books.get(j).getBookName()+",");
                      totalPrice=totalPrice+(Integer.parseInt(books.get(j).getBookPrice()));
                      break;    
                   }
                 }

             }
    }
   }
  
  
    
    if(cartlist!=null || id!=null)
    {
       
        
       
    %>
      
            <tr>
                <td><%=userName%></td>
                <td colspan="2">Order Details</td>
            </tr>
             <tr class="info">
                <th>Product List</th>
                <th>Qty.</th>
                <th>Total Amount</th>
            </tr>
            <tr>
                <td><%=productList%></td>
                <td><%=qty%></td>
                <td><%=totalPrice%></td>

            </tr>
            <%}
   
        
     else
    {
      %>
           <tr class="warning">
                 <td colspan="3" align="center"><b>Nothing to Purchase.<b></td>   
            </tr>
             
            <%   
        
    }
   
            %>
          
   
            <tr class="info">
                 <td colspan="3" align="center"><b>Customer Details<b></td>   
            </tr>
            
            <tr>
                <th>Email:</th>
                <td colspan="2"><%=userData.get(0)%></td>   
            </tr> 
             <tr>
                <th>Contact:</th>
                <td colspan="2"><%=userData.get(1)%></td>   
            </tr>
            <tr>
                <th>Date Of Birth:</th>
                <td colspan="2"><%=userData.get(2)%></td>   
            </tr>  
            <tr>
                    <td align="center"> <a href="Home.jsp"><input type="button" value="Cancel"></a></td>
                
                    <td align="center"><a href="BuySuccess.jsp"> <input type="button" value="Buy" name="Buy"></a></td>
                </tr>
                <%
                    
                %>
             
             
            </table>
        </form>
    </body>
</html>
