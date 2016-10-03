<%@page import="java.sql.ResultSet"%>
<%@include file="templates/header.jsp"  %>

<div id="container">
	<div class="shell">
		
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			Student Inquiry
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
			
			
                        <div id="content" style="width: 988px;">
				
				<div class="box">
					<div class="box-head">
						<h2 class="left">Student Inquiry List</h2>
						<div class="right">
							<label>Search</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="search" />
						</div>
					</div>
			
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th><input type="checkbox" class="checkbox" /></th>
								<th>Name</th>
								<th>E-mail ID</th>
								<th>Status</th>
                                                                <th>Date</th>
								<th width="110" class="ac">Action</th>
							</tr>
                                                        
        <% 
                                                               
                                                            
                                                          ResultSet rs= (ResultSet)request.getAttribute("getStudentInquiryList");
                                                            
                                                            /*DirViewStaffListController dslc = new DirViewStaffListController(); 
                                                         //   ResultSet rs = (ResultSet)request.getAttribute("getStaffList");
                                                        Iterator<String> rs = (Iterator<String>)request.getAttribute("getStaffList");
                                                        String rec=null;
                                                   */     while(rs.next())
                                                           {
                                                              
                                                              out.println("<tr><td>"); 
                                                              out.println("<input type='checkbox' class='checkbox' />");
                                                              out.println("</td><td>");
                                                              out.println(rs.getString("stud_name"));
                                                              out.println("</td><td>"); 
                                                              out.println(rs.getString("stud_emailid"));     
                                                              out.println("</td><td>"); 
                                                              if(rs.getInt("stud_status") == 0)
                                                               {
                                                              out.println("Come For Inquiry");
                                                               }
                                                               if(rs.getInt("stud_status") == 1)
                                                               {
                                                              out.println("Confirmed");
                                                               }
                                                               
                                                              out.println("</td><td>");
                                                               out.println(rs.getString("stud_inquirydate")); 
                                                             
                                                              out.println("</td><td>"); 
                                                              
                      out.println("<a onclick=return CONFIRM('Are you sure you want to delete?')  href="+ request.getContextPath() +"/StfDeleteStudentInquiryData?did="+ rs.getInt("stud_id") +" class='ico del'>Delete</a><a href="+ request.getContextPath() +"/StfEditInquiryFormDetailController?edtid="+ rs.getInt("stud_id") +" class='ico edit'>Edit</a><a href='#' class='ico view'>View</a>");
                                                                               
                                                              out.println("</td></tr>"); 

                                                           }
                                            
                                                         
                                                        %>  
                                                  
  </table>
						
					</div>
					
				</div>
				
							</div>
<!--
			<div id="sidebar">
	-->			
			<!--	<div class="box">
					
					<div class="box-head">
						<h2>Management</h2>
					</div>
					
					<div class="box-content">
						<a href="add_staff.jsp" class="add-button"><span>Add Staff Members</span></a>
						<div class="cl">&nbsp;</div>
			-->			
<!--						<p class="select-all"><input type="checkbox" class="checkbox" /><label>select all</label></p>
						<p><a href="#">Delete Selected</a></p>
				-->		
						<!-- Sort -->
	<!--					<div class="sort">
							<label>Sort by</label>
							<select class="field">
								<option value="">Title</option>
							</select>
							<select class="field">
								<option value="">Date</option>
							</select>
							<select class="field">
								<option value="">Author</option>
							</select>
						</div>
					-->	
		<!--			</div>
				</div>   -->
		<!--	
			</div>  -->
			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
</div>
<%@include file="templates/footer.jsp"  %>
