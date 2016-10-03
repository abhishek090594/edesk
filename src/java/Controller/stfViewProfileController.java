
package Controller;

import Model.stfViewProfile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class stfViewProfileController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  
        {
          RequestDispatcher robj =null;
           ResultSet rs =null;
           int id=0;
           HttpSession sobj = request.getSession(false);
            if(sobj != null)
            {
                if(sobj.getAttribute("Stf_id_is_logged_in") != null && sobj.getAttribute("Stf_is_logged_in") != null)
                {
                    id=Integer.parseInt((String)sobj.getAttribute("Stf_id_is_logged_in"));
                }
            }
            //out.println(id);
            //out.println(sobj.getAttribute("Stf_is_logged_in"));
           
            stfViewProfile svp = new stfViewProfile();
            ResultSet rs1 = svp.getProfileData(id);
            
            request.setAttribute("profileData", rs1);  
            robj = request.getRequestDispatcher("View/changeProfile.jsp");
            robj.forward(request, response);
            
        }
        catch(Exception e)
        {
             out.println("Error in StaffProfileController :"+ e);
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
