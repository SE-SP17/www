<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<link href="./css/registerStyle.css" rel="stylesheet" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="./js/switch.js"></script>
		
		
	</head>

	<body>
		
		
		<h1>Set Game Registration</h1>
		<div id="registerForm" class="form">
		
			<p id="message">${message}</p>
			<c:remove var="message" scope="session" /> 
			
			<form action="RegistrationServlet" method="post">
				
				<input type="text" name="name" placeholder="your name"/>
				
				<input type="text" name="username" placeholder="username"/>	
				
				<input type="password" name="password" placeholder="password"/>
				
				<input type="submit" value="Sign me up!">			
			</form>
			<p>Have an account? <div class="switch">Click here</div> to login.</p>
		</div>
		
		<div id="loginForm" class="form">
			<!--<c:if test="${page=='login'}">
				<script>
					//$("#registerForm").hide();
					//$("#loginForm").show();	
					//document.getElementById("registerForm").style.display = "none";
					//document.getElementById("loginForm").style.display = "block";
					
					console.log("login failed");
					$(document).ready( $(".form").toggle() );
				</script>
			</c:if>  -->
			<p>${message}</p>
			<c:remove var="message" scope="session" /> 
			
			<form action="LoginServlet" method="post">
								
				<input type="text" name="username" placeholder="username"/>	
				
				<input type="password" name="password" placeholder="password"/>
				
				<input type="submit" value="Login">		
				<p>Need an account? <div class="switch">Click here</div> to register.</p>	
			</form>
		</div>
		
		
		
		
	</body>
</html>