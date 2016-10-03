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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;
import Model.*;
import java.awt.image.RenderedImage;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author admin
 */
public class ChartsReportServlet extends HttpServlet {

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
        OutputStream outputStream = response.getOutputStream();
        DirAllReportModel mydb=new DirAllReportModel();                                                        
    try{
        if(request.getParameter("reportGrp").contains("graphReport"))
                {
                    
                
       if (request.getParameter("sdate")!=null && request.getParameter("edate")!=null && request.getParameter("slctType")!=null) {
                if (request.getParameter("slctstaff")!=null && request.getParameter("slctType")!=null && request.getParameter("rdGrp").equals("StaffWise")) {
                 if(request.getParameter("slctType").equals("Pie"))
                 {
                     System.out.println(request.getParameter("slctstaff"));
                     System.out.println(request.getParameter("slctType"));
                     System.out.println(request.getParameter("sdate"));

                     DefaultPieDataset dataset=new DefaultPieDataset();
                        mydb.setSid(Integer.parseInt(request.getParameter("slctstaff")));
                        mydb.setSdate(request.getParameter("sdate"));
                        mydb.setEdate(request.getParameter("edate"));
                        mydb.StaffConfirmedRS();
                     //  System.out.println(mydb.getRs1());
                       
                        while (mydb.getStfRs1().next()) {                
                        dataset.setValue("Confirmed ("+mydb.getStfRs1().getInt(1)+")",mydb.getStfRs1().getInt(1));
                        }
                        mydb.StaffNotConfirmedRS();
                     //   System.out.println(mydb.getRs1());

                        while (mydb.getStfRs2().next()) {                
                            dataset.setValue("Come For Inquiry ("+mydb.getStfRs2().getInt(1)+")",mydb.getStfRs2().getInt(1));
                        }
                        /*dataset.setValue("darshan",50);
                           dataset.setValue("sohil",30);
                           dataset.setValue("sunil",20);*/
                        boolean legend = true;
                        boolean tooltips = true;
                        boolean urls = false;
                        mydb.StaffAllStudentRs();
                        JFreeChart chart=null;
                        while (mydb.getStfRs3().next()) {                
                        chart = ChartFactory.createPieChart("Student Inquiry Report - Total ("+mydb.getStfRs3().getInt(1)+")", dataset, legend, tooltips, urls);
                        }
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
                        else if(request.getParameter("slctType").equals("Column"))
                        {
                            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                          mydb.setSid(Integer.parseInt(request.getParameter("slctstaff")));
                          mydb.setSdate(request.getParameter("sdate"));
                          mydb.setEdate(request.getParameter("edate"));
                          mydb.StaffAllStudentRs();
                             while (mydb.getStfRs3().next()) {                
                                     dataset.setValue(mydb.getStfRs3().getInt(1),"Total","");
                             }
                             mydb.StaffConfirmedRS();
                             while (mydb.getStfRs1().next()) {                
                             dataset.setValue(mydb.getStfRs1().getInt(1),"Confirmed","");
                             }
                             mydb.StaffNotConfirmedRS();
                             while (mydb.getStfRs2().next()) {                
                                 dataset.setValue(mydb.getStfRs2().getInt(1),"Come For Inquiry","");
                             }

                                     //dataset.setValue(5, "Yes","");
                             //dataset.setValue(55, "No","");
                                     //dataset.executeQuery(connect, "select status,per from direpie");

                             JFreeChart chart = ChartFactory.createBarChart3D(
                                 "Student Admission Confirmation Details" + "",
                                 "Student Confirmation", "Students",
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
                             plot.setRangeGridlinePaint(Color.black);

                             CategoryItemRenderer renderer = plot.getRenderer();
                             renderer.setSeriesPaint(0, Color.blue);
                             renderer.setSeriesPaint(1, Color.green);
                             renderer.setSeriesPaint(2, Color.red);
                             renderer.setItemURLGenerator(
                                 new StandardCategoryURLGenerator(
                                     "index1.html",
                                     "series",
                                     "section"));
                             renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

                             //response.setContentType("image/png");

                             ChartUtilities.writeChartAsPNG(outputStream, chart, 500, 300);
                        }
                }
                else if (request.getParameter("slctpanel")!=null && request.getParameter("slctType")!=null && request.getParameter("rdGrp").equals("PanelWise")) {
                 if(request.getParameter("slctType").equals("Pie"))
                 {
                
                        DefaultPieDataset dataset=new DefaultPieDataset();
                        mydb.setPid(Integer.parseInt(request.getParameter("slctpanel")));
                        mydb.setSdate(request.getParameter("sdate"));
                        mydb.setEdate(request.getParameter("edate"));
                        mydb.PanelHeadConfirmedRS();
                        while (mydb.getPhRs1().next()) {                
                        dataset.setValue("Confirmed ("+mydb.getPhRs1().getInt(1)+")",mydb.getPhRs1().getInt(1));
                        }
                        mydb.PanelHeadNotConfirmedRS();
                        while (mydb.getPhRs2().next()) {                
                            dataset.setValue("Come For Inquiry ("+mydb.getPhRs2().getInt(1)+")",mydb.getPhRs2().getInt(1));
                        }
                        /*dataset.setValue("darshan",50);
                           dataset.setValue("sohil",30);
                           dataset.setValue("sunil",20);*/
                        boolean legend = true;
                        boolean tooltips = true;
                        boolean urls = false;
                        mydb.PanelHeadAllStudentRs();
                        JFreeChart chart=null;
                        while (mydb.getPhRs3().next()) {                
                        chart = ChartFactory.createPieChart("Student Inquiry Report - Total ("+mydb.getPhRs3().getInt(1)+")", dataset, legend, tooltips, urls);
                        }
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
                 else if (request.getParameter("slctType").equals("Column"))
                  {
                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        mydb.setPid(Integer.parseInt(request.getParameter("slctpanel")));
                          mydb.setSdate(request.getParameter("sdate"));
                          mydb.setEdate(request.getParameter("edate"));
                          mydb.PanelHeadAllStudentRs();
                             while (mydb.getPhRs3().next()) {                
                                     dataset.setValue(mydb.getPhRs3().getInt(1),"Total","");
                             }
                             mydb.PanelHeadConfirmedRS();
                             while (mydb.getPhRs1().next()) {                
                             dataset.setValue(mydb.getPhRs1().getInt(1),"Confirmed","");
                             }
                             mydb.PanelHeadNotConfirmedRS();
                             while (mydb.getPhRs2().next()) {                
                                 dataset.setValue(mydb.getPhRs2().getInt(1),"Come For Inquiry","");
                             }

                                     //dataset.setValue(5, "Yes","");
                             //dataset.setValue(55, "No","");
                                     //dataset.executeQuery(connect, "select status,per from direpie");

                             JFreeChart chart = ChartFactory.createBarChart3D(
                                 "Student Admission Confirmation Details" + "",
                                 "Student Confirmation", "Students",
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
                             plot.setRangeGridlinePaint(Color.black);

                             CategoryItemRenderer renderer = plot.getRenderer();
                             renderer.setSeriesPaint(0, Color.blue);
                             renderer.setSeriesPaint(1, Color.green);
                             renderer.setSeriesPaint(2, Color.red);
                             renderer.setItemURLGenerator(
                                 new StandardCategoryURLGenerator(
                                     "index1.html",
                                     "series",
                                     "section"));
                             renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

                             //response.setContentType("image/png");

                             ChartUtilities.writeChartAsPNG(outputStream, chart, 500, 300);
                    }
                }
                else if (request.getParameter("slctcollege")!=null && request.getParameter("slctType")!=null && request.getParameter("rdGrp").equals("ClgWise")) {
                 if(request.getParameter("slctType").equals("Pie"))
                 {
                
                        DefaultPieDataset dataset=new DefaultPieDataset();
                        mydb.setClgid(Integer.parseInt(request.getParameter("slctcollege")));
                        mydb.setSdate(request.getParameter("sdate"));
                        mydb.setEdate(request.getParameter("edate"));
                        mydb.InstituteConfirmedRS();
                        while (mydb.getClgRs1().next()) {                
                        dataset.setValue("Confirmed ("+mydb.getClgRs1().getInt(1)+")",mydb.getClgRs1().getInt(1));
                        }
                        mydb.InstituteNotConfirmedRS();
                        while (mydb.getClgRs2().next()) {                
                            dataset.setValue("Come For Inquiry ("+mydb.getClgRs2().getInt(1)+")",mydb.getClgRs2().getInt(1));
                        }
                        /*dataset.setValue("darshan",50);
                           dataset.setValue("sohil",30);
                           dataset.setValue("sunil",20);*/
                        boolean legend = true;
                        boolean tooltips = true;
                        boolean urls = false;
                        mydb.InstituteAllStudentRs();
                        JFreeChart chart=null;
                        while (mydb.getClgRs3().next()) {                
                        chart = ChartFactory.createPieChart("Student Inquiry Report - Total ("+mydb.getClgRs3().getInt(1)+")", dataset, legend, tooltips, urls);
                        }
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
                 else if (request.getParameter("slctType").equals("Column"))
                  {
                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                          mydb.setClgid(Integer.parseInt(request.getParameter("slctcollege")));
                          mydb.setSdate(request.getParameter("sdate"));
                          mydb.setEdate(request.getParameter("edate"));
                          mydb.InstituteAllStudentRs();
                             while (mydb.getClgRs3().next()) {                
                                     dataset.setValue(mydb.getClgRs3().getInt(1),"Total","");
                             }
                             mydb.InstituteConfirmedRS();
                             while (mydb.getClgRs1().next()) {                
                             dataset.setValue(mydb.getClgRs1().getInt(1),"Confirmed","");
                             }
                             mydb.InstituteNotConfirmedRS();
                             while (mydb.getClgRs2().next()) {                
                                 dataset.setValue(mydb.getClgRs2().getInt(1),"Come For Inquiry","");
                             }

                                     //dataset.setValue(5, "Yes","");
                             //dataset.setValue(55, "No","");
                                     //dataset.executeQuery(connect, "select status,per from direpie");

                             JFreeChart chart = ChartFactory.createBarChart3D(
                                 "Student Admission Confirmation Details" + "",
                                 "Student Confirmation", "Students",
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
                             plot.setRangeGridlinePaint(Color.black);

                             CategoryItemRenderer renderer = plot.getRenderer();
                             renderer.setSeriesPaint(0, Color.blue);
                             renderer.setSeriesPaint(1, Color.green);
                             renderer.setSeriesPaint(2, Color.red);
                             renderer.setItemURLGenerator(
                                 new StandardCategoryURLGenerator(
                                     "index1.html",
                                     "series",
                                     "section"));
                             renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

                             //response.setContentType("image/png");

                             ChartUtilities.writeChartAsPNG(outputStream, chart, 500, 300);
                    }
                }
                 else
                 {
                        if (request.getParameter("slctType").equals("Pie") && request.getParameter("sdate")!=null && request.getParameter("edate")!=null) {
                        DefaultPieDataset dataset=new DefaultPieDataset();
                        mydb.setSdate(request.getParameter("sdate"));
                        mydb.setEdate(request.getParameter("edate"));
                        mydb.ConfirmedRS();
                        while (mydb.getRs1().next()) {                
                        dataset.setValue("Confirmed"+mydb.getRs1().getInt(1),mydb.getRs1().getInt(1));
                        }
                        mydb.NotConfirmedRS();
                        while (mydb.getRs2().next()) {                
                            dataset.setValue("Come For Inquiry"+mydb.getRs2().getInt(1),mydb.getRs2().getInt(1));
                        }
                        /*dataset.setValue("darshan",50);
                           dataset.setValue("sohil",30);
                           dataset.setValue("sunil",20);*/
                        boolean legend = true;
                        boolean tooltips = true;
                        boolean urls = false;
                        mydb.AllStudentRs();
                        JFreeChart chart=null;
                        while (mydb.getRs3().next()) {                
                        chart = ChartFactory.createPieChart("Student Inquiry Report - Total ("+mydb.getRs3().getInt(1)+")", dataset, legend, tooltips, urls);
                        }
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
                 else if(request.getParameter("slctType").equals("Column") && request.getParameter("sdate")!=null && request.getParameter("edate")!=null)
                 {
                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        mydb.setSdate(request.getParameter("sdate"));
                           mydb.setEdate(request.getParameter("edate"));
                           mydb.AllStudentRs();
                           while (mydb.getRs3().next()) {                
                                   dataset.setValue(mydb.getRs3().getInt(1),"Total","");
                           }
                           mydb.ConfirmedRS();
                           while (mydb.getRs1().next()) {                
                           dataset.setValue(mydb.getRs1().getInt(1),"Confirmed","");
                           }
                           mydb.NotConfirmedRS();
                           while (mydb.getRs2().next()) {                
                               dataset.setValue(mydb.getRs2().getInt(1),"Come For Inquiry","");
                           }

                                   //dataset.setValue(5, "Yes","");
                           //dataset.setValue(55, "No","");
                                   //dataset.executeQuery(connect, "select status,per from direpie");

                           JFreeChart chart = ChartFactory.createBarChart3D(
                               "Student Admission Confirmation Details" + "",
                               "Student Confirmation", "Students",
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
                           plot.setRangeGridlinePaint(Color.black);

                           CategoryItemRenderer renderer = plot.getRenderer();
                           renderer.setSeriesPaint(0, Color.blue);
                           renderer.setSeriesPaint(1, Color.green);
                           renderer.setSeriesPaint(2, Color.red);
                           renderer.setItemURLGenerator(
                               new StandardCategoryURLGenerator(
                                   "index1.html",
                                   "series",
                                   "section"));
                           renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

                           //response.setContentType("image/png");

                           ChartUtilities.writeChartAsPNG(outputStream, chart, 500, 300);
                 }
                 else if(request.getParameter("slctType").equals("Line"))
                 {
                            ServletOutputStream os = response.getOutputStream();
                     
                            
                            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                            mydb.setSdate(request.getParameter("sdate"));
                            mydb.setEdate(request.getParameter("edate"));
                            mydb.LineAllStudentRs();
                           while (mydb.getRs3().next()) {                
                                   dataset.setValue(mydb.getRs3().getInt(1), "Total", mydb.getRs3().getString("date(stud_inquirydate)"));
                           }
                           mydb.LineConfirmedRS();
                           while (mydb.getRs1().next()) {                
                                    dataset.setValue(mydb.getRs1().getInt(1), "Confirmed", mydb.getRs1().getString("date(stud_inquirydate)"));
                           }
                           mydb.LineNotConfirmedRS();
                           while (mydb.getRs2().next()) {                
                               dataset.setValue(mydb.getRs2().getInt(1), "Come For Inquiry", mydb.getRs2().getString("date(stud_inquirydate)"));
                           }

                            
                            /*dataset.addValue(76, "Java", "Sandeep");
                            dataset.addValue(30, "Java", "Sangeeta");
                            dataset.addValue(50, "Java", "Surabhi");
                            dataset.addValue(20, "Java", "Sumanta");
                            dataset.addValue(10, "Oracle", "Sandeep");
                            dataset.addValue(90, "Oracle", "Sangeeta");
                            dataset.addValue(23, "Oracle", "Surabhi");
                            dataset.addValue(87, "Oracle", "Sumanta");*/
                            
                            JFreeChart chart = ChartFactory.createLineChart("Student Admission Confirmation Details", "Date",
                              "Students", dataset, PlotOrientation.VERTICAL, true, true, false);
                            ChartUtilities.writeChartAsPNG(outputStream, chart, 500, 300);
                            RenderedImage chartImage = chart.createBufferedImage(300, 300);
                            ImageIO.write(chartImage, "png", os);
                            os.flush();
                            os.close();
                 }
                     
                 }
               }
               
       
   
       // Sohil Code Start
    }
    else
    {
             javax.servlet.RequestDispatcher robj = request.getRequestDispatcher("/PdfReportServlet");
               robj.forward(request,response);
    }

    
           // Sohil Code Finish

        }
        catch(Exception e)
        {
            System.err.println(e);
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
