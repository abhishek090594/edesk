<%-- 
    Document   : login.jsp
    Created on : Mar 9, 2016, 7:37:35 PM
    Author     : SOHIL
--%>

<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>E-Registration Desk - Staff</title>
		<meta charset="utf-8">
                <link href="<%= request.getContextPath() %>/css/login.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="shortcut icon" href="#" type="image/x-icon">
		
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>

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
	<div class="main">
		<div class="login-form">
			<h1>Staff Login</h1>
                        <%
                           HttpSession sobj = request.getSession(false);
                            if(sobj != null)
                            {
                                if(sobj.getAttribute("Stf_is_logged_in") != null)
                                {
                                   response.sendRedirect(request.getContextPath()+"/StfViewDashboardController");
                                }
                            }
                            
                            if(request.getAttribute("err") != null)
                            {
                     %>
                     <div id="div-close" class="err" style="margin: 22px;">
			<p><strong><%   out.println(request.getAttribute("err")); %></strong></p>
			<a href="#" class="close" onclick="return closediv()">close</a>
		</div>
                
                        <%          
                            }   
                        %>
                        <div class="head" >
                                           <!-- <img src="#" alt=""/>
					--></div>
                        <form action="StfCheckLoginController" method="post">
                            <input type="text" name="txtemailid" class="text" value="" placeholder="Email ID" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'USERNAME';}" >
						<input type="password" name="txtpassword" value="" onFocus="this.value = '';" placeholder="Password" onBlur="if (this.value == '') {this.value = 'Password';}">
						<div class="submit">
							<input type="submit" onClick="myFunction()" value="LOGIN" >
					</div>	
					<p><a href="<%= request.getContextPath() %>/StfViewStaffRegistrationForm">Staff Registration</a>&nbsp;|&nbsp;<a href="#">Forgot Password ?</a></p>
				</form>
			</div>
		<div class="copy-right">
			<p>Copyright &copy; 2016 <a href="#">E-Registration Desk</a></p>
		</div>
	</div>
</body>
</html>