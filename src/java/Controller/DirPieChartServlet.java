/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
import org.jfree.chart.plot.PiePlot;


/**
 *
 * @author SOHIL
 */
public class DirPieChartServlet extends HttpServlet {

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
        response.setContentType("image/png");
         try{
        
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = connect.createStatement( );
                ResultSet resultSet = statement.executeQuery("SELECT count( * ) FROM studentinquiry WHERE stud_status =0" );
		OutputStream outputStream = response.getOutputStream();
                DefaultPieDataset dataset=new DefaultPieDataset();
		//JDBCPieDataset dataset = new JDBCPieDataset(connect);
                    
                while(resultSet.next())
                {
                    dataset.setValue("Come For Inquiry ("+resultSet.getString(1)+")",resultSet.getInt(1));
                    resultSet=statement.executeQuery("SELECT count( * ) FROM studentinquiry WHERE stud_status =1");
                    while (resultSet.next()) {    
                    dataset.setValue("Confirmed ("+resultSet.getString(1)+")",resultSet.getInt(1));    
                    }
                        
                }
                    //dataset.executeQuery(connect, "select status,per from direpie");
                    
                   
                
                /*dataset.setValue("darshan",50);
                   dataset.setValue("sohil",30);
                   dataset.setValue("sunil",20);*/
		boolean legend = true;
		boolean tooltips = true;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("Student Admission Confirmation Details", dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.white);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);
                PiePlot piePlot = (PiePlot) chart.getPlot(); 
                piePlot.setSectionPaint(0, java.awt.Color.red); 
                piePlot.setSectionPaint(1, java.awt.Color.blue);
		int width = 500;
		int height = 350;
		ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
        }
        catch(Exception e)
        {
            System.out.println(e);
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
