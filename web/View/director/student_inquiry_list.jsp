<%@page import="java.sql.ResultSet"%>
<%@include file="templates/header.jsp" %>

<div>
        <ul class="breadcrumb">
            <li>
                Students
            </li>
            <li>
               Students Listing
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
        <h2><i class="glyphicon glyphicon-user"></i>  Students Listing</h2>

       <div class="box-icon">
                   
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
    </div>
        
    
    <div class="box-content">
    	<form method="post" action="">
        
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive" >
            <thead>
                    <tr>
                            <th><input type="checkbox" class="checkbox" /></th>
                            <th>Name</th>
                            <th>Staff Member</th>
                            <th>Status</th>
                            <th>Date</th>
                            <th width="200" class="ac">Action</th>
                    </tr>
            <tbody>
      <% 
                                                               

                    ResultSet rs= (ResultSet)request.getAttribute("getStudentList");

                      /*DirViewStaffListController dslc = new DirViewStaffListController(); 
                   //   ResultSet rs = (ResultSet)request.getAttribute("getStaffList");
                  Iterator<String> rs = (Iterator<String>)request.getAttribute("getStaffList");
                  String rec=null;
             */     while(rs.next())
                     { %>

                        <tr>
                            <td><input type='checkbox' class='checkbox' /></td>
                            <td><%= rs.getString("si.stud_name") %></td>
                            <td><%= rs.getString("st.stf_name") %></td>
                            <td>
                        <% if(rs.getInt("si.stud_status") == 0)
                         { %>
                        Come for Inquiry
                        <% }
                         if(rs.getInt("si.stud_status") == 1)
                         { %>
                        Confirmed
                         <% } %>

                        </td><td>
                         <%= rs.getString("si.stud_inquirydate") %>

                        </td><td>

                            <a onclick="return window.confirm(\'Are You Sure?\');"  href="<%= request.getContextPath() %>/DirDeleteStudentInquiryData?did=<%= rs.getInt("si.stud_id") %>"><img src="<%= request.getContextPath() %>/assets/images/delete.gif"></a>
                       <a href="<%= request.getContextPath() %>/DirViewStudentDetail?vid=<%= rs.getInt("si.stud_id") %>"><img src="<%= request.getContextPath() %>/assets/images/view.gif"></a>

                      </td></tr>

                    <% }    %>  
            </tbody>
    </table>
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