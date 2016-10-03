
<%@page import="java.sql.ResultSet" %>
<%@include file="templates/header.jsp"  %>
    	<script type="text/javascript">
                                   
                function validate()
                {
                    var nme = frm1.txtname.value;
                    var per = frm1.txtper.value;
                    var con = frm1.txtcontact.value;
                    var email = frm1.txtemail.value;
               	    var ex=/^\w+([\.-])*\w+@\w+(\.\w{2,3})+$/;
                    var contreg = new RegExp('^((0)|((7)|(8))|(9))[0-9]{9}$', 'i');    
                    var addr = frm1.txtaddr.value;
                    if(!nme.trim())
                    {
                        alert("Name is mandatory");
                        frm1.txtname.focus();
                        return false;
                    }
                    
                if(!per.trim())
                    {
                        alert("Percentage is mandatory");
                        frm1.txtper.focus();
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
                    
               
                    if(!nme.match(/^[A-Za-z ]+$/))
                    {
                       alert("Name must be in characters");
                        frm1.txtname.focus();
                        return false;   
                    }
                    
                     if(!per.match(/^[0-9]+$/))
                    {
                        alert("Percentage must be in digits");
                          frm1.txtper.focus();
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
						<h2>Student Inquiry Form</h2>
					</div>
				     <%     
                                                                ResultSet rs1= (ResultSet)request.getAttribute("edit_stud_detail");
                                                            while(rs1.next())
                                                               {

                                                                %>                                   
                                   		

                                                                <form onsubmit="return validate()"  method="post" name="frm1" action="<%= request.getContextPath() %>/phUpdateStudentDetailController">
                                    <div class="form">
								<p>
                                                                    <input type="hidden" name="h1" value="<%= rs1.getInt("s.stud_id") %>" />
									<span class="req"></span>
									<label>Name<span></span></label>
                                                                        <input type="text" name="txtname" value="<%= rs1.getString("s.stud_name") %>" class="field size1" />
								</p>
                                                                	
									<span class="req"></span>
									<label>Institute<span></span></label>
                                                                  <select name="drpdwninstitue" class="field size2" style="width:724px;">
                                           <%     
                                                                ResultSet rs3= (ResultSet)request.getAttribute("instituteDetails");
                                                            while(rs3.next())
                                                               {
                                                                    if(rs3.getInt("inn_id")== rs1.getInt("inn_id"))
                                                                    {
                                                                        %>
                                                                              
                                                                      
                                                                        <option selected="selected" value="<%= rs1.getInt("s.inn_id") %>"><%= rs1.getString("i.inn_name") %></option>
                                                                        
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
                                                                             <select name="drpdwncourse" class="field size2" style="width:724px;">
                                              
                                                        <%     
                                                                ResultSet rs2= (ResultSet)request.getAttribute("courseDetails");
                                                            while(rs2.next())
                                                               {
                                                                    if(rs2.getInt("con_id")== rs1.getInt("con_id"))
                                                                    {
                                                                        %>
                                                                        <option selected="selected" value="<%= rs1.getInt("s.con_id") %>"><%= rs1.getString("c.con_name") %></option>
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
                                                                        <input name="txtper" value="<%= rs1.getString("s.stud_percentage") %>" type="text" class="field size1" />
								</p>
                                                            
                                                         						<p>
											<span class="req"></span>
									<label>E-mail ID <span></span></label>
                                                                        <input name="txtemail" value="<%= rs1.getString("s.stud_emailid") %>" type="text" class="field size1" />
								</p>
                                                                
                                                        <p>
											<span class="req"></span>
									<label>Contact<span></span></label>
                                                                        <input name="txtcontact" value="<%= rs1.getString("s.stud_contact") %>" type="text" class="field size1" />
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
                                                                        <textarea name="txtaddr"  class="field size1" rows="2" cols="30"  style="min-height: 0px;"><%= rs1.getString("s.stud_address") %></textarea>
							 
                                                                </p>
								
								       
							
								
							<p>
											<span class="req"></span>
									<label>Status<span></span></label>
                                                                        <select name="drpdwnstatusdrpdwnstatus" class="field size2" style="width:724px;">
                                                                           <%
                                                                            if(Integer.parseInt(rs1.getString("s.stud_status")) == 1)
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
						<a href="<%= request.getContextPath() %>/StfViewStudentInquiryListController" class="add-button"><span>Back to Student List</span></a>
						<div class="cl">&nbsp;</div>
						
			</div>
						
					</div>
				</div> 
			
			</div>
			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
<%@include file="templates/footer.jsp"  %>