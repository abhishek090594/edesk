<%@page import="java.sql.ResultSet"%>
<%@include file="templates/header.jsp" %>
<!-- start datepicker -->    
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/smoothness/jquery-ui.css">
  <script src="<%= request.getContextPath() %>/assets/js/jquery-1.9.1.js"></script>
   <script src="<%= request.getContextPath() %>/assets/js/jquery-ui.js"></script>
	
 
  <script type="text/javascript">
    $(function (){
       $("#datepicker").datepicker({
         changeMonth:true,
         yearRange:"-100:+100",
         dateFormat:"yy-mm-dd",
         onClose:function (selectedDate){
             $("#e").datepicker("option","minDate",selectedDate);
         }
       });
    });
    $(function (){
       $("#datepicker1").datepicker({
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
<!-- end datepicker -->
<div>
        <ul class="breadcrumb">
            <li>
                Dashboard
            </li>
            <li>
               Task Assign
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
        <h2><i class="glyphicon glyphicon-user"></i>Task Assign</h2>

       <div class="box-icon">
                   
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
    </div>
        
    
    <div class="box-content">

                                        <form method="post" action="<%= request.getContextPath() %>/DirAddTaskAssignController">
                                            
                                        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive" >
                                            <tr>
                                                <td>Start Date</td>
                                                <td><input readonly="readonly" type="text" id="datepicker" name="sdate"/></td>
                                                <td>End Date</td>
                                                <td><input readonly="readonly" type="text" id="datepicker1" name="edate"/></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">Panel Head</td>
                                                <td colspan="2"><select name="slctpanel">
                                               <%                                                             
                                                    ResultSet rs1= (ResultSet)request.getAttribute("getPanelHeadList");
                                                            
                                                      while(rs1.next())
                                                           {
                                                         %>     
                                                         <option value="<%= rs1.getInt("ph_id") %>"><%= rs1.getString("ph_name") %></option>
						<%	
                                                        }
                                                        %>
                                            </select></td>
                                               
                                            </tr>
                                            <tr>
                                                <td colspan="2">Description</td>
                                                <td colspan="2">
                              <textarea name="txtdesc" class="field size1" rows="2" cols="1" style="min-height: 0px;width: 263px;"></textarea>
                               
                                                </td>
                                           </tr>
                                            <tr>
                                                <td colspan="4"><input class="add-button"  style="width: 160px;" type="submit" name="btntskassign" value="Assign Task" /></td>
                                            </tr>
                                            
                                            
                                           
    </table>
        </div>
     <script type="text/javascript" src="<%= request.getContextPath() %>/assets/js/ajax.js">
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