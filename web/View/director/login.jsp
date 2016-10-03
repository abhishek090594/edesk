<%-- 
    Document   : login.jsp
    Created on : Mar 9, 2016, 7:37:35 PM
    Author     : SOHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
    <meta charset="utf-8">
    <title>E-Registration Desk</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="<%= request.getContextPath() %>/assets/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%= request.getContextPath() %>/assets/css/charisma-app.css" rel="stylesheet">
    <link href='<%= request.getContextPath() %>/assets/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%= request.getContextPath() %>/assets/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/uploadify.css' rel='stylesheet'>
    <link href='<%= request.getContextPath() %>/assets/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/assets/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="<%= request.getContextPath() %>/assets/img/favicon.ico">

</head>

<body>
<div class="ch-container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>Welcome to E-Registration Desk</h2>
        </div>
        <!--/span-->
    </div><!--/row-->

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
                Please login with your Email-ID and Password.
            </div>
            <%
                           HttpSession sobj = request.getSession(false);
                            if(sobj != null)
                            {
                                if(sobj.getAttribute("Dir_is_logged_in") != null)
                                {
                                   response.sendRedirect(request.getContextPath()+"/DirViewDashboard");
                                }
                            }
                            
                            if(request.getAttribute("err") != null)
                            {
                     %>
            <div class="alert alert-danger">
                <%   out.println(request.getAttribute("err")); %>
            </div>
                     <%
                            }
                     %>
            <form class="form-horizontal" action="<%= request.getContextPath() %>/DirCheckLoginController" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" name="txtemailid" class="form-control" placeholder="Email-Id" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'USERNAME';}">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" name="txtpassword" class="form-control" placeholder="Password" onBlur="if (this.value == '') {this.value = 'Password';}" onFocus="this.value = '';">
                    </div>
                    <div class="clearfix"></div>

                    <div class="input-prepend">
                        <label class="remember" for="remember"><a href="#">Forgot Password ?</a></label>
                    </div>
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="<%= request.getContextPath() %>/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<%= request.getContextPath() %>/assets/bower_components/moment/min/moment.min.js'></script>
<script src='<%= request.getContextPath() %>/assets/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<%= request.getContextPath() %>/assets/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="<%= request.getContextPath() %>/assets/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<%= request.getContextPath() %>/assets/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<%= request.getContextPath() %>/assets/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<%= request.getContextPath() %>/assets/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="<%= request.getContextPath() %>/assets/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="/js/charisma.js"></script>


</body>
</html>
