<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  if(session.getAttribute("log")== null){
	  response.sendRedirect("index.jsp");
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 로그인 </h1>
<form action="03_22loginPro.jsp">
<table border="1">
		<tr><td> ID </td><td><input type="text" name="id"></td></tr>
		<tr><td> PW </td><td><input type="text" name="pw"></td></tr>
		<tr><td colspan = "2" align="center" id="submit"><input type="submit" value="로그인"></td></tr>
	</table>
<!-- 	<button onclick="location.href='02_main.jsp'"> 홈으로이동</button> -->
	<input type="button" value="메인으로" id="btn" onclick="location.href='02_main.jsp'" />
	
</form>

</body>
</html>