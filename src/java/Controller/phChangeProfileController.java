
package Controller;

import Model.phChangeProfileModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class phChangeProfileController extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher robj =null;
        PrintWriter out = response.getWriter();
        phChangeProfileModel pcpm = new phChangeProfileModel();
        try 
        {
            String nme,addr,email,emailold;
            long cont;
            int id=Integer.parseInt(request.getParameter("h1"));
            nme = request.getParameter("txtname");
            addr = request.getParameter("txtaddr");
            cont = Long.parseLong(request.getParameter("txtcontact").trim());
            email = request.getParameter("txtemail");
            emailold = request.getParameter("h2");
            if(email.equals(emailold))
            {
                pcpm.setAddr(addr);
                pcpm.setCont(cont);
                pcpm.setEmail(email);
                pcpm.setId(id);
                pcpm.setName(nme);
                int res = pcpm.updateData();
                if(res!=0)
                {
                    //out.println("sussecc");
                    int res1 = pcpm.updatepanel();
                    if(res1!=0)
                    {
                        request.setAttribute("msg","Record Update successfully");
                        HttpSession sobj = request.getSession(true);
                        sobj.setAttribute("ph_is_logged_in",email);
                        response.sendRedirect("phViewProfileController");
                    }
                    else
                    {
                        out.println("err");
                    }                
                }
                else
                {
                    out.println("<script type=\"text/javascript\">alert(\"Error...!\");location=\"phViewProfileController\";</script>");
                    // out.println("err");
                }
            }
            else
            {
                pcpm.setEmail(email);
                ResultSet rs = pcpm.checkEmailExist();
                if(rs.next())
                {
                    out.println("<script type=\"text/javascript\">alert(\"Email ID already exists...Try with different email id\");location=\"phViewProfileController\";</script>");
                }
                else
                {
                    pcpm.setAddr(addr);
                    pcpm.setCont(cont);
                    pcpm.setEmail(email);
                    pcpm.setId(id);
                    pcpm.setName(nme);
                    int res = pcpm.updateData();
                    if(res!=0)
                    {
                       int res1 = pcpm.updatepanel();
                        if(res1!=0)
                        {
                            request.setAttribute("msg","Record Update successfully");
                            HttpSession sobj = request.getSession(true);
                            sobj.setAttribute("ph_is_logged_in",email);
                            response.sendRedirect("phViewProfileController");
                        }
                        else
                        {
                            out.println("err");
                        }
                    }
                    else
                    {
                        out.println("<script type=\"text/javascript\">alert(\"Error...!\");location=\"phViewProfileController\";</script>");
                         //out.println("err");
                    }
                }
            }
        }
        catch(Exception e)
        {
            out.println(e);
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
