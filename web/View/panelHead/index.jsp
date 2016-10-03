<%@include file="templates/header.jsp"  %>
   
<div id="container">
	<div class="shell">
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			Graph regarding inquiry 
		</div>

	<!--	<div id="div-close" class="msg msg-ok">
			<p><strong>Your file was uploaded successfully!</strong></p>
			<a href="#" class="close" onclick="return closediv()">close</a>
		</div>
	
		<div id="div-error-close" class="msg msg-error">
			<p><strong>You must select a file to upload first!</strong></p>
			<a href="#" class="close" onclick="return closeerrordiv()">close</a>
		</div>
	-->	<br />
		
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			
			<div id="content">
				
                            <div class="box" style="width: 990px;height: 400px;">
					<div class="box-head">
						<h2 class="left">Graph</h2>
						<div class="right">
						<!--	<label>search articles</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="search" />
					-->	</div>
					</div>
			
                                    <div class="table" style="padding-left: 400px;padding-top: 160px;">
                                        <!--<h1 style="color: black;"><i>Welcome to Dashboard</i></h1>-->
						<img src="<%= request.getContextPath() %>/PhPieChartServlet" title="Admission Confirmation Details using Column Chart" style="margin: -185px;">	
					</div>
					
				</div>
				
							</div>

			
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
</div>
<%@include file="templates/footer.jsp"  %>
