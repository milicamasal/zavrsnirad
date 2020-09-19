<%-- 
    Document   : home
    Created on : Aug 13, 2020, 1:51:09 PM
    Author     : Milica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .zoom {
        transition: transform .2s;  
    }

    .zoom:hover {
        transform: scale(1.1); 
    }

</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>

    <security:authorize access="hasRole('ADMIN')">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="<c:url value = "/"/>">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value = "/movie/add"/>">Movie add</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value = "/movie/all"/>">Movie all</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value = "/movietheater/add"/>">Movie Theater add</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value = "/movietheater/all"/>">Movie Theater all</a>
                    </li>

                </ul>
            </div>
        </nav>
        <div class="row">
            <br>
            <div class="col col-lg-11"></div>
            <form:form action="${pageContext.request.contextPath}/logout" method="POST">

                <input type="submit" value="Logout"/>    

            </form:form>
        </div>
        <div class="row">

            <c:forEach
                items="${allmovies}"
                var="m"
                varStatus="loop">

                <div class="col col-lg-2">
                    <div><h3>${m.title} </h3>
                    </div>
                    <a href="<c:url value = "/movie/${m.movieid}/view/">

                        </c:url>">

                        <img class="zoom" width="200" src="<c:url value="/image/"/>${m.imageURL}"/>
                    </a>

                </div>
            </c:forEach>
        </div>

    </security:authorize>
    <security:authorize access="hasRole('EMPLOYEE')">


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
        </nav> <div class="row">
            <br>

            <div class="col col-lg-11"></div>
            <form:form action="${pageContext.request.contextPath}/logout" method="POST">

                <input type="submit" value="Logout"/>    

            </form:form>
        </div>

        <div class="row">

            <c:forEach
                items="${allmovies}"
                var="m"
                varStatus="loop">

                <div class="col col-lg-3">
                    <div><h3>${m.title} </h3>
                    </div>

                    <div><img class="zoom" width="200" src="<c:url value="/image/"/>${m.imageURL}"/> </div>
                    <h5>Dates of projections:</h5> 
                    <c:forEach
                        items="${allprojections}"
                        var="p"
                        varStatus="loop">
                        <c:if test="${p.movieID.movieid==m.movieid}">
                            ${p.date} ${p.time} 
                            <a  href="<c:url value = "/projection/${p.projectionID}/view/">
                                </c:url>">
                                Show more --> 
                            </a>
                            <br>

                        </c:if>


                        <a>
                        </a>

                    </c:forEach>
                    </a>

                </div>                

            </c:forEach>
        </div></div>


</security:authorize>


</p>


</html>
