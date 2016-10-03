/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DirAllReportModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sohil Chamadia
 */
public class PdfReportServlet extends HttpServlet {

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
        //response.setHeader("Content-disposition","inline;filename='report.pdf'");
       PrintWriter out=response.getWriter();
       DirAllReportModel mydb=new DirAllReportModel(); 
       String imgPath=request.getContextPath();
        try  {
             if (request.getParameter("sdate")!=null && request.getParameter("edate")!=null) {
                  if (request.getParameter("slctstaff")!=null && request.getParameter("rdGrp").equals("StaffWise")) {
                      
                                             mydb.setSdate(request.getParameter("sdate"));
                                             mydb.setEdate(request.getParameter("edate"));
                                             mydb.setSid(Integer.parseInt(request.getParameter("slctstaff")));
                                             out.println("<!DOCTYPE html>");
                                             out.println("<html>");
                                             out.println("<head>");
                                             out.println("<title>Report</title>");            
                                             out.println("</head>");
                                             out.println("<body>");
                                             out.println("<center>");
                                             out.println("<img src='"+imgPath+"/images/srimca.gif'>");
                                             out.println("<br><br>");
                                             out.println("<h2>Shrimad Rajchandra Institute of Management & Computer application</h2>");
                                             out.println("<h3>UKA Tarsadia University</h3>");
                                             out.println("<br><br><br><br><br>");
                                             out.println("<table border='2'>");
                                             out.println("<tr>");
                                             out.println("<td>Confirmed Students</td>");
                                             out.println("<td>Not Confirmed Students</td>");
                                             out.println("<td><b>Total Students</b></td>");
                                             out.println("</tr>");
                                             out.println("<tr>");
                                             out.println("<td>");
                                             mydb.StaffConfirmedRS();
                                             while (mydb.getStfRs1().next()) {                
                                             out.println(mydb.getStfRs1().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                             mydb.StaffNotConfirmedRS();
                                             while (mydb.getStfRs2().next()) {               
                                                 out.println(mydb.getStfRs2().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                              mydb.StaffAllStudentRs();
                                              while (mydb.getStfRs3().next()) {                 
                                                  out.println(mydb.getStfRs3().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("</tr>");
                                             out.println("</table>");
                                             out.println("</center>");
                                             out.println("</body>");
                                             out.println("</html>");
                  }
                  else if (request.getParameter("slctpanel")!=null && request.getParameter("rdGrp").equals("PanelWise")) {
                      
                                             mydb.setSdate(request.getParameter("sdate"));
                                             mydb.setEdate(request.getParameter("edate"));
                                             mydb.setPid(Integer.parseInt(request.getParameter("slctpanel")));
                                             out.println("<!DOCTYPE html>");
                                             out.println("<html>");
                                             out.println("<head>");
                                             out.println("<title>Report</title>");            
                                             out.println("</head>");
                                             out.println("<body>");
                                             out.println("<center>");
                                             out.println("<img src='"+imgPath+"/images/srimca.gif'>");
                                             out.println("<br><br>");
                                             out.println("<h2>Shrimad Rajchandra Institute of Management & Computer application</h2>");
                                             out.println("<h3>UKA Tarsadia University</h3>");
                                             out.println("<br><br><br><br><br>");
                                             out.println("<table border='2'>");
                                             out.println("<tr>");
                                             out.println("<td>Confirmed Students</td>");
                                             out.println("<td>Not Confirmed Students</td>");
                                             out.println("<td><b>Total Students</b></td>");
                                             out.println("</tr>");
                                             out.println("<tr>");
                                             out.println("<td>");
                                             mydb.PanelHeadConfirmedRS();
                                             while (mydb.getPhRs1().next()) {                
                                             out.println(mydb.getPhRs1().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                             mydb.PanelHeadNotConfirmedRS();
                                             while (mydb.getPhRs2().next()) {               
                                                 out.println(mydb.getPhRs2().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                              mydb.PanelHeadAllStudentRs();
                                              while (mydb.getPhRs3().next()) {                 
                                                  out.println(mydb.getPhRs3().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("</tr>");
                                             out.println("</table>");
                                             out.println("</center>");
                                             out.println("</body>");
                                             out.println("</html>");
                  }
                  else if (request.getParameter("slctcollege")!=null && request.getParameter("rdGrp").equals("ClgWise")) {
                      
                                             mydb.setSdate(request.getParameter("sdate"));
                                             mydb.setEdate(request.getParameter("edate"));
                                             mydb.setClgid(Integer.parseInt(request.getParameter("slctcollege")));
                                             out.println("<!DOCTYPE html>");
                                             out.println("<html>");
                                             out.println("<head>");
                                             out.println("<title>Report</title>");            
                                             out.println("</head>");
                                             out.println("<body>");
                                             out.println("<center>");
                                             out.println("<img src='"+imgPath+"/images/srimca.gif'>");
                                             out.println("<br><br>");
                                             out.println("<h2>Shrimad Rajchandra Institute of Management & Computer application</h2>");
                                             out.println("<h3>UKA Tarsadia University</h3>");
                                             out.println("<br><br><br><br><br>");
                                             out.println("<table border='2'>");
                                             out.println("<tr>");
                                             out.println("<td>Confirmed Students</td>");
                                             out.println("<td>Not Confirmed Students</td>");
                                             out.println("<td><b>Total Students</b></td>");
                                             out.println("</tr>");
                                             out.println("<tr>");
                                             out.println("<td>");
                                             mydb.InstituteConfirmedRS();
                                             while (mydb.getClgRs1().next()) {                
                                             out.println(mydb.getClgRs1().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                             mydb.InstituteNotConfirmedRS();
                                             while (mydb.getClgRs2().next()) {               
                                                 out.println(mydb.getClgRs2().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                              mydb.InstituteAllStudentRs();
                                              while (mydb.getClgRs3().next()) {                 
                                                  out.println(mydb.getClgRs3().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("</tr>");
                                             out.println("</table>");
                                             out.println("</center>");
                                             out.println("</body>");
                                             out.println("</html>");
                  }
                  else{
                                             mydb.setSdate(request.getParameter("sdate"));
                                             mydb.setEdate(request.getParameter("edate"));

                                             out.println("<!DOCTYPE html>");
                                             out.println("<html>");
                                             out.println("<head>");
                                             out.println("<title>Report</title>");            
                                             out.println("</head>");
                                             out.println("<body>");
                                             out.println("<center>");
                                             out.println("<img src='"+imgPath+"/images/srimca.gif'>");
                                             out.println("<br><br>");
                                             out.println("<h2>Shrimad Rajchandra Institute of Management & Computer application</h2>");
                                             out.println("<h3>UKA Tarsadia University</h3>");
                                             out.println("<br><br><br><br><br>");
                                             out.println("<table border='2'>");
                                             out.println("<tr>");
                                             out.println("<td>Confirmed Students</td>");
                                             out.println("<td>Not Confirmed Students</td>");
                                             out.println("<td><b>Total Students</b></td>");
                                             out.println("</tr>");
                                             out.println("<tr>");
                                             out.println("<td>");
                                             mydb.ConfirmedRS();
                                             while (mydb.getRs1().next()) {                 
                                             out.println(mydb.getRs1().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                             mydb.NotConfirmedRS();
                                             while (mydb.getRs2().next()) {               
                                                 out.println(mydb.getRs2().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("<td>");
                                              mydb.AllStudentRs();
                                              while (mydb.getRs3().next()) {                 
                                                  out.println(mydb.getRs3().getInt(1));
                                             }
                                             out.println("</td>");
                                             out.println("</tr>");
                                             out.println("</table>");
                                             out.println("</center>");
                                             out.println("</body>");
                                             out.println("</html>");
                                             }
           
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
