/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import db.DBController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import validation.FormValidator;

/**
 *
 * @author DELL
 */
public class RegisterServlet extends HttpServlet {
    
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
        HttpSession session=request.getSession();  
        RegisterData registerobj=new RegisterData();
        
        registerobj.setUserName(request.getParameter("Username"));
        registerobj.setPassword(request.getParameter("Password"));
        registerobj.setConfirmPassword(request.getParameter("Confirm_Password"));
        registerobj.setContactNo(request.getParameter("Contact_No"));
        registerobj.setDateOfBirth(request.getParameter("DOB"));
        registerobj.setEmailId(request.getParameter("Email"));
        registerobj.setAddress(request.getParameter("Address"));
        registerobj.setAge(request.getParameter("Age"));
        registerobj.setGender(request.getParameter("gender"));
        
      
        String captcha=request.getParameter("cap");
        String captcha_enter=request.getParameter("cap_enter");
       
        StringBuffer error=is_valid_data(registerobj,captcha,captcha_enter);
          
        if(error.length()==0)
        {
            DBController dbobj=new DBController();
            dbobj.insertIntoUser(registerobj);
            RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
            rd.forward(request, response);
        }
        else
        {
           // HttpSession session=request.getSession();
            session.setAttribute("REGISTER_ERRORS", error);
             RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
            rd.forward(request, response);
            
           
        }
        
    }
    
    StringBuffer is_valid_data(RegisterData rdobj,String captcha,String captcha_enter)
    {
        StringBuffer errors=new StringBuffer();
        
        FormValidator fvobj=new FormValidator();
       
        
        if(fvobj.isValidUserName(rdobj.getUserName())!=true)
        {
            errors.append("invalid username  ");
        }
        if(fvobj.isValidEmailID(rdobj.getEmailId())!=true)
        {
            errors.append("invalid Email-ID  ");
        }
        if((fvobj.isValidPassword(rdobj.getPassword()).equals("invalid")))
        {
            errors.append("invalid password  ");
        }
        if(fvobj.isValidContact(rdobj.getContactNo())!=true)
        {
            errors.append("invalid contact no  ");
        }
        if(fvobj.isValidDOB(rdobj.getDateOfBirth())!=true)
        {
            errors.append("invalid date of birth  ");
        }
        if(fvobj.isvalidaddress(rdobj.getAddress())!=true)
        {
            errors.append("invalid address");
        }
        if(captcha.equals(captcha_enter)!=true)
        {
             errors.append("entered captcha is invalid"); 
        }
        
        return errors;
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
