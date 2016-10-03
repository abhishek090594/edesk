<%-- 
    Document   : header
    Created on : Mar 9, 2016, 7:23:34 PM
    Author     : SOHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>E-Registration Desk</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css" media="all" />
	<script type="text/javascript">
           
		function closediv()
		{
			document.getElementById('div-close').style.display = "none";
		}
		
		function closeerrordiv()
		{
			document.getElementById('div-error-close').style.display = "none";
		}
	</script>
</head>
    <body>
<!-- Header -->


<div class="shell-main">
		<div id="header">
			<div class="logo">
                   <!--         <img src="../images/ki.gif" alt="KI" height="100%" style="border-radius:60px;"/>
		-->	</div>
		<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1 class="comp_name"><a href="#">E-Registration Desk</a></h1>
			<div id="top-navigation">
                            <%
                      HttpSession sobj = request.getSession(false);
                            if(sobj != null)
                            {
                                if(sobj.getAttribute("Stf_is_logged_in") != null && sobj.getAttribute("Stf_id_is_logged_in") != null)
                                {
                        %>
                               <% String s = (String)sobj.getAttribute("Stf_is_logged_in"); %>
                                Welcome <strong><%=  sobj.getAttribute("Stf_is_logged_in") %></strong>
				<span>|</span>
				<a href="<%= request.getContextPath() %>/stfViewProfileController">Setting</a>
				<span>|</span>
                                <a href="<%= request.getContextPath() %>/AllLogoutController?str=s">Log out</a>
                <%
                                }
                            else
                            {
                                response.sendRedirect(request.getContextPath()+"/StfLoginController");
                            }

                            }
              
                %>                
			</div>
		</div>
		<!-- End Logo + Top Nav -->
                <%@include file="menu.jsp" %>
		<!-- Main Nav -->
		<!-- End Main Nav -->
	</div>
	<div class="line_header">
	</div>
</div>