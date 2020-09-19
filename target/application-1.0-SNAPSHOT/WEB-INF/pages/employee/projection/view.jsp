<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>

    <div class="container-fluid" style="color: black">
        <form:form action="${pageContext.request.contextPath}/projection/${projection.projectionID}/update" method="post" modelAttribute="projection">
            <div class="row" >

                <div class="col col-lg-3"></div>
                <div class="col col-lg-3">

                    <div>Projection of movie</div>
                    <div><form:select  path="movieID.movieid">
                            <c:forEach
                                items="${allmovies}"
                                var="m"
                                varStatus="loop">
                                <div><form:option  value="${m.movieid}" label="${m.title}"/> </div>

                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="text-danger">
                        <form:errors path="movieID" cssClass="error" />
                    </div>


                    <div> Date:</div>
                    <div><form:input type="date" id="date" path="date" /></div>
                    <div class="text-danger">
                        <form:errors path="date" cssClass="error" />
                    </div>

                    <div> Time:</div>
                    <div><form:input type="time" id="time" path="time" /></div>
                    <div class="text-danger">
                        <form:errors path="time" cssClass="error" />
                    </div>
                    <div> Screen:</div>
                    <div><form:input type="text" id="screen" path="screen"  /></div>
                    <div class="text-danger">
                        <form:errors path="screen" cssClass="error" />
                    </div>
                    <p/>
                    <div><button id="update">Update</button> </div>
                   </div>
                    <div class="col col-lg-1">
                    <p/>
                </div>
                <div class="col col-lg-4">

                    <div>Image</div>
                    <img width="200" src="<c:url value="/image/"/>${projection.movieID.imageURL}"/>   


                </div>

            </form:form>
        </div>
