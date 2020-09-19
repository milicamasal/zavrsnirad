<%-- 
    Document   : all
    Created on : Aug 18, 2020, 1:10:44 PM
    Author     : Milica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#tabela').DataTable({
            "paging": false // false to disable pagination (or any other option)
            
        });
    });

</script>

<div >
    <form>
        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>
            <div  width="1550px" style="color: black;background-color: #d1ecf1">
                <table id="tabela" class="table table-hover table-bordered" width="1550px" style="background-color: whitesmoke" >
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Movie theater name</th>
                        <th scope="col">Movie theater adress</th>
                        <th scope="col">Delete</th>
                        <th scope="col">View</th>

                    </tr>
                </thead>
                <tbody>                       

                    <c:forEach
                        items="${movieTheaters}"
                        var="mt"
                        varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${mt.name}</td>
                            <td>${mt.adress}</td>
                            <td>

                                <a href="<c:url value = "/movietheater/${mt.movieTheaterID}/delete/">

                                    </c:url>">Delete</a>
                            </td>
                            <td>

                                <a  href="<c:url value = "/movietheater/${mt.movieTheaterID}/view/">

                                    </c:url>">View</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>