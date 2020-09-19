<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>

    <div class="container-fluid" style="color: black">
        <form:form action="${pageContext.request.contextPath}/movie/${movie.movieid}/delete" method="post" modelAttribute="movie">
            <div class="row">
                <div class="col col-lg-2"></div>
                <div class="col col-lg-3">

                    <div>Movie title</div>
                    <div><form:input type="text" id="title" path="title" readonly="true"/></div>
                    <div class="text-danger">
                        <form:errors path="title" cssClass="error" />
                    </div>

                    <div> Released date:</div>
                    <div><form:input type="date" id="releasedDate" path="releasedDate" readonly="true"/></div>
                    <div class="text-danger">
                        <form:errors path="releasedDate" cssClass="error" />
                    </div>

                    <div> Director:</div>
                    <div><form:input type="text" id="director" path="director" readonly="true"/></div>
                    <div class="text-danger">
                        <form:errors path="director" cssClass="error" />
                    </div> 
                    <br>
                    <div><button>Delete</button> </div>

                </div> 

                <div class="col col-lg-3">

                    <div> Duration:</div>
                    <div><form:input type="number" id="duration" path="duration" readonly="true"/></div>
                    <div class="text-danger">
                        <form:errors path="duration" cssClass="error" />
                    </div>

                    <div> Writer:</div>
                    <div><form:input type="text" id="writer" path="writer" readonly="true"/></div>
                    <div class="text-danger">
                        <form:errors path="writer" cssClass="error" />
                    </div>
                    <div> Genres :</div>
                    <c:forEach
                        items="${genres}"
                        var="g"
                        varStatus="loop">
                        <div><form:label  id="genres" path="genres" value="${g.name}"/> - ${g.name}</div>

                    </c:forEach>
                    <div> Synopsis:</div>
                    <div><form:textarea type="text" id="synopsis" rows="12" cols="45"  path="synopsis" readonly="true" /></div>
                    <div class="text-danger">
                        <form:errors path="synopsis" cssClass="error" />
                    </div>

                </div> 
                <div class="col col-lg-3">

                    <div>Movie banner:</div>
                    <img width="200" src="<c:url value="/image/"/>${movie.imageURL}"/>

                </div>

                <p/></div>
            </form:form>
    </div>

</div>