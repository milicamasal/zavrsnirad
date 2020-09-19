<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
    body {
        background: no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        background-image: url('<c:url value="/image/wallpaper.jpg"/>')  ;
      
    }
</style>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="ISO-8859-1">
        <title>
            <tiles:getAsString name="title"></tiles:getAsString>
            </title>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
        <link rel='stylesheet' href='path/webjars/bootstrap-table/1.16.0/dist/bootstrap-table.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/font-awesome/5.6.3/css/all.min.css'>
        <link href='${pageContext.request.contextPath}/resources/css/styles.css' rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.css"/>
    </head>
    <body>
        <header id ="header">
            <tiles:insertAttribute name="header"/>
        </header>
        <section id="sidemenu">
            <tiles:insertAttribute name="menu"/>
        </section>
        <section id="site-content">
            <tiles:insertAttribute name="body"/>
        </section>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/popper.js/1.16.0/umd/popper.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="dolar{pageContext.request.contextPath}/webjars/bootstrap-table/1.16.0/dist/bootstrap-table.min.js"></script>

        <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.js"></script>


    </body>
</html>