<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="servlet.UserBean"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>
      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=ISO-8859-1">
         <title>   Welcome  </title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
         <link href="./css/registerStyle.css" rel="stylesheet" type="text/css">
         <script src="./js/switch.js"></script>
      </head>
	
      <body>

         <h1>
            <c:if test="${currentSessionUser!=null}"> 
	           <%  UserBean currentUser = ((UserBean) (session.getAttribute("currentSessionUser")));%>
				
            	<h1>Welcome <%= currentUser.getUsername() %> </h1>
            	<p>Total wins:  </p>
            	<p>Total losses:  </p>
            	
            	<p class="switch">Change password</p>
            	<div id="passwordForm" class="form">
	            	<form action="PasswordServlet" method="post">
		            	<input type="password" name="current" placeholder="old password"/>
						
						<input type="password" name="new1" placeholder="new password"/>	
						
						<input type="password" name="new2" placeholder="retype new password"/>
						
						<input type="submit" value="Change password">	
					</form>		
            	</div>
	            	
            </c:if>
            
            
            
            <c:if test="${currentSessionUser==null}"> 
	           <p>Please <a href="/Registration">click here</a> to login or register first </p>
            </c:if>
        </h1>

      </body>
	
   </html>