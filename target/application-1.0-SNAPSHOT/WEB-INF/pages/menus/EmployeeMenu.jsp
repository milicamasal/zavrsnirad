<%-- 
    Document   : EmployeeMenu
    Created on : Aug 18, 2020, 1:04:23 PM
    Author     : Milica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="<c:url value = "/"/>">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  <ul class="navbar-nav mr-auto">
     
     <li class="nav-item">
        <a class="nav-link" href="<c:url value = "/projection/add"/>">Add Projection</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="<c:url value = "/projection/all"/>">All Projections</a>
      </li>
      
    </ul>
  </div>
</nav>
