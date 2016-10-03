<%@include file="templates/header.jsp"  %>
<%@page import="java.sql.*" %>
<script type="text/javascript">
    $(document).ready(function(){
        //$("#s").datepicker({ dateFormat: 'yy-mm-dd' });
         //$("#e").datepicker({ dateFormat: 'yy-mm-dd' });
         $("#phead1").hide();
         $("#phead2").hide();
         $("#staff1").hide();
         $("#staff2").hide();
         $("#clg1").hide();
         $("#clg2").hide();
         $("#rdPanel").change(function (){
             $("#phead1").show();
             $("#phead2").show();
             $("#clg1").hide();
             $("#clg2").hide();
             $("#staff1").hide();
             $("#staff2").hide();
         });
         $("#rdStaff").change(function (){
             $("#phead1").hide();
             $("#phead2").hide();
             $("#clg1").hide();
             $("#clg2").hide();
             $("#staff1").show();
             $("#staff2").show();
         });
         $("#rdClg").change(function (){
             $("#phead1").hide();
             $("#phead2").hide();
             $("#clg1").show();
             $("#clg2").show();
             $("#staff1").hide();
             $("#staff2").hide();
         });
         
         
         
       
    });
     
</script>
<script type="text/javascript">
    $(function (){
       $("#s").datepicker({
         changeMonth:true,
         yearRange:"-100:+100",
         dateFormat:"yy-mm-dd",
         onClose:function (selectedDate){
             $("#e").datepicker("option","minDate",selectedDate);
         }
       });
    });
    $(function (){
       $("#e").datepicker({
         changeMonth:true,
         yearRange:"-100:+100",
         dateFormat:"yy-mm-dd",
         minDate:0,
         onClose:function (selectedDate){
             $("#e").datepicker("option","minDate",selectedDate);
         }
       });
    });
    
</script>
<div id="container">
    <%
    Class.forName("com.mysql.jdbc.Driver");
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
    Statement statement = connect.createStatement( );
    ResultSet rs=null;
    %>
	<div class="shell">
		
		<div class="small-nav">
			<a href="#">Report</a>
			<span>&gt;</span>
			Graph regarding inquiry 
		</div>

	  <% if(request.getAttribute("msg") != null) { %>
		<div id="div-close" class="msg msg-ok">
			<p><strong><% out.println(request.getAttribute("msg")); %></strong></p>
			<a href="#" class="close" onclick="return closediv()">close</a>
		</div>
                <% } %>	<br />
		
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			
			<div id="content">
				
                            <div class="box" style="width: 990px;height: 400px;">
					<div class="box-head">
						<h2 class="left">Report Regarding Inquiry Confirm or Not Confirm</h2>
						<div class="right">
						<!--	<label>search articles</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="search" />
					-->	</div>
					</div>
			
                                    <div class="table" style="padding-left: 10px;padding-top: 20px;">
                                        <form  method="post" action="<%= request.getContextPath() %>/ChartsReportServlet" target="_blank">
                                            
                                        <table>
                                            <tr>
                                            <td colspan="4">Select Chart Type</td>
                                                <td colspan="8"><select name="slctType">
                                                        <option value="Pie">Pie</option>
                                                        <option value="Column">Column</option>
                                                        <option value="Line">Line</option>
                                                    </select></td>
                                            </tr>
                                            <tr>
                                                <td colspan="4">Start Date</td>
                                                <td colspan="8"><input required="required"  type="text" id="s" name="sdate"/></td>
                                                <td colspan="4">End Date</td>
                                                <td colspan="8"><input required="required" type="text" id="e" name="edate"/></td>
                                            </tr>
                                            <tr>
                                                <td colspan="4"><input type="radio" name="rdGrp" checked="checked" value="PanelWise" id="rdPanel">Panel Head Wise</td>
                                                <td colspan="4"><input type="radio" name="rdGrp" value="StaffWise" id="rdStaff">Staff Wise</td>
                                                <td colspan="4"><input type="radio" name="rdGrp" value="ClgWise" id="rdClg">Institute Wise</td>
                                                
                                            </tr>
                                           
                                            <tr id="panelhead">
                                                <td id="phead1" colspan="4">Panel Head</td>
                                                <td id="phead2" colspan="8"><select name="slctpanel">
                                                        <option selected="selected" value="">--Select--</option>
                                                        <%
                                                        try{
                                                            
                                                            rs= statement.executeQuery("SELECT * FROM panelhead");
                                                             while(rs.next()){
                                                        %>
                                                        <option value="<%= rs.getInt("ph_id") %>"><%= rs.getString("ph_name") %></option>
                                                        <%
                                                                 }}
                                                                 catch(Exception e)
                                                                 {
                                                                     System.err.println(e);
                                                                 }
                                                        %>
                                                    </select></td>
                                                <td id="staff1" colspan="4">Staff</td>
                                                <td id="staff2" colspan="8"><select name="slctstaff">
                                                        <option selected="selected" value="">--Select--</option>
                                                        <%
                                                        try{
                                                            rs= statement.executeQuery("SELECT * FROM staff");
                                                             while(rs.next()){
                                                        %>
                                                        <option value="<%= rs.getInt("stf_id") %>"><%= rs.getString("stf_name") %></option>
                                                        <%
                                                                 }}
                                                                 catch(Exception e)
                                                                 {
                                                                     System.err.println(e);
                                                                 }
                                                        %>
                                                    </select></td>
                                            </tr>
                                           <tr>
                                                <td id="clg1" colspan="4">College</td>
                                                <td id="clg2" colspan="8" ><select name="slctcollege">
                                                        <option selected="selected" value="">--Select--</option>
                                                          <%
                                                        try{
                                                            rs= statement.executeQuery("SELECT * FROM institutename");
                                                             while(rs.next()){
                                                        %>
                                                        <option value="<%= rs.getInt("inn_id") %>"><%= rs.getString("inn_name") %></option>
                                                        <%
                                                                 }}
                                                                 catch(Exception e)
                                                                 {
                                                                     System.err.println(e);
                                                                 }
                                                        %>
                                                    </select></td>
                                               
                                               
                                            </tr> 
                                            <tr>
                                                <td colspan="8"><input type="submit" id="generateReport" name="btnreport" value="Generate Report" /></td>
                                            </tr>
                                            
                                            
                                           
                                        </table> 
                                      </form>
            
                        	</div>
					
				</div>
				
							</div>

			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
</div>
<%@include file="templates/footer.jsp"  %>
