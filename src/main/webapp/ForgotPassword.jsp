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
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
.form-box {
	width:500px;
	background:rgba(0,0,0,0.8);
	margin:7% auto;
	padding:50px 0;
	color:#fff;
	box-shadow: 0 0 20px 2px rgba(0,0,0,0.5);	
}
.footer-bottom-text {
	position: fixed;
 	 left: 0;
  	 bottom: 0;
 	 width: 100%;
	 background-color:rgba(255, 99, 71,0.5);
 	 color: white;
 	 text-align: center;
} h1 {
	text-align:center;
	margin-bottom:40px;
} .input-box {
	margin: 31px auto;
	width:80%;
	border-bottom:1px solid #fff;
	padding-top:10px;
	padding-bottom:5px;
} .input-box input {
	width:90%;
	border:none;
	outline:none;
	background:transparent;
	color:#fff;
} ::placeholder{
	color:#ccc;
} .fa {
	margin-right:10px;
} .login-btn {
	margin:40px auto 20px;
	width:80%;
	display:block;
	outline:none;
	padding:10px 0;
	border:1px solid #fff;
	cursor:pointer;
	background:transparent;
	color:#fff;
	font-size:16px	
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
        <a href="index.jsp"><button type="button" class="btn btn-outline-primary">Home</button></a></li>
     </ul>
	</div>
</nav>
<form action="forgotPsw.do" method="post">
<div class="form-box">
	<h1>Forgot Password</h1>	
	<div class="input-box">
		<i class="fa fa-envelope-o"></i>
		<input type="text" name="email" placeholder="Email Id">
	</div>
	<button type="submit" class="login-btn">Reset</button>
	<h3 style="text-align:center">${NewPassword}</h3>
</div>
</form>
<div class="footer-copyright py-3 text-center">
<div class="footer-bottom-text" style="color:black">
	© 2020 Copyright: <a href="#"> <strong style="color:rgb(106, 150,150);">X-WORKZ.com </strong></a>
</div>
</div>
</body>
</html>