<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Simple Calculator</title>
</head>
<body>
<form action="" method="post">
<label for="firstNumber">First Number:</label>
<input type="text" name="firstNumber"><br><br>

<label for="secondNumber">Second Number:</label>
<input type="text" name="secondNumber"><br><br>

<button type="submit">Submit</button>
</form>
<%

String num1= request.getParameter("firstNumber");
String num2=request.getParameter("secondNumber");
int c=0;
if(num1!=null && num2!=null){
	int a=Integer.parseInt(num1);
	int b=Integer.parseInt(num2);
	 c=a+b;
	 %>
	 
	 <%= "Sum of two numbers is "+ c %>
	 
	 <% }
%>
</body>
</html>