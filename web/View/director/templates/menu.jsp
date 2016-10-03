<%-- 
    Document   : menu.jsp
    Created on : Mar 9, 2016, 7:26:13 PM
    Author     : SOHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-sm-2 col-lg-2">
    <div class="sidebar-nav">
        <div class="nav-canvas">
            <div class="nav-sm nav nav-stacked">

            </div>
            <ul class="nav nav-pills nav-stacked main-menu">
                <li class="nav-header">Director</li>
                <li><a class="ajax-link" href="<%= request.getContextPath() %>/DirViewDashboard"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                </li>
                <li><a class="ajax-link" href="<%= request.getContextPath() %>/DirViewPanelHeadList"><i class="glyphicon glyphicon-edit"></i><span>Panel List</span></a></li>
                <li><a class="ajax-link" href="<%= request.getContextPath() %>/DirViewStaffMemberList"><i class="glyphicon glyphicon-edit"></i><span>Add Staff in Panel</span></a></li>
                <li><a class="ajax-link" href="<%= request.getContextPath() %>/DirViewStaffListController"><i class="glyphicon glyphicon-edit"></i><span>Staff List</span></a></li>    
                <li><a href="<%= request.getContextPath() %>/DirViewStudentList"><i class="glyphicon glyphicon-lock"></i><span>Student List</span></a>
                    <li><a href="<%= request.getContextPath() %>/View/director/prblem_blog.jsp"><i class="glyphicon glyphicon-lock"></i><span>Problem Blog</span></a>
                        <li><a href="<%= request.getContextPath() %>/DirTaskAssignController"><i class="glyphicon glyphicon-lock"></i><span>Task Assign</span></a>
                            <li><a href="<%= request.getContextPath() %>/DirViewReport"><i class="glyphicon glyphicon-lock"></i><span>Report</span></a>
                </li>
            </ul>
        </div>
    </div>
</div>