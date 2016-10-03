<%-- 
    Document   : login.jsp
    Created on : Mar 9, 2016, 7:37:35 PM
    Author     : SOHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    	<script type="text/javascript">
                                   
                function validate()
                {
                    var nme = frm1.txtname.value;
                    var con = frm1.txtcontact.value;
                    var email = frm1.txtemail.value;
                    var pwd = frm1.txtpwd.value;
                    var cpwd = frm1.txtcpwd.value;
               	    var ex=/^\w+([\.-])*\w+@\w+(\.\w{2,3})+$/;
                    var contreg = new RegExp('^((0)|((7)|(8))|(9))[0-9]{9}$', 'i');    
                    var addr = frm1.txtaddr.value;
                    if(!nme.trim())
                    {
                        alert("Name is mandatory");
                        frm1.txtname.focus();
                        return false;
                    }
                    
                      if(!addr.trim())
                    {
                        alert("Address is mandatory");
                        frm1.txtaddr.focus();
                        return false;
                    }
                      if(!con.trim())
                    {
                        alert("Contact is mandatory");
                        frm1.txtcontact.focus();
                        return false;
                    }
                      if(!email.trim())
                    {
                        alert("Email ID is mandatory");
                        frm1.txtemail.focus();
                        return false;
                    }
                    
                      if(!pwd.trim())
                    {
                        alert("Password is mandatory");
                        frm1.txtpwd.focus();
                        return false;
                    }
                    
                      if(!cpwd.trim())
                    {
                        alert("Confirm Password is mandatory");
                        frm1.txtcpwd.focus();
                        return false;
                    }
                    
                    if(pwd != cpwd)
                    {
                         alert("Confirm Password doesn't match with Password");
                        frm1.txtcpwd.focus();
                        return false;
                        
                    }
                    if(!nme.match(/^[A-Za-z ]+$/))
                    {
                       alert("Name must be in characters");
                        frm1.txtname.focus();
                        return false;   
                    }
                    if(!con.match(/^[0-9]{10}$/) || !con.match(contreg))
                    {
                         alert("Contact number should be in digits and must be of 10 digits and must be start with 0,7,8 or 9");
                          frm1.txtcontact.focus();
                        return false;
            
                    }
                    if(!email.match(ex))
                    {
                        alert("Email ID is not valid");
                        frm1.txtemail.focus();
                        return false;
                    }
                    return true;
                }
		function closediv()
		{
			document.getElementById('div-close').style.display = "none";
		}
		
		function closeerrordiv()
		{
			document.getElementById('div-error-close').style.display = "none";
		}
	</script>
    <style type="text/css">
        input[type="reset"]{
	width: 99%;
	padding: 3%;
	margin-bottom: 8%;
	background: #109cde;
	font-family: 'Open Sans', sans-serif;
	color: #ECECEC;
	box-shadow: inset 0px 0px 10px #666464;
	-webkit-text-shadow: 0px 0px 3px #000;
	-moz-text-shadow: 0px 0px 3px #000;
	-o-text-shadow: 0px 0px 3px #000;
	-ms-text-shadow: 0px 0px 3px #000;
	font-size: 20px;
	outline: none;
	border: none;
	cursor: pointer;
	font-weight:500;
	border-radius: 5px;
	transition: 0.5s;
	-webkit-appearance:none;
	-webkit-transition: 0.5s;
	-moz-transition: 0.5s;
	-o-transition: 0.5s;
	-ms-transition: 0.5s;
}
input[type="reset"]:hover{
	background:#107FFF;
	color:#fff;
}
         input[type="file"],textArea{
	text-align:left;
	position: relative;
	width:92%;
	padding:3%;
	background:#D3D3D3;
	margin-bottom: 6%;
	font-family: 'Open Sans', sans-serif;
	color: #000;
	font-weight:600;
	font-size: 16px;
	outline: none;
	border: none;
	border-radius: 5px;
	border:1px solid #DED6D6;
	-webkit-appearance:none;
}
 input[type="file"]:hover,textArea:hover{
 	border:1px solid #949494;
	transition:0.5s;
	-webkit-transition:0.5s;
	-moz-transition:0.5s;
	-o-transition:0.5s;
	-ms-transition:	0.5s;
 	
 }
        
    </style>
	<title>E-Registration Desk - Staff</title>
		<meta charset="utf-8">
                <link href="<%= request.getContextPath() %>/css/login.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="shortcut icon" href="#" type="image/x-icon">
		
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
		
</head>
<body>
	<div class="main">
            <div class="login-form" style="width: 500px;">
                <h1 style="padding-top: 6%">Staff Registration</h1>
      <% if(request.getAttribute("msg") != null) { %>
      <div id="div-close" class="msg" style="margin: 22px;">
			<p><strong><% out.println(request.getAttribute("msg")); %></strong></p>
			<a href="#" class="close" onclick="return closediv()">close</a>
		</div>
                <% } %>
                <% if(request.getAttribute("err") != null) { %>
                <div id="div-error-close" class="err" style="margin: 22px;">
			<p><strong><% out.println(request.getAttribute("err")); %></strong></p>
			<a href="#" class="close" onclick="return closeerrordiv()">close</a>
		</div>
                <% } %>
               
                        <div class="head" >
                                           <!-- <img src="#" alt=""/>
					--></div>
                <form action="<%= request.getContextPath() %>/StfAddStaffController" method="post" name="frm1" onsubmit="return validate()">
<!--						<input type="text" class="text" value="" placeholder="Username" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'USERNAME';}" >
						<input type="password" value="" onFocus="this.value = '';" placeholder="Password" onBlur="if (this.value == '') {this.value = 'Password';}">
               -->                                                        
                                                
                                               <input type="text" name="txtname" class="field size1" placeholder="Name" />
                                               <textarea name="txtaddr" class="field size1" rows="10" cols="30" placeholder="Address"></textarea>
                                               <input name="txtcontact" type="text" class="field size1" placeholder="Contact" />
                                               <input name="txtemail" type="text" class="field size1" placeholder="Email ID" />
                                               <input name="txtpwd" type="password" class="field size1" placeholder="Password" />
                                               <input name="txtcpwd" type="password" class="field size1" placeholder="Confirm Password"/>
                    
                                                
                                               <div class="submit">
                   <input type="submit" name="btnsubmit" class="button" value="Add" />
                   <input type="reset" name="btnclear" class="button" value="Clear" />                               
                                        			</div>	
	<p><a href="<%= request.getContextPath() %>/StfLoginController">Login</a></p>			
				</form>
			</div>
		<div class="copy-right">
			<p>Copyright &copy; 2016 <a href="#">E-Registration Desk</a></p>
		</div>
	</div>
</body>
</html>