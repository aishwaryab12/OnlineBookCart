/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;
import user.UserList;

/**
 *
 * @author DELL
 */
public class LoginServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.print("login Servlet called.....");
        
        //String username=request.getParameter("Username");
        //String password=request.getParameter("Password");
        
        LoginData ld=new LoginData();
        
        
        if(request.getParameter("Username")!=null && request.getParameter("Password")!=null)
        {
            ld.setUserName(request.getParameter("Username"));
            ld.setPassword(request.getParameter("Password"));
        }
        
        HttpSession session=request.getSession();
        
        String AutoLoginbox=request.getParameter("AutoLogin");
        
        Cookie[] cookies=request.getCookies();
        Cookie cookietodelete = null;
        boolean isAutoLoginCookieFound=false;
        String cookieValue=null;
        String temp=null;
        
        //
        //        ArrayList<String> list=new ArrayList<String>();
        //        list.add("ram");
        //        list.add("shyam");
        //
        //        session.setAttribute("USER_LIST", list);
        //
        if(cookies!=null)
        {
            for(int i=0;i<cookies.length;i++)
            {
                if(cookies[i].getName().equals("AutoLoginCookie"))
                {
                    isAutoLoginCookieFound=true;
                    cookieValue=cookies[i].getValue();
                    cookietodelete=cookies[i];
                    break;
                }
            }
        }
        
        if(cookieValue!=null)
        {
            ld.setUserName(cookieValue.split(",")[0]);
            ld.setPassword(cookieValue.split(",")[1]);
        }
        
        session.setAttribute("USER_NAME", ld.getUserName());
        session.setAttribute("USER_PASS", ld.getPassword());
        
        UserList objUserList=new UserList();
        ArrayList<LoginData> users=objUserList.getUserList();
        if(session.getAttribute("COUNT")==null)
        {
            session.setAttribute("COUNT", 1);
        }
        
        boolean status=false;
        
        if(isAutoLoginCookieFound!=false || AutoLoginbox!=null)
        {
            for(int i=0;i<users.size();i++)
            {
                if(users.get(i).getUserName().equals(ld.getUserName()) &&
                        users.get(i).getPassword().equals(ld.getPassword()))
                {
                    status=true;
                    break;
                }
            }
            if(status!=true)
            {
                session.setAttribute("ERROR_LOGIN_PAGE","incorrect username/password");
                RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
            
        }
        
        if(isAutoLoginCookieFound==false && AutoLoginbox==null)
        {
            RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        else if(isAutoLoginCookieFound==false &&AutoLoginbox.equalsIgnoreCase("no") &&status==true)
        {
            
            RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
            
        }
        else if(isAutoLoginCookieFound==false &&AutoLoginbox.equalsIgnoreCase("yes") &&status==true )
        {
            Cookie newCookie=new Cookie("AutoLoginCookie", request.getParameter("Username")+","+request.getParameter("Password"));
            newCookie.setMaxAge(60*60*365);
            response.addCookie(newCookie);
            
            RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
            
        }
        else if(isAutoLoginCookieFound==true && AutoLoginbox==null &&status==true )
        {
            RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
            
        }
        else if(isAutoLoginCookieFound==true && AutoLoginbox.equalsIgnoreCase("no"))
        {
            cookietodelete.setMaxAge(0);
            response.addCookie(cookietodelete);
            RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
        }
     
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
