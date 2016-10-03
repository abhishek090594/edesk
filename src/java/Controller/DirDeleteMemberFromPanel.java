/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.DirViewMembersofPanelModel;
/**
 *
 * @author SOHIL
 */
public class DirDeleteMemberFromPanel extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher robj = null;
       try {
            String delid =  request.getParameter("delsid");
            DirViewMembersofPanelModel dvmopm = new DirViewMembersofPanelModel();
            int res1 = dvmopm.DeleteMemberFromPanelHead(Integer.parseInt(delid));
          
             if(res1 != 0)
            {

               request.setAttribute("msg","Record Deleted successfully");
                 robj = request.getRequestDispatcher("/DirViewPanelHeadList");
                robj.forward(request, response);

            }
            else 
            {
              
              request.setAttribute("err","Record not Deleted");
                robj = request.getRequestDispatcher("/DirViewMembersofPanelController");
                robj.forward(request, response);

          }

 
     } catch (Exception e) {
          out.println("Error in DirDeleteMemberFromPanel" + e);
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
