/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.phChangePwdModel;
import Model.stfChangePwdModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ds210083
 */
public class stfChangePwdController extends HttpServlet {

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
        try  
        {
           String oldpwd,newpwd,cpwd,email;
           oldpwd=request.getParameter("txtoldpwd");
           newpwd=request.getParameter("txtnewpwd");
           cpwd=request.getParameter("txtcpwd");
           email=request.getParameter("h1");
           stfChangePwdModel scpm = new stfChangePwdModel();
           if(newpwd.equals(cpwd))
           {
                scpm.setEmail(email);
                scpm.setPwd(oldpwd);
                ResultSet rs= scpm.chkOldPwd();
                if(rs.next())
                {
                    scpm.setEmail(email);
                    scpm.setPwd(cpwd);
                    int res1 = scpm.updatePwd();
                    if(res1 == 1)
                    {
                        request.setAttribute("msg","Record Update successfully");
                        response.sendRedirect("stfViewChangePwdController");
                    }
                    else
                    {
                        //out.println("<script type=\"text/javascript\">alert(\"Email ID already exists...Try with different email id\");location=\"phViewProfileController\";</script>");
                        out.println("Password Not update");
                    }
                }
                else
                {
                    out.println("wrong old pwd");
                }
            }
               
           
           else
           {
               out.println("pasword not match");
           }
          
           
        }
        catch(Exception e)
        {
            
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
