<%@page import="javax.sound.sampled.ReverbType"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HttpSession ses=request.getSession();
		String id=(String)ses.getAttribute("empId");
		if(id.equals("anonymousUser"))
		{
			response.sendRedirect("/AccessRoles/login");
		}


%>


<html>

<head>
	<title>Leave Management System</title>
	
	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link href="<c:url value="/static/css/hello.css" />" rel="stylesheet">
	<!-- Latest compiled JavaScript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<!-- ANGULARJS scripts -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="http://angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
	
	<script src="<c:url value="/static/js/app.js" />"></script>
	<script src="<c:url value="/static/js/service/EmpService.js" />"></script>
	<script src="<c:url value="/static/js/controller/empdetailsCtrl.js" />"></script>
	<script src="<c:url value="/static/js/controller/newleaveCtrl.js" />"></script>
	<script src="<c:url value="/static/js/controller/approvedleaveCtrl.js" />"></script>
	<script src="<c:url value="/static/js/controller/newempCtrl.js" />"></script>
	<script src="<c:url value="/static/js/controller/approveleaveempCtrl.js" />"></script>
	
</head>



<body ng-app="lmsApp">
	<script>
		var id = ${empId}; //${empId} is returned from spring framework
	</script>
	
	<div class="panel-group">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h1><center>Leave Management System</center></h1>
			</div>
			
			<div class="panel-body" >
				<div align="right">
					<!-- Spring Security part -->
					<sec:authorize access="hasRole('ROLE_USER')">
						<!-- For login user -->
						<c:url value="/logout" var="logoutUrl" />
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
						<script>
							function formSubmit() {
								document.getElementById("logoutForm").submit();
							}
						</script>
			
						<a href="javascript:formSubmit()"><strong> Logout </strong></a>&nbsp;&nbsp;&nbsp;&nbsp;
			
					</sec:authorize>
				</div>
			
				<br><br>
				<div class="container">
					<div ui-view></div>
				</div>
	
			</div>
		</div>
	</div>
	
	
	

	
	
	
</body>


<!--<script src="/js/app.js"></script>
<script src="/js/controller/controller.js"></script>-->


</html>