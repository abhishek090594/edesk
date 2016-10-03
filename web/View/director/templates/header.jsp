<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E-Resgistration Desk</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <style type="text/css">
    .back-button,
    .back-button span { float:left; height:26px; background:url(<%= request.getContextPath() %>/assets/images/back-button.gif) no-repeat 0 0; padding:0 0 0 28px; }
    .back-button span { background-position:right 0; padding:1px 10px 0 2px; }
    .back-button { font-weight: bold; font-size:12px; color:#747474; text-decoration: none; line-height:26px; }
    .back-button:hover { color:#333;}
    .add-button,
    .add-button span { float:left; height:26px; background:url(<%= request.getContextPath() %>/assets/images/add-button.gif) no-repeat 0 0; padding:0 0 0 28px; }
    .add-button span { background-position:right 0; padding:0 10px 0 0; }
    .add-button { font-weight: bold; font-size:12px; color:#747474; text-decoration: none; line-height:26px; }
    .add-button:hover { color:#333;}
    </style>
        
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
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/smoothness/jquery-ui.css">

</head>
<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%= request.getContextPath() %>/DirViewDashboard"> <img alt="Charisma Logo" src="<%= request.getContextPath() %>/assets/img/logo20.png" class="hidden-xs"/>
                <span>E-Registration Desk</span></a>
                    
            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs">
                                      <%
                      HttpSession sobj = request.getSession(false);
                            if(sobj != null)
                            {
                                if(sobj.getAttribute("Dir_is_logged_in") != null && sobj.getAttribute("Dir_is_logged_in") != null)
                                {
                        %>
                        Welcome <strong><%=  sobj.getAttribute("Dir_is_logged_in") %></strong>
                         <%
                                }
                            else
                            {
                                response.sendRedirect(request.getContextPath()+"/DirViewLogin");
                            }

                            }
              
                %>        </span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    
                    <li><a href="<%= request.getContextPath() %>/DirDatabaseBackup">Backup</a></li>
                    <li class="divider"></li>
                    <li><a href="<%= request.getContextPath() %>/AllLogoutController?str=d">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                   
                
            </ul>

        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <%@include file="menu.jsp" %>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">

    