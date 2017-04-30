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
         <title>   Welcome  </title>
         <link href="./css/registerStyle.css" rel="stylesheet" type="text/css">
      </head>
	
      <body>

         <h1>
            <c:if test="${currentSessionUser!=null}"> 
	           <%  UserBean currentUser = ((UserBean) (session.getAttribute("currentSessionUser")));%>
				
	            	Welcome <%= currentUser.getUsername() %>
            </c:if>
            <c:if test="${currentSessionUser==null}"> 
	           <p>Please <a href="/Registration">click here</a> to login or register first </p>
            </c:if>
        </h1>

      </body>
	
   </html>