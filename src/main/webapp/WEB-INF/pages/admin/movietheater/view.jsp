<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>



    <div class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/movietheater/${movieTheater.movieTheaterID}/update" method="post" modelAttribute="movieTheater">

            <div class="row" >

                <div class="col col-lg-3"></div>
                <div class="col col-lg-4">

                    <div>Name:</div>

                    <div><form:input type="text" id="name" path="name" size="50"  /></div>
                    <div class="text-danger">
                        <form:errors path="name" cssClass="error" />
                    </div>

                    <div> Adress:</div>
                    <div><form:input type="text" id="adress" path="adress" size="50" /></div>
                    <div class="text-danger">
                        <form:errors path="adress" cssClass="error" />
                    </div>
                    <p/>

                    <p/>
                    <button id="update">Update</button>
                     </form:form>            </div>            

                                    <div class="col col-lg-3">
                                        <br>
                        <form action="${pageContext.request.contextPath}/movietheater/${movieTheater.movieTheaterID}/delete">     
                            <input type="submit" value="Delete" />
                        </form> 
                    <p/>
            </div>            

        </div>

    </div>