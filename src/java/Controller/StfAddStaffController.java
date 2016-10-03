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
import Model.DirViewStaffModel;
import java.math.BigInteger;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author SOHIL
 */
public class StfAddStaffController extends HttpServlet {

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
           String nme,addr,email,img,pwd;
            long cont;
            nme = request.getParameter("txtname");
            addr = request.getParameter("txtaddr");
            cont = Long.parseLong(request.getParameter("txtcontact").trim());
            email = request.getParameter("txtemail");
            img = request.getParameter("txtimg");
            pwd = request.getParameter("txtpwd");
            DirViewStaffModel diradd = new DirViewStaffModel();
            diradd.setName(nme);
            diradd.setAddr(addr);
            diradd.setCont(cont);
            diradd.setEmail(email);
            diradd.setImage(img);
            diradd.setPwd(pwd);
            ResultSet rs = diradd.checkEmailExist();
            if(rs.next())
            {
                out.println("<script type=\"text/javascript\">alert(\"Email ID already exists...Try with different email id\");location=\"StfViewStaffRegistrationForm\";</script>");
                
           }
            else
            {
            int res = diradd.staffInsert();
                  
             if(res != 0)
            {
                request.setAttribute("msg","Record inserted successfully");
                 robj = request.getRequestDispatcher("/StfViewStaffRegistrationForm");
                robj.forward(request, response);

            }
            else 
            {
                request.setAttribute("err","Record not inserted");
                robj = request.getRequestDispatcher("/StfViewStaffRegistrationForm");
                robj.forward(request, response);

            }
            }
         }
        catch(Exception e){
                out.println("Error in DirAddStaffController :"+ e);
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
