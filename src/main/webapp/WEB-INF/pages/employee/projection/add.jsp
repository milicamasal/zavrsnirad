<%-- 
    Document   : add
    Created on : Aug 18, 2020, 1:10:28 PM
    Author     : Milica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>

    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>
    <div class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/projection/save" method="post" modelAttribute="projection">
            <div class="row" >

                <div class="col col-lg-4"></div>
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



                    <div class="text-danger">
                        <form:errors path="theater" cssClass="error" />
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
                    <div><form:input type="text" id="screen" path="screen" /></div>
                    <div class="text-danger">
                        <form:errors path="screen" cssClass="error" />
                    </div>
                    <p/>
                    <div><button id="save">Save</button> </div>
                    <p/>                    </div>

            </div></div>
        </form:form>
</div>

</div>