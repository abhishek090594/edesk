/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StfAddInquiryFormDetailModel;
import Model.StfViewInquiryDetailsModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SOHIL
 */
public class phEditInquiryFormDetailController extends HttpServlet {

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
        RequestDispatcher robj =null;
        ResultSet rs =null;
        try {
            if(request.getParameter("edtid") != null)
            {
           StfViewInquiryDetailsModel sidm = new StfViewInquiryDetailsModel();
           ResultSet rs2 = sidm.getCourseName();
           ResultSet rs1 = sidm.getInstituteName();
           request.setAttribute("courseDetails", rs2);
           request.setAttribute("instituteDetails", rs1);
           int stdid = Integer.parseInt(request.getParameter("edtid"));
           StfAddInquiryFormDetailModel saifdm = new StfAddInquiryFormDetailModel();
           rs = saifdm.getStudentDetail(stdid);
           request.setAttribute("edit_stud_detail", rs);
           robj = request.getRequestDispatcher("View/panelHead/edit_stud_detail.jsp");
           robj.forward(request, response);
        }
         }
        catch(Exception e){
                out.println("Error in phEditInquiryFormDetailController :"+ e);
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
