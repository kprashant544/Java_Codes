<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP and Servlet</title>
</head>
<body>

<h2>Student Form</h2>

     
      <form action = "StudentController" method="post">
      <label>
        First name:</label> <input type = "text" name = "firstname" placeholder="Enter your firstname">
         <br> <br>
         
         <label>Last name: </label>
         <input type = "text" name = "lastname" placeholder="Enter your lastname" />
            <br> <br>
         <label>Gender: </label>
         <input type="radio" name="gender" value="male"/>Male
    	 <input type="radio" name="gender" value="female"/>Female
            <br> <br>
            
         <label>Course:</label>
    	<input type="checkbox" name="course" value="java"/>Java
    	<input type="checkbox" name="course" value="php"/>PHP
    	<input type="checkbox" name="course" value="python"/>Python
    	
    	     <br> <br>
    	
            
         <label>Address: </label>
          <input type = "text" name = "address" placeholder="Enter your address" />
         
            <br> <br>
         <label>Contact: </label>
             <input type = "text" name = "contact" placeholder="Enter your contact number" />
         
              <br> <br>
             <input type = "submit" value="submit"> 
     
      </form>


</body>
</html>