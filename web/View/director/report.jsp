<%@include file="templates/header.jsp"  %>
<%@page import="java.sql.*,javax.servlet.RequestDispatcher" %>
<script type="text/javascript">
    $(document).ready(function(){
        //$("#s").datepicker({ dateFormat: 'yy-mm-dd' });
         //$("#e").datepicker({ dateFormat: 'yy-mm-dd' });
         $("#chartType1").hide();
         $("#chartType2").hide();
         $("#staff1").hide();
         $("#staff2").hide();
         $("#clg1").hide();
         $("#clg2").hide();
         $("#graphReport").change(function (){
             $("#chartType1").show();
             $("#chartType2").show();
             $("#phead1").show();
             $("#phead2").show();
             $("#clg1").hide();
             $("#clg2").hide();
             $("#staff1").hide();
             $("#staff2").hide();
         });
         $("#PdfReport").change(function (){
             $("#chartType1").hide();
             $("#chartType2").hide();
             $("#phead1").show();
             $("#phead2").show();
             $("#clg1").hide();
             $("#clg2").hide();
             $("#staff1").hide();
             $("#staff2").hide();
         });
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
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/smoothness/jquery-ui.css">
<script src="<%= request.getContextPath() %>/assets/js/jquery-1.9.1.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/jquery-ui.js"></script>
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

    
	<div>
        <ul class="breadcrumb">
            <li>
                Dashboard
            </li>
            <li>
               Student Admission Report 
            </li>
            
        </ul>
    </div>
<div class="box-content alerts">
	     <% if(request.getAttribute("msg") != null) { %>
	    <div class="alert alert-danger" id="sc">
                <% out.println(request.getAttribute("msg")); %>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
        <% } %>
         <% if(request.getAttribute("err") != null) { %>
   	        <div class="alert alert-success" id="sc">
                    <% out.println(request.getAttribute("err")); %>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
        <% } %>
</div>
    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i>Student Admission Inquiry Report </h2>

       <div class="box-icon">
                   
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
    </div>
    <%
    Class.forName("com.mysql.jdbc.Driver");
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
    Statement statement = connect.createStatement( );
    ResultSet rs=null;
    %>
    <%
        if(request.getParameter("btnreport") !=null)
        {
//                RequestDispatcher robj = request.getRequestDispatcher("/PdfReportServlet");
                RequestDispatcher robj = request.getRequestDispatcher("/ChartsReportServlet");
                robj.forward(request,response);
           
        }
    %>    
    
    <div class="box-content">
                             
                <form  method="post" action="<%= request.getContextPath() %>/ChartsReportServlet" target="_blank">

       <table class="table table-striped table-bordered bootstrap-datatable datatable responsive" >
                                        <form  method="post" action="ChartsReportServlet" target="_blank">
                                            
                                        <table>
                                            <tr>
                                            <td colspan="4">Select Report Type</td>
                                            <td colspan="4"><input type="radio" name="reportGrp" checked="checked" value="PdfReport" id="PdfReport">PDF format</td>
                                            <td colspan="4"><input type="radio" name="reportGrp" value="graphReport" id="graphReport">Graphical format</td>
                                        </tr>
                                            <tr>
                                            <td colspan="4" id="chartType1">Select Chart Type</td>
                                                <td colspan="8" id="chartType2"><select name="slctType">
                                                        <option value="Pie">Pie</option>
                                                        <option value="Column">Column</option>
                                                        <option value="Line">Line</option>
                                                    </select></td>
                                            </tr>
                                            <tr id="date">
                                                <td colspan="4">Start Date</td>
                                                <td colspan="8"><input required="required"  type="text" id="s" name="sdate"/></td>
                                                <td colspan="4">End Date</td>
                                                <td colspan="8"><input required="required" type="text" id="e" name="edate"/></td>
                                            </tr>
                                            <tr id="types">
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
     <script type="text/javascript" src="<%= request.getContextPath() %>/js/ajax.js">
     </script>
    
    
     
        </form>
     <script>
            $(document).ready(function() {
                resetcheckbox();
				
				
				//$("input[type=submit]").attr('disabled','disabled');
				
                $('#selectall').click(function(event) {  //on click
                    if (this.checked) { // check select status
                        $('.checkbox').each(function() { //loop through each checkbox
                            this.checked = true;  //select all checkboxes with class "checkbox1" 
							
							             
                        });
                    } else {
                        $('.checkbox').each(function() { //loop through each checkbox
                            this.checked = false; //deselect all checkboxes with class "checkbox1" 
							//$("input[type=submit]").removeAttr('disabled');
							
							//$('input[type=submit]').prop('disabled', false);
							                   
                        });
                    }
                });
                $("#del_all").on('click', function(e) {
                    e.preventDefault();
                    var checkValues = $('.checkbox:checked').map(function()
                    {
                        return $(this).val();
                    }).get();
                    console.log(checkValues);
                    
                    $.each( checkValues, function( i, val ) {
                        $("#"+val).remove();
                        });
//                    return  false;
                    $.ajax({
                        url: '<?php echo base_url();?>news/delete_multiple',
                        type: 'post',
                        data: 'ids=' + checkValues
                    }).done(function(data) {
                        $("#respose").html(data);
                        $('#selectall').attr('checked', false);
                    });
                });

              
                
                function  resetcheckbox(){
                $('input:checkbox').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"   
				             
                   });
                }
            });
			
        </script>
     
    
     <script type="text/javascript">
	 $('#sc').delay(3000).fadeOut(400)
     </script>	
     
     

     
     
    </div>
    </div>
    </div>
    <!--/span-->

    </div><!--/row-->
       <%@include file="templates/footer.jsp" %>