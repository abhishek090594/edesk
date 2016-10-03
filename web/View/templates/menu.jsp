<%-- 
    Document   : menu.jsp
    Created on : Mar 9, 2016, 7:26:13 PM
    Author     : SOHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="navigation">
	<ul>
		<li><a href="<%= request.getContextPath() %>/StfViewDashboardController"><span>Dashboard</span></a></li>
		<li><a href="<%= request.getContextPath() %>/StfViewInquiryFormController"><span>Inquiry Form</span></a></li>
		<li><a href="<%= request.getContextPath() %>/StfViewStudentInquiryListController"><span>Student List</span></a></li>
		<li><a href="#"><span>Problem Blog</span></a></li>
                
	</ul>
</div>