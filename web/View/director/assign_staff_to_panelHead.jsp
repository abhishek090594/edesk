<%@page import="java.sql.ResultSet"%>
<%@include file="templates/header.jsp"  %>
<script type="text/javascript">
    function valid()
    {
        var chk = frm1.chk1.value;
        if(!chk.checked)
        {
            alert("Choose The Member for Panel Head");
            return false;
        }
        return true;
    }
</script>
<div id="container">
	<div class="shell">
            <form  action="<%= request.getContextPath() %>/DirAddStaffToPanelHead" name="frm1" method="post">		
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			Staff Details
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
			
			
			<div id="content" >
				
				<div class="box">
					<div class="box-head">
						<h2 class="left">Staff Details</h2>
						<div class="right">
                                          <!--        	<label>search articles</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="search" />
					-->	</div>
					</div>
			
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th><input type="checkbox" class="checkbox" /></th>
								<th>Name</th>
								<th>Email-ID</th>
                                                                <th>Status</th>
                                                                
							</tr>
                               <% 
                                                               
                                                           
                                                          ResultSet rs= (ResultSet)request.getAttribute("getStaffMemberList");
                                                            
                                                      while(rs.next())
                                                      {
                                                          
                                                       out.println("<tr><td>");   
                                                 /*   if(rs2.next()){
                                                       if(rs2.getInt("stf_id") == rs.getInt("stf_id")) {
                                                           out.println(rs.getInt("stf_id"));
                                                          out.println("<input  name=\"chk1\" value="+ rs.getInt("stf_id") +"  type='checkbox' class='checkbox' />");
                                                       }
                                                    */   
                                                    //   {out.println(rs.getInt("stf_id"));
                                                   out.println("<input name=\"chk1\" value="+ rs.getInt("stf_id") +"  type='checkbox' class='checkbox' />");
                                              //         }
                                            //        }    
                                                       
                                                              
                                                              out.println("</td><td>"); 
                                                              out.println(rs.getString("stf_name"));
                                                              out.println("</td><td>"); 
                                                              out.println(rs.getString("stf_emailid"));     
                                                              out.println("</td><td>"); 
                                                              if(rs.getInt("stf_status") == 0)
                                                               {
                                                              out.println("Member");
                                                               }
                                                               if(rs.getInt("stf_status") == 1)
                                                               {
                                                              out.println("Panel Head");
                                                               }
                                                               
                                                              
                                                                               
                                                              out.println("</td></tr>"); 
                                                             }
                               
                                                         
                                                        %>  
						</table>
						
				
					</div>
					
				</div>
				
							</div>

			<div id="sidebar">
				
				<div class="box">
					
					<div class="box-head">
						<h2>Management</h2>
					</div>
					
					<div class="box-content">
						
				<!--	<p class="select-all"><input type="checkbox" class="checkbox" /><label>select all</label></p>
						<p><a href="#">Delete Selected</a></p>
						
						<!-- Sort -->
                                                <div class="sort" style="border-top: 0px;padding-top: 0px;margin-top: 0px;">
							<label>Select Panel Head</label>
                                                        <select name="ph1" class="field">
                                                      <%       
                                                            ResultSet rs1= (ResultSet)request.getAttribute("getPanelHeadList");
                                                            
                                                      while(rs1.next())
                                                           {
                                                         %>     
                                                         <option value="<%= rs1.getInt("ph_id") %>"><%= rs1.getString("ph_name") %></option>
						<%	
                                                        }
                                                        %>
					
                                                        </select>
							</div>
                                                        <br>
                      <span><input type="submit" class="add-button"  style="width: 160px;" name="btnsubmit" value="Add To Panel Head" /></span>
    
                                                <div class="cl">&nbsp;</div>
						
					</div>
				</div>
			
			</div>
			
			<div class="cl">&nbsp;</div>			
		</div>
        </form>
	</div>
</div>
<%@include file="templates/footer.jsp"  %>
