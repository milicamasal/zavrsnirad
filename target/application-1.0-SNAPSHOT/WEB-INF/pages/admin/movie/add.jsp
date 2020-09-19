<%-- 
    Document   : add
    Created on : Aug 18, 2020, 1:10:28 PM
    Author     : Milica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>

    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>
    <div class="container-fluid" style="color: black" >
        <form:form action="${pageContext.request.contextPath}/movie/save?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="movie" enctype="multipart/form-data">
            <div class="row" >
                <div class="col col-lg-3"></div>

                <div class="col col-lg-3">

                    <div>Upload a banner</div>
                    <input path="images" type="file" name="images" accept="image/x-png,image/gif,image/jpeg" />
                    <div>Title:</div>
                    <div><form:input type="text" id="title" path="title"/></div>
                    <div class="text-danger">
                        <form:errors path="title" cssClass="error" />
                    </div>
                    <div> Genres :</div>
                    <c:forEach
                        items="${Allgenres}"
                        var="g"
                        varStatus="loop">
                        <div><form:checkbox  id="genres" path="genres" value="${g.name}"/> ${g.name}</div>

                    </c:forEach>
                    <div class="text-danger">
                        <form:errors path="genres" cssClass="error" />
                    </div>
                </div>                <div class="col col-lg-6">

                    <div> Released date:</div>
                    <div><form:input type="date" id="releasedDate" path="releasedDate" /></div>
                    <div class="text-danger">
                        <form:errors path="releasedDate" cssClass="error" />
                    </div>

                    <div> Duration:</div>
                    <div><form:input type="number" id="duration" path="duration" /></div>
                    <div class="text-danger">
                        <form:errors path="duration" cssClass="error" />
                    </div>
                    <div> Director:</div>
                    <div><form:input type="text" id="director" path="director" /></div>
                    <div class="text-danger">
                        <form:errors path="director" cssClass="error" />
                    </div> 
                    <div> Writer:</div>
                    <div><form:input type="text" id="writer" path="writer" /></div>
                    <div class="text-danger">
                        <form:errors path="writer" cssClass="error" />
                    </div>
                    <div> Synopsis:</div>
                    <div><form:textarea type="text" rows="12" cols="50" id="synopsis" path="synopsis" /></div>
                    <div class="text-danger">
                        <form:errors path="synopsis" cssClass="error" />
                    </div>
                    
                    <p/>
                    <div><button id="save">Save</button> </div>
                    <p/></div> 
            </div>
        </form:form>




        </div>
    </div>

</div>