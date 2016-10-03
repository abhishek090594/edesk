/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author SOHIL
 */
public class StfColumnChartServlet extends HttpServlet {

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
     try {
            OutputStream out = response.getOutputStream();

            // Create a simple Bar chart
            //System.out.println("Setting dataset values");
            Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                //Statement statement = connect.createStatement( );
                //ResultSet resultSet = statement.executeQuery("select * from air_pollution" );
		OutputStream outputStream = response.getOutputStream();
    		JDBCCategoryDataset dataset = new JDBCCategoryDataset(connect);
           //DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            //dataset.setValue(145, "Yes","");
            //dataset.setValue(55, "No","");
           
                    dataset.executeQuery(connect, "select status,percentage from dirpie");
            JFreeChart chart = ChartFactory.createBarChart3D(
                "Student Admission Confirmation Details" + "",
                "Student Confirmation", "Percentage of Students",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

            chart.setBackgroundPaint(Color.white);

            // Set the background colour of the chart
            chart.getTitle().setPaint(Color.blue);

            // Adjust the colour of the title
            CategoryPlot plot = chart.getCategoryPlot();

            // Get the Plot object for a bar graph
            plot.setBackgroundPaint(Color.white);
            plot.setRangeGridlinePaint(Color.red);

            CategoryItemRenderer renderer = plot.getRenderer();
            renderer.setSeriesPaint(0, Color.red);
            renderer.setSeriesPaint(1, Color.green);
            renderer.setItemURLGenerator(
                new StandardCategoryURLGenerator(
                    "index1.html",
                    "series",
                    "section"));
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

            response.setContentType("image/png");

            ChartUtilities.writeChartAsPNG(out, chart, 500, 300);

        } catch (Exception e) {
            System.err.println("Problem occurred creating chart." + e.getMessage());
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
