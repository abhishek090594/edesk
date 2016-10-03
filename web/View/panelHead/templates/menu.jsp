<%-- 
    Document   : menu.jsp
    Created on : Mar 9, 2016, 7:26:13 PM
    Author     : SOHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="navigation">
	<ul>
<!--		<li><a href="index.jsp" class="active"><span>Dashboard</span></a></li>            -->
		<li><a href="<%= request.getContextPath() %>/phViewDashboardController"><span>Dashboard</span></a></li>
		<li><a href="<%= request.getContextPath() %>/phViewInquiryFormController"><span>Inquiry Form</span></a></li>
        	<li><a href="<%= request.getContextPath() %>/phStudentListController"><span>Student List</span></a></li>                        
		<li><a href="<%= request.getContextPath() %>/phMemberListController"><span>Staff Members</span></a></li>
     		<li><a href="#"><span>Problem Blog</span></a></li>
                <li><a href="<%= request.getContextPath() %>/PhReportController"><span>Report</span></a></li>

	</ul>
</div>