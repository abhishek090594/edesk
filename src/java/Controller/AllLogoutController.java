/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SOHIL
 */
public class AllLogoutController extends HttpServlet {

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
        try  {
            /* TODO output your page here. You may use following sample code. */
              HttpSession sobj = request.getSession(false);
                            if(sobj != null)
                            {
                               
                                if(sobj.getAttribute("Stf_is_logged_in") != null && request.getParameter("str").equals("s"))
                                {
                                    sobj.removeAttribute("Stf_id_is_logged_in");               
                                    sobj.removeAttribute("Stf_is_logged_in");
                                   response.sendRedirect(request.getContextPath()+"/StfLoginController");
                                }
                                
                               else if(sobj.getAttribute("ph_is_logged_in") != null && sobj.getAttribute("ph_id_is_logged_in") != null && request.getParameter("str").equals("p"))
                                {
                                    sobj.removeAttribute("ph_is_logged_in");
                                    sobj.removeAttribute("ph_id_is_logged_in");
                                   response.sendRedirect(request.getContextPath()+"/phLoginController");
                                }

                            else if(sobj.getAttribute("Dir_is_logged_in") != null && sobj.getAttribute("Dir_id_is_logged_in") != null && request.getParameter("str").equals("d"))
                                {
                                    sobj.removeAttribute("Dir_is_logged_in");
                                    sobj.removeAttribute("Dir_id_is_logged_in");
                                   response.sendRedirect(request.getContextPath()+"/DirViewLogin");
                                }
                            
                            
                            
                            
                            }
                            
                      
        }
        catch(Exception e)
        {
            out.println("Error in AllLogoutController"+ e);
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
