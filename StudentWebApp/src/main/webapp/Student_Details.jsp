<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}

button> .btn btn-danger{
	background-color:"red";
}
</style>
</head>
<body>


<h1>Student Details Here</h1>

<c:if test="${!empty stdList }">

<table>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Course</th>
        <th>Address</th>
        <th>Contact</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${stdList}" var="student">
    <tr>
        <td><c:out value="${student.id}"></c:out></td>
        <td><c:out value="${student.firstname}"></c:out></td>
        <td><c:out value="${student.lastname}"></c:out></td>
        <td><c:out value="${student.gender}"></c:out></td>
        <td><c:out value="${student.course}"></c:out></td>
        <td><c:out value="${student.address}"></c:out></td>
        <td><c:out value="${student.contact}"></c:out></td>
        <td>
           <button type="submit" class="btn btn-success">Edit</button>
    <form action="StudentController" method="GET" style="display:inline;"onsubmit="return confirm('Are you sure you want to delete this record?');">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${student.id}">
        <button type="submit" class="btn btn-danger">Delete</button>
    </form>

	</td>
    </tr>
    </c:forEach>

</table>


</c:if>



</body>
</html>