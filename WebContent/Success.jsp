<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Servlet.UserBean"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>
      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=ISO-8859-1">
         <title>   User Created Successfully   </title>
         <link href="./css/registerStyle.css" rel="stylesheet" type="text/css">
      </head>
	
      <body>

         <h1>
            <% 
            UserBean currentUser = ((UserBean) (session.getAttribute("currentSessionUser")));%>
			
            Welcome <%= currentUser.getUsername() %>
        </h1>

      </body>
	
   </html>