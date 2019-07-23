/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class URLController extends HttpServlet {
    
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
        String id,book_detail,add_to_cart,buy;
        id=request.getParameter("ID");
        
        book_detail=request.getParameter("BookDetail");
        add_to_cart=request.getParameter("AddtoCart");
        buy=request.getParameter("Buy");
        
        if(book_detail!=null)
        {
            //out.print("book_detail");
            RequestDispatcher rd=request.getRequestDispatcher("Book_Details.jsp");
            rd.forward(request, response);
        }
        if(add_to_cart!=null)
        {
            //out.print("add");
            RequestDispatcher rd=request.getRequestDispatcher("cartServletURL");
            rd.forward(request, response);
        }
        if(buy!=null)
        {
            //session.setAttribute("BOOK_ID_TO_BUY", id);
            RequestDispatcher rd=request.getRequestDispatcher("Buy.jsp");
            rd.forward(request, response);
            //out.print("buy");
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
