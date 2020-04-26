<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Insert title here</title>
<style>
.footer-bottom-text {
	position: fixed;
 	 left: 0;
  	 bottom: 0;
 	 width: 100%;
	 background-color:rgba(255, 99, 71,0.5);
 	 color: white;
 	 text-align: center;
}
</style>
</head>
<body style="padding: 0; margin: 0; height: 2px;">
	<nav class="navbar navbar-expand-sm" style=" background-color:rgba(255, 99, 71,0.5);"> <!-- Brand -->
	<div class="container-fluid">
	 <div class="navbar-header">
	<a class="navbar-brand" href="#"><strong style="color:rgb(106, 150,150);font-size:40px;">X-WORKZ CM</strong></a>
	</div>
	  <ul class="nav navbar-nav navbar-right">
                    <li><a href="Register.jsp"><button type="button" class="btn btn-outline-primary">Register</button></a>
                    <a href="index.jsp"><button type="button" class="btn btn-outline-primary">Home</button></a></li>
                </ul>
	</div>
</nav>
	<!-- Main Layout -->

	<div style="color: black;">

		<h3 style="text-align: center; font: bold;">Login</h3>
		<br>

		<div>
<form action="login.do" method="post">
	<div class="container-fluidmt-5">
		<div style="height: 485px">
					
			<div class="col-sm-4">
				<b><label class="col-sm-4 col-form-label" for="Email">Email:</label></b>
				<input type="text" class="form-control" placeholder="Email" name="email">
			</div>

			<div class="col-sm-4">
				<b> <label class="col-sm-4 col-form-label for="email">Password:</label></b>
				<input type="password" class="form-control" placeholder="Password" name="password">
			</div><br>
			
			<div style="padding: 7px; padding-top: 2px;">
			<button type="submit" class="btn btn-outline-primary">Login</button>
			</div>
			<h4 align="center">${LoginMsg}</h4>
		</div>
	</div>
</form>

</div></div>
	<!-- footer -->
	<div class="footer-copyright py-3 text-center">
	<div class="footer-bottom-text" style="color:black">
			© 2020 Copyright: <a href="#"> <strong style="color:rgb(106, 150,150);">X-WORKZ.com </strong></a>
	</div>
	</div>
</body>
</html>