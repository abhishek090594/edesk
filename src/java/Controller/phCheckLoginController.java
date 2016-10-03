/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.phCheckLoginModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SOHIL
 */
public class phCheckLoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        try {
            ResultSet rs;
            String emailid = request.getParameter("txtemailid");
            String pwd = request.getParameter("txtpassword");
            out.println(emailid + "." + pwd);
           phCheckLoginModel sclm = new phCheckLoginModel();
            sclm.setEmail(emailid);
            sclm.setPassword(pwd);
        
            rs = sclm.phcheckForLogin();
                         
            if(rs.next())
        //    if(u.equals("sohil") && p.equals("rush"))
            {
               HttpSession sobj = request.getSession(true);
                sobj.setAttribute("ph_id_is_logged_in",rs.getString("ph.ph_id"));
                sobj.setAttribute("ph_is_logged_in",emailid);
                response.sendRedirect("phViewDashboardController");
            }
            else
            {          //    out.println("Sry");

               request.setAttribute("err","Wrong Email-ID or Password");
                RequestDispatcher robj = request.getRequestDispatcher("phLoginController");
                robj.forward(request, response);
           }
            
        } catch (Exception e) {
            out.println("Controller Eror : " +e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
