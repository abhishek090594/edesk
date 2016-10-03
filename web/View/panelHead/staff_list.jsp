<%@page import="java.sql.ResultSet"%>
<%@include file="templates/header.jsp"  %>

<div id="container">
	<div class="shell">
		
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			Staff Details
		</div>

<!--		<div id="div-close" class="msg msg-ok">
			<p><strong>Your file was uploaded succesifully!</strong></p>
			<a href="#" class="close" onclick="return closediv()">close</a>
		</div>
	
		<div id="div-error-close" class="msg msg-error">
			<p><strong>You must select a file to upload first!</strong></p>
			<a href="#" class="close" onclick="return closeerrordiv()">close</a>
		</div>
	-->	<br />
		
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			
			<div id="content" >
				
				<div class="box">
					<div class="box-head">
						<h2 class="left">Staff Details</h2>
						<div class="right">
                                                  	<label>search articles</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="search" />
						</div>
					</div>
			
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th><input type="checkbox" class="checkbox" /></th>
								<th>Name</th>
								<th>Email-ID</th>
                                                                <th>Contact Number</th>
                                                                
							</tr>
						  <% 
                                                               
                                                            
                                                          ResultSet rs= (ResultSet)request.getAttribute("getPanelMemberList");
                                                            
                                                            /*DirViewStaffListController dslc = new DirViewStaffListController(); 
                                                         //   ResultSet rs = (ResultSet)request.getAttribute("getStaffList");
                                                        Iterator<String> rs = (Iterator<String>)request.getAttribute("getStaffList");
                                                        String rec=null;
                                                   */     while(rs.next())
                                                           {
                                                              
                                                              out.println("<tr><td>"); 
                                                              out.println("<input  name=\"chk1\"  type='checkbox' class='checkbox' />");
                                                              out.println("</td><td>");
                                                              out.println(rs.getString("st.stf_name"));
                                                              out.println("</td><td>"); 
                                                              out.println(rs.getString("stf_emailid"));     
                                                              out.println("</td><td>"); 
                                                                                                                            
                                                              
                                               out.println(rs.getString("stf_contact"));
                                                                               
                                                              out.println("</td></tr>"); 

                                                           }
                                            
                                                         
                                                        %>  


						</table>
						

					</div>
					
				</div>
				
							</div>
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
</div>
<%@include file="templates/footer.jsp"  %>
