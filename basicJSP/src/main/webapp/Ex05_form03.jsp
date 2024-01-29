<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = 0;
		int num2 = 0;
		int hap = 0;
		String err = "";
		try{
			num1 = Integer.parseInt(request.getParameter("num1"));
			num2 = Integer.parseInt(request.getParameter("num2"));
			hap = num1 + num2;
		}
		catch(Exception e){
			err += "숫자가 아닌값이 있어서 덧셈불가";
		}
		
	%>
	<h1> <%= err %></h1>
	<h1> num1 : <%= num1 %></h1>
	<h1> num2 : <%= num2 %></h1>
	<h1> hap : <%= hap %></h1>
</body>
</html>