<%-- 
    Document   : add_staff
    Created on : Mar 9, 2016, 8:03:03 PM
    Author     : SOHIL
--%>
<%@page import="java.sql.ResultSet" %>
<%@include file="templates/header.jsp"  %>
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

<div id="container">
	<div class="shell">
		
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			View Student Detail
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
						<h2>View Student Detail</h2>
					</div>
                                        <%
                                      ResultSet rs= (ResultSet)request.getAttribute("getStudentDetail");
                           while(rs.next())
                             {
                                        %>
                                        <form method="post" name="frm1" action="<%= request.getContextPath() %>/DirViewStudentList">
						<div class="form">
								<p>
									<span class="req"></span>
									<label>Name<span></span></label>
                                                                        <input type="text" readonly="readonly" name="txtname" value="<%= rs.getString("si.stud_name") %>" class="field size1" />
								</p>
                                                                	
									<span class="req"></span>
									<label>Institute<span></span></label>
                                                                        <select disabled="disabled" name="drpdwninstitue" class="field size2" style="width:724px;">
                                                           <%     
                                                                ResultSet rs3= (ResultSet)request.getAttribute("instituteDetails");
                                                            while(rs3.next())
                                                               {
                                                                    if(rs3.getInt("inn_id")== rs.getInt("si.inn_id"))
                                                                    {
                                                                        %>
                                                                              
                                                                      
                                                                        <option  selected="selected" value="<%= rs3.getInt("inn_id") %>"><%= rs3.getString("inn_name") %></option>
                                                                        
                                                    <%                                                                              
                                                                    }
                                                                    else
                                                                    {
                                                                        
                                                                %>  
                                                                    
                                                                            <option value="<%= rs3.getInt("inn_id") %>"><%= rs3.getString("inn_name") %></option>
					                            
								<% 
                                                                    } 
                                                             }  %>
                                                                        </select>
									
								
                                                                <p>
									<span class="req"></span>
									<label>Course<span></span></label>
                                                                        <select disabled="disabled" name="drpdwncourse" class="field size2" style="width:724px;">
                                              
                                                      
                                                        <%     
                                                                ResultSet rs2= (ResultSet)request.getAttribute("courseDetails");
                                                            while(rs2.next())
                                                               {
                                                                    if(rs2.getInt("con_id")== rs.getInt("si.con_id"))
                                                                    {
                                                                        %>
                                                                        <option selected="selected" value="<%= rs2.getInt("con_id") %>"><%= rs2.getString("con_name") %></option>
					                         <%                                                                              
                                                                    }
                                                                    else
                                                                    {
                                                                        
                                                                %>  
                                                                        
                                                                            <option value="<%= rs2.getInt("con_id") %>"><%= rs2.getString("con_name") %></option>
					                            
								<% 
                                                                    } 
                                                             }  %>		
        
                                                            </select>
                                                         </p> 
                                                           <p>
											<span class="req"></span>
									<label>Percentage <span></span></label>
                                                                        <input readonly="readonly" value="<%= rs.getString("si.stud_percentage") %>"  name="txtper" type="text" class="field size1" />
								</p>
                                                            
                                                         						<p>
											<span class="req"></span>
									<label>E-mail ID <span></span></label>
                                                                        <input readonly="readonly" value="<%= rs.getString("si.stud_emailid") %>"  name="txtemail" type="text" class="field size1" />
								</p>
                                                                
                                                        <p>
											<span class="req"></span>
									<label>Contact<span></span></label>
                                                                        <input readonly="readonly" value="<%= rs.getString("si.stud_contact") %>"  name="txtcontact" type="text" class="field size1" />
								</p>	
	
                                                
                                                                
								<p class="inline-field">
								<!--	<label>Date</label>
									<select class="field size2">
										<option value="">23</option>
									</select>
									<select class="field size3">
										<option value="">July</option>
									</select>
									<select class="field size3">
										<option value="">2009</option>
									</select>
							-->	
                                                        		<span class="req"></span>
									<label>Address<span></span></label>
                                                                        <textarea readonly="readonly" name="txtaddr" class="field size1" rows="2" cols="30" style="min-height: 0px;" ><%= rs.getString("si.stud_address") %></textarea>
							 
                                                                </p>
								
								       
							
								
							<p>
											<span class="req"></span>
									<label>Status<span></span></label>
                                                                        <select disabled="disabled" name="drpdwnstatusdrpdwnstatus" class="field size2" style="width:724px;">
								      <%
                                                                            if(Integer.parseInt(rs.getString("si.stud_status")) == 1)
                                                                            {
                                                                           %>
                                                                           <option selected="selected"  value="1">Confirm</option>
                                                                       <option value="0">Come For Inquiry</option>
                                                                           <%
                                                                            }
                                                                            else
                                                                            {
                                                                             %>
                                           				<option   value="1">Confirm</option>
                                                                       <option selected="selected" value="0">Come For Inquiry</option>
                                                                             <%
                                                                            }
                                                                              %>
                                                                          </select>
									
								</p>	
							
						</div>
						
						<div class="buttons">
                                                    <input type="submit" name="btnback" class="button" value="Back to Student List" />
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
						<a href="<%= request.getContextPath() %>/DirViewStudentList" class="add-button"><span>Back to Student List</span></a>
						<div class="cl">&nbsp;</div>
						
			<!--			<p class="select-all"><input type="checkbox" class="checkbox" /><label>select all</label></p>
						<p><a href="#">Delete Selected</a></p>
				-->		
						<!-- Sort -->
			<!--			<div class="sort">
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
				-->		</div>
						
					</div>
				</div> 
			
			</div>
			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
<%@include file="templates/footer.jsp"  %>