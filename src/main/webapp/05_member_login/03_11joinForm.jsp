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
<h1> 회원가입 </h1>
<form method="post" action="03_12joinPro.jsp">

    Name : <input type="text" name="name" /> <br><br>
    I  D : <input type="text" name="id" /> <br><br>
    P  W : <input type="text" name="pw" /> <br><br>
    Gender : <input type="radio" name="gender" value="남성" checked/>남성&nbsp;
    <input type="radio" name="gender" value="여성"/>여성<br><br>
    <input type="submit" value="회원가입" />
</form>
<br>

<button onclick="location.href='index.jsp'"> 홈으로 </button>
</body>
</html>