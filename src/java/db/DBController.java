/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import book.BookData;
import java.sql.*;
import java.util.ArrayList;
import login.LoginData;

import register.RegisterData;

/**
 *
 * @author DELL
 */
public class DBController
{
    static int count=101;
    Connection connection=null;
    Statement statement=null;
    PreparedStatement preparedStatement=null;
    ResultSet result=null;
    
    public void insertIntoUser(RegisterData rd)
    {
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/finalproject?"+"user=root&password=root");
            statement=connection.createStatement();
            
            result=statement.executeQuery("select count(*) from user");
            String id="";
            
           while(result.next())
           {
               id=Integer.toString(result.getInt(1)+count);
           }
           
           String uid="UID_"+id;
            
            preparedStatement=connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
            
            preparedStatement.setString(1,uid);
            preparedStatement.setString(2,rd.getUserName());
            preparedStatement.setString(3,rd.getPassword());
            preparedStatement.setString(4,rd.getDateOfBirth());
            preparedStatement.setString(5,rd.getContactNo());
            preparedStatement.setString(6,rd.getEmailId());
            preparedStatement.setString(7,rd.getAge());
            preparedStatement.setString(8,rd.getAddress());
            preparedStatement.setString(9,rd.getGender());
            preparedStatement.executeUpdate();
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(result!=null)
                    result.close();
                if(connection!=null)
                    connection.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
    }
    
    public ArrayList<BookData> getAllBooks()
    {
        ArrayList<BookData> list=new ArrayList<BookData>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/finalproject?"+"user=root&password=root");
            statement=connection.createStatement();
            result=statement.executeQuery("select * from book");
            while(result.next())
            {
               BookData book=new BookData();
               book.setBookId(result.getString(1));
               book.setBookName(result.getString(2));
               book.setBookAuthor(result.getString(3));
               book.setBookEdition(result.getString(4));
               book.setBookPublication(result.getString(5));
               book.setBookPrice(result.getString(6));
               list.add(book);
              
               
            }
            
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(result!=null)
                    result.close();
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
        
        
        return list;
    }
    
    public ArrayList<LoginData> getusers()
    {
        ArrayList<LoginData> list=new ArrayList<LoginData>();
       
        
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/finalproject?"+"user=root&password=root");
            statement=connection.createStatement();
            result=statement.executeQuery("select uname,upassword from user");
            while(result.next())
            {
               LoginData validuser=new LoginData();
               //book.setBookId(result.getString(1));
               
               validuser.setUserName(result.getString(1));
               validuser.setPassword(result.getString(2));
               
               list.add(validuser);
              
               
            }
            
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(result!=null)
                    result.close();
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
       return list;  
    }
    
    
     public ArrayList<String> getUserData(String user) throws SQLException
    {
        ArrayList<String> userData=new ArrayList<String>();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/finalproject?"+"user=root&password=root");
            statement=connection.createStatement();
            result=statement.executeQuery("select uemail,ucontact,udob from user where uname='"+user+"'");
            
          
            
            while(result.next())         
            {
              userData.add(result.getString(1));
              userData.add(result.getString(2));
              userData.add(result.getString(3));
                
            }
            
           return userData;
            
            
        }
        
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
            
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            
            try
            {
                if(result!=null)
                    result.close();
                
                if(connection!=null)
                    connection.close();
            }
            
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
        return userData;
        
        
    }

}



