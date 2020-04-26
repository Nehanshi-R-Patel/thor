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
<body>
   <nav class="navbar navbar-expand-sm" style=" background-color:rgba(255, 99, 71,0.5);">
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
		<h3 style="text-align: center;"><i>${BlockLogin}</i></h3>
		
	<!-- footer -->
	<div class="footer-copyright py-3 text-center">
	<div class="footer-bottom-text" style="color:black">
			© 2020 Copyright: <a href="#"> <strong style="color:rgb(106, 150,150);">X-WORKZ.com </strong></a>
	</div>
	</div>
</body>
</html>