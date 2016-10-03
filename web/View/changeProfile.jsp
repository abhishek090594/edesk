
<%@page import="java.sql.ResultSet" %>
<%@include file="templates/header.jsp"  %>

<!DOCTYPE html>
<div id="container">
    
	<div class="shell">
		
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			Inquiry Form
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
						<h2>Change Profile</h2>
					</div>
				     <%     
                                                                ResultSet rs1= (ResultSet)request.getAttribute("profileData");
                                                            while(rs1.next())
                                                               {

                                                                %>                                   
                                   		

                                                                <form method="post" name="frm1" action="<%= request.getContextPath() %>/stfChangeProfileController">
                                                                <div class="form">
                                                                    <p>
                                                                    <input type="hidden" name="h1" value="<%= rs1.getInt("stf_id") %>" />
                                                                    <input type="hidden" name="h2" value="<%= rs1.getString("stf_emailid") %>" />
									<span class="req"></span>
									<label>Name<span></span></label>
                                                                        <input type="text" name="txtname" value="<%= rs1.getString("stf_name") %>" class="field size1" />
								</p>
                                                                <p>
											<span class="req"></span>
									<label>E-mail ID <span></span></label>
                                                                        <input name="txtemail" value="<%= rs1.getString("stf_emailid") %>" type="text" class="field size1" />
								</p>
                                                                
                                                        <p>
											<span class="req"></span>
									<label>Contact<span></span></label>
                                                                        <input name="txtcontact" value="<%= rs1.getString("stf_contact") %>" type="text" class="field size1" />
								</p>	
	
                                                
                                                                
								<p class="inline-field">
							
                                                        		<span class="req"></span>
									<label>Address<span></span></label>
                                                                        <textarea name="txtaddr"  class="field size1" rows="2" cols="30"  style="min-height: 0px;"><%= rs1.getString("stf_address") %></textarea>
							 
                                                                </p>
								
								       
							
						</div>
						<div class="buttons">
                                                    <input  type="submit" name="btnsubmit" class="button" value="Update" />
                                                   <input type="reset" name="btnclear" class="button" value="Clear" />
						</div>

					</form>
				<% } %>

				</div>
			</div>

			<div id="sidebar">
				
				<div class="box">
					
					<div class="box-head">
						<h2>Management</h2>
					</div>
					
					<div class="box-content">
						<a href="<%= request.getContextPath() %>/stfViewChangePwdController" class="add-button"><span>Change Password</span></a>
						<div class="cl">&nbsp;</div>
						
			</div>
						
					</div>
				</div> 
			
			</div>
			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
<%@include file="templates/footer.jsp"  %>