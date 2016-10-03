<%-- 
    Document   : PassingData
    Created on : Aug 16, 2016, 4:57:29 PM
    Author     : Sohil Chamadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       <%             if(request.getParameter("reportGrp").contains("PdfReport"))
            {
                String s = request.getContextPath()+"/PdfReportServlet";  
    //            response.sendRedirect(s);
             RequestDispatcher robj = request.getRequestDispatcher(s);
               robj.forward(request,response);
              
            }
            else if(request.getParameter("reportGrp").contains("graphReport")){
            
            
               String s = request.getContextPath()+"/ChartsReportServlet";
  //                  response.sendRedirect(s);
                    
                 RequestDispatcher robj = request.getRequestDispatcher(s);
                robj.forward(request,response);
    
            }
%>
    </body>
</html>
