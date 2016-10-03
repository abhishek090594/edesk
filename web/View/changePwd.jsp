
<%@page import="java.sql.ResultSet" %>
<%@include file="templates/header.jsp" %>
<script type="text/javascript">
                                   
                function validate()
                {
                    
                    var pwd = frm1.txtnewpwd.value;
                    var cpwd = frm1.txtcpwd.value;
       
                                
                    if(pwd != cpwd)
                    {
                         alert("Confirm Password doesn't match with Password");
                        frm1.txtcpwd.focus();
                        return false;
                        
                    }
                    
                    return true;
                }
		
	</script>
<div id="container">
	<div class="shell">
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			Change Password
		</div>
                <% if(request.getAttribute("msg") != null) { %>
		<div id="div-close" class="msg msg-ok">
			<p><strong><% out.println(request.getAttribute("msg")); %></strong></p>
			<a href="#" class="close" onclick="return closediv()">close</a>
		</div>
                <% } %>
                <% if(request.getAttribute("err") != null) { %>
                <div id="div-error-close" class="msg msg-error">
			<p><strong><% out.println(request.getAttribute("err")); %></strong></p>
			<a href="#" class="close" onclick="return closeerrordiv()">close</a>
		</div>
                <% } %>

                <br />
		
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			
			<div id="content">
					
				<div class="box">
					<div class="box-head">
						<h2>Change Password</h2>
					</div>
                                                                <form name="frm1" method="post" name="frm1" action="<%= request.getContextPath() %>/stfChangePwdController" onsubmit="return validate()">
                                                                <div class="form">
								<p>
                                                                    <input type="hidden" name="h1" value="<%= request.getAttribute("data")%>" />
                                                                    	<span class="req"></span>
									<label>Old Password<span></span></label>
                                                                        <input type="password" name="txtoldpwd"  class="field size1" />
								</p>
                                                                <p>
									<span class="req"></span>
									<label>New Password <span></span></label>
                                                                        <input name="txtnewpwd" type="password" class="field size1" />
								</p>
                                                                
                                                                <p>
									<span class="req"></span>
									<label>Confirm Password<span></span></label>
                                                                        <input name="txtcpwd"  type="password" class="field size1" />
								</p>	
	</div>
						<div class="buttons">
                                                    <input  type="submit" name="btnsubmit" class="button" value="Update" />
                                                   <input type="reset" name="btnclear" class="button" value="Clear" />
						</div>

					</form>
			

				</div>
			</div>

			<div id="sidebar">
				
				<div class="box">
					
					<div class="box-head">
						<h2>Management</h2>
					</div>
					
					<div class="box-content">
						<a href="<%= request.getContextPath() %>/stfViewProfileController" class="add-button"><span>Change Profile</span></a>
						<div class="cl">&nbsp;</div>
						
			</div>
						
					</div>
				</div> 
			
			</div>
			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
<%@include file="templates/footer.jsp"  %>