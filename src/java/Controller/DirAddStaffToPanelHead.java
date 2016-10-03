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
import Model.DirAddPanelHeadModel;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author SOHIL
 */
public class DirAddStaffToPanelHead extends HttpServlet {

    public static int res; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        RequestDispatcher robj = null;
        
            try {
   
                DirAddPanelHeadModel daphm = new DirAddPanelHeadModel();  
           String[] chkStfId = request.getParameterValues("chk1");
           String selectPhID = request.getParameter("ph1");
          int phid = Integer.parseInt(selectPhID);
           
           for(String a : chkStfId )
           {

               int stfid = Integer.parseInt(a);
               out.println(stfid);
                  daphm.setPhid(phid);
                   daphm.setStfId(stfid);
                  res = daphm.assignStaffInsert();
              
           }
           
           if(res != 0)
            {
                res = 0;
                request.setAttribute("msg","Staff Members assign to Panel Head");
                 robj = request.getRequestDispatcher("/DirViewStaffMemberList");
                robj.forward(request, response);

            }
            else 
            {
                res = 0;
                  request.setAttribute("err","Error  while assigning  Staff Members to Panel Head" + res);
                robj = request.getRequestDispatcher("/DirViewStaffMemberList");
                robj.forward(request, response);

            }
           
         }
      catch (Exception e) {
          out.println("Error in DirAddStafftoPanelHeadController" + e);
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
