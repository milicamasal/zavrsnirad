<%-- 
    Document   : access-denied
    Created on : Aug 13, 2020, 2:56:43 PM
    Author     : Milica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access denied</title>
    </head>
    <body>
        <h1><img width="200" src="<c:url value="/image/"/>denied.jpg"/>   
 Access Denied - you are not authorized to access this page!
</h1>
        <br>
        <a href="${pageContext.request.contextPath}/" > <h4><u><- Back to your home page </u></h4></a>

    
    </body>
</html>
