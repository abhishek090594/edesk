/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.DirAddTaskAssignModel;
import java.util.Date;
/**
 *
 * @author SOHIL
 */
public class DirAddTaskAssignController extends HttpServlet {

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
        ResultSet rs = null;
         RequestDispatcher robj =null;
       try {
           
           String sdate = request.getParameter("sdate");
           String edate = request.getParameter("edate");
           String desc = request.getParameter("txtdesc");
           int panel_id = Integer.parseInt(request.getParameter("slctpanel"));

           DirAddTaskAssignModel datam = new DirAddTaskAssignModel();  
           datam.setStdate(sdate);
           datam.setEnddate(edate);
           datam.setPanel_id(panel_id);
           datam.setDesc(desc);
          int res= datam.assignTaskInsert();
        //  out.println(res);
           if(res != 0)
            {
                request.setAttribute("msg","Record inserted successfully");
                 robj = request.getRequestDispatcher("/DirTaskAssignController");
                robj.forward(request, response);

            }
            else 
            {
                request.setAttribute("err","Record not inserted");
                robj = request.getRequestDispatcher("/DirTaskAssignController");
                robj.forward(request, response);

            }
          
          
        
     } catch (Exception e) {
          out.println("Error in DirAddTaskAssignController" + e);
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
