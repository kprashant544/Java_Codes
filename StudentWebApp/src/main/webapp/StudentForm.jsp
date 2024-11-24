<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background: #f9f9f9;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="hidden"], button {
            width: 96%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button {
            background: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

<h1>${studentKey.id != null ? "Edit Student" : "Student Registration Form"}</h1>

<form action="StudentController" method="post">
    <input type="hidden" name="id" value="${studentKey.id != null ? studentKey.id : ''}" />

    <label for="firstname">First Name:</label>
    <input type="text" id="firstname" name="firstname" value="${studentKey.firstname != null ? studentKey.firstname : ''}" required />

    <label for="lastname">Last Name:</label>
    <input type="text" id="lastname" name="lastname" value="${studentKey.lastname != null ? studentKey.lastname : ''}" required />

    <label for="gender">Gender:</label>
    <input type="radio" id="male" name="gender" value="Male" ${studentKey.gender == 'Male' ? 'checked' : ''} /> Male
    <input type="radio" id="female" name="gender" value="Female" ${studentKey.gender == 'Female' ? 'checked' : ''} /> Female

    <label for="course">Course:</label>
    <input type="checkbox" name="course" value="Java" ${fn:contains(studentKey.course, 'Java') ? 'checked' : ''} /> Java
    <input type="checkbox" name="course" value="PHP" ${fn:contains(studentKey.course, 'PHP') ? 'checked' : ''} /> PHP
    <input type="checkbox" name="course" value="Python" ${fn:contains(studentKey.course, 'Python') ? 'checked' : ''} /> Python

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${studentKey.address != null ? studentKey.address : ''}" />

    <label for="contact">Contact:</label>
    <input type="text" id="contact" name="contact" value="${studentKey.contact != null ? studentKey.contact : ''}" required />

    <button type="submit">${studentKey.id != null ? "Update Student" : "Submit"}</button>
</form>

</body>
</html>
