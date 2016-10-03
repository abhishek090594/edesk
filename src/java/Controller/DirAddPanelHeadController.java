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
public class DirAddPanelHeadController extends HttpServlet {

     public static int res,res1 ; 
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        
       try {
           DirAddPanelHeadModel daphm = new DirAddPanelHeadModel();  
           RequestDispatcher robj = null;
           String[] chkStfId = request.getParameterValues("chk1");
           for(String a : chkStfId )
           {
           int stfid = Integer.parseInt(a);
           rs =daphm.getDataForPanelHeadCreation(stfid);
               while (rs.next()) { 
                   daphm.setStfId(stfid);
                   daphm.setStfName(rs.getString("stf_name"));
                  res = daphm.panelHeadInsert();
                  res1 = daphm.updateStaffStatus();
               }
           
           }
           if(res != 0 && res1 != 0)
            {
                res = 0;
                res1 = 0;
                request.setAttribute("msg","Panel Head Created");
                 robj = request.getRequestDispatcher("/DirViewStaffListController");
                robj.forward(request, response);

            }
            else 
            {
                res = 0;
                res1 = 0;
                request.setAttribute("err","Error while creating panel head" + res);
                robj = request.getRequestDispatcher("/DirViewStaffListController");
                robj.forward(request, response);

            }

       
        
     } catch (Exception e) {
          out.println("Error in DirAddPanelHeadController" + e);
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
