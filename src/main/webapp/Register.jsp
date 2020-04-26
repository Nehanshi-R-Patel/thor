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
<title>Insert title here</title>
</head>
<body style="padding: 0; margin: 0; height: 2px;">
<nav class="navbar navbar-expand-sm" style=" background-color:rgba(255, 99, 71,0.5);">
	<div class="container-fluid">
	 <div class="navbar-header">
		<a class="navbar-brand" href="#"><strong style="color:rgb(106, 150,150);font-size:40px;">X-WORKZ CM</strong></a>
	</div>
	 <ul class="nav navbar-nav navbar-right">
        <li><a href="Login.jsp"><button type="button" class="btn btn-outline-primary">Login</button></a>
            <a href="index.jsp"><button type="button" class="btn btn-outline-primary">Home</button></a>
         </li>
      </ul>
	</div>
</nav>
	
<div style="color: black;">
<h3 style="text-align: center; font: bold;">Registration Form</h3><br>

<div>
<form action="register.do" method="post">
	<div class="container-fluidmt-5">
		<div style="height: 485px">
		
		<div class="col-sm-4">
			<b><label class="col-sm-4 col-form-label" for="UserId">UserId:</label></b>
			<input type="text" class="form-control" placeholder="UserId" name="userId">
		</div>

		<div class="col-sm-4">
			<b> <label class="col-sm-4 col-form-label for="email">EmailAddress:</label></b>
			<input type="email" class="form-control" placeholder="email123@gmail.com" name="email">
		</div>
		
		<div class="col-sm-4">
			<b><label class="col-sm-4 col-form-label for="phoneNumber">PhoneNumber:</label></b>
			<input type="text" class="form-control" placeholder="PhoneNumber" name="phoneNo">
		</div>

		<div>
			<label class="col-sm-4 col-form-label"><b>CourseInterested:</b></label>
			<div class="col-sm-4">
			<select name="course" class="form-control">
				<option selected>--Interested Course--</option>
				<option>Development</option>
				<option>QA</option>
			</select>
			</div><br>
		</div>
		
		<div class="col-sm-4">
		<div class="custom-control custom-radio custom-control-inline">
			<input type="radio" class="custom-control-input" id="customRadio" name="agree" value="Agree"> 
			<label class="custom-control-label" for="customRadio">Agree </label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
			<input type="radio" class="custom-control-input" id="customRadio2" name="agree" value="Dis-Agree"> 
			<label class="custom-control-label" for="customRadio2">Dis-Agree</label>
		</div>
		</div><br>
							
		<div style="padding: 7px; padding-top: 2px;">
			<button type="submit" class="btn btn-outline-primary">Register</button>
		</div>
		
		<h4 align="center">${existingUser}</h4>
		<h4 align="center">${existingEmail}</h4>
		<h4 align="center">${UserID}</h4>			
		<h4 align="center">${Password}</h4>
		<h4 align="center">${msgForDisAgree}</h4>
		
		</div>
	</div>
</form>

</div></div>
		<div class="footer-copyright py-3 text-center">
	<div class="footer-bottom-text" style="color:black">
			© 2020 Copyright: <a href="#"> <strong style="color:rgb(106, 150,150);">X-WORKZ.com </strong></a>
	</div>
	</div>
</body>
</html>