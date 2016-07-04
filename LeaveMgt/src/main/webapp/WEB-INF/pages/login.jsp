<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	HttpSession ses=request.getSession();
		
		if(ses!=null && ses.getAttribute("empid")!=null && !ses.getAttribute("empid").equals("anonymousUser"))
		{
		
			response.sendRedirect("/AccessRoles/welcome");
		}


%>



<html>
<head>
<title>Login Page</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
#login-box {
	width: 400px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="container">
	<center><h1>Leave Management System</h1></center>
			<div id="login-box">
				<div class="col-sm-2"></div>
				<center><h3>Login</h3></center>
				<br>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<div class="form-container">
					<form class="form-horizontal" name='loginForm' action="<c:url value='/login' />" method='POST'>
					<div class="row">
						<div class="form-group has-feedback">
							<div class="col-sm-2"></div>							
							<!-- <label class="control-label col-sm-4">Username :</label>-->
							<div class="col-sm-8">
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
								<input class="empid form-control " type="text" name="username"  placeholder="Employee Code" >
							</div>
						</div>
					</div>
					<div class="row">	
						<div class="form-group has-feedback">
							<div class="col-sm-2"></div>
							<!-- <label class="control-label col-sm-4">Password :</label>-->
							<div class="col-sm-8">
								<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								<input class="emppassword form-control" type='password' name='password' placeholder="Password"/>
							</div>
						</div>
					</div>	
					<div class="col-sm-2"></div>	
					<div class="row">
						<div class="form-group col-xs-8 ">
							<button type="submit" class="btn btn-primary btn-block">Submit</button>
						</div>
					</div>	
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</div>	
		</div>
</body>
</html>