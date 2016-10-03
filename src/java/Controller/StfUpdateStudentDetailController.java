/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StfAddInquiryFormDetailModel;
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
public class StfUpdateStudentDetailController extends HttpServlet {

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
     
        try {
            HttpSession sobj = request.getSession(false);                   
           String nme,addr,email,img,pwd;
            long cont;
            int status,cour,inst,studid;
            float per;
            studid = Integer.parseInt(request.getParameter("h1"));
            nme = request.getParameter("txtname");
            addr = request.getParameter("txtaddr");
            cont = Long.parseLong(request.getParameter("txtcontact").trim());
            email = request.getParameter("txtemail");
            cour = Integer.parseInt(request.getParameter("drpdwncourse"));
            inst = Integer.parseInt(request.getParameter("drpdwninstitue"));      
            per = Float.parseFloat(request.getParameter("txtper"));
           status = Integer.parseInt(request.getParameter("drpdwnstatusdrpdwnstatus"));
            StfAddInquiryFormDetailModel saifm = new StfAddInquiryFormDetailModel();
            String stf_id = String.valueOf(sobj.getAttribute("Stf_id_is_logged_in"));
            saifm.setStf_id(Integer.parseInt(stf_id));
            saifm.setName(nme);
            saifm.setAddr(addr);
            saifm.setCont(cont);
            saifm.setEmail(email);
            saifm.setCon_id(cour);
            saifm.setInn_id(inst);
            saifm.setPerc(per);
            saifm.setStatus(status);
         
       
            int res = saifm.studUpdateDetail(studid);
           
        if(res != 0)
            {
           if(status == 1)
                {
                    request.setAttribute("msg_info","Record Updated successfully");  
                    request.setAttribute("name",nme);
                    request.setAttribute("email",email);
                    request.setAttribute("path","/StfViewStudentInquiryListController");
                    robj = request.getRequestDispatcher("/SendMail");
                    robj.forward(request, response);
                }
            else
                {
                    request.setAttribute("msg","Record Updated successfully");
                    robj = request.getRequestDispatcher("/StfViewStudentInquiryListController");
                    robj.forward(request, response);
                 }
            }
            else 
            {
              
                request.setAttribute("err","Record not Updated" + res);
                robj = request.getRequestDispatcher("/StfViewStudentInquiryListController");
                robj.forward(request, response);

            }
          
         }
        catch(Exception e){
                out.println("Error in StfUpdateStudentDetailController :"+ e);
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
