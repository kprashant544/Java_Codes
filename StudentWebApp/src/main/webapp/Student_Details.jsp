<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<script type="text/javascript">
function confirmDelete(studentName) {
    return confirm("Are you sure you want to delete " + studentName + "?");
}
</script>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
button.btn {
  padding: 8px 12px;
  border: none;
  cursor: pointer;
}
button.btn-success {
  background-color: green;
  color: white;
}
button.btn-danger {
  background-color: red;
  color: white;
}
</style>
</head>
<body>

<h1>Student Details Here</h1>

<a href="StudentForm.jsp"><button>Add New Student</button></a>

<c:if test="${!empty stdList}">
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
           <a href="Controller?action=edit&id=${student.id}">
               <button type="button" class="btn btn-success">Edit</button>
           </a>
           <a href="Controller?action=delete&id=${student.id}" 
              onclick="return confirmDelete('${student.firstname}')">
               <button type="button" class="btn btn-danger">Delete</button>
           </a>
        </td>
    </tr>
    </c:forEach>
</table>
</c:if>

</body>
</html>
