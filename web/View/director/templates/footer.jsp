
<%-- if (!isset($no_visible_elements) || !$no_visible_elements) { %>
<!-- content ends -->
</div>
<!--/#content.col-md-0-->
<?php } ?>
</div>
<!--/fluid-row-->
<?php if (!isset($no_visible_elements) || !$no_visible_elements) { ?>
--%>
<hr>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">Ã?</button>
        <h3>Settings</h3>
      </div>
      <div class="modal-body">
        <p>Here settings can be configured...</p>
      </div>
      <div class="modal-footer"> <a href="#" class="btn btn-default" data-dismiss="modal">Close</a> <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a> </div>
    </div>
  </div>
</div>
<center><footer class="row"style="margin-left:400px;"> <span style="float:left">Copyright &copy; 2016 - UTU. All Rights Reserved.</span>
    <span style="float:left"> Maintained by <a href="http://www.srimca.edu.in" target="_blank" title="Visit us on Srimca">www.srimca.edu.in</a> </span> </footer></center>

</div>
<!--/.fluid-container--> 

<!-- external javascript --> 

<script src="<%= request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
<link id="bs-css" href="<%= request.getContextPath() %>/assets/css/bootstrap-cerulean.min.css" rel="stylesheet">
<!-- library for cookie management --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.cookie.js"></script> 
<!-- calender plugin --> 
<script src='<%= request.getContextPath() %>/assets/js/moment.min.js'></script> 
<script src='<%= request.getContextPath() %>/assets/js/fullcalendar.min.js'></script> 
<!-- data table plugin --> 
<script src='<%= request.getContextPath() %>/assets/js/jquery.dataTables.min.js'></script> 

<!-- select or dropdown enhancer --> 
<script src="<%= request.getContextPath() %>/assets/js/chosen.jquery.min.js"></script> 
<!-- plugin for gallery image view --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.colorbox-min.js"></script> 
<!-- notification plugin --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.noty.js"></script> 
<!-- library for making tables responsive --> 
<script src="<%= request.getContextPath() %>/assets/js/responsive-tables.js"></script> 
<!-- tour plugin --> 
<script src="<%= request.getContextPath() %>/assets/js/bootstrap-tour.min.js"></script> 
<!-- star rating plugin --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.raty.min.js"></script> 
<!-- for iOS style toggle switch --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.iphone.toggle.js"></script> 
<!-- autogrowing textarea plugin --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.autogrow-textarea.js"></script> 
<!-- multiple file upload plugin --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.uploadify-3.1.min.js"></script> 
<!-- history.js for cross-browser state change on ajax --> 
<script src="<%= request.getContextPath() %>/assets/js/jquery.history.js"></script> 
<!-- application script for Charisma demo --> 
<script src="<%= request.getContextPath() %>/assets/js/charisma.js"></script>

<script type="text/javascript" src="<%= request.getContextPath() %>/assets/js/bootstrap-datetimepicker.min.js"></script>
<%--
if($page=="users/create" || $page=="users/edit")
{
?>

<?php 
}
--%>

</body></html>