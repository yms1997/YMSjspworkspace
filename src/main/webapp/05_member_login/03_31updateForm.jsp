<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  if(session.getAttribute("log")== null ){
	  System.out.println("test");
	  response.sendRedirect("index.jsp");
	  return;
  }
int index = (int)session.getAttribute("log");
if(index == -1){
	  response.sendRedirect("index.jsp");
	  return;
}

ArrayList<String> idlist = (ArrayList<String>)session.getAttribute("idList");
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("nameList");
ArrayList<String> genderlist = (ArrayList<String>)session.getAttribute("genderList");
String gender = genderlist.get(index);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원수정  </h1>
	<form action="03_32updatePro.jsp" method="post">
	<table border="1">
		<tr><td>아이디</td><td><input type="text" name="id" value="<%=idlist.get(index)%>" readonly></td></tr>
		<tr><td>패스워드</td><td><input type="password" name="pw" required></td></tr>
		<tr><td>이름</td><td><input type="text" name="name" value="<%=namelist.get(index)%>" ></td></tr>
		<tr><td>성별</td>
			<td>
			<input type="radio" name="gender" value="남성" <%if(gender.equals("남성")){ %> checked <%} %>/>남성&nbsp;
			<input type="radio" name="gender" value="여성" <%if(gender.equals("여성")){ %> checked <%} %>>여성&nbsp;
			</td>
		</tr>
		<tr><td colspan = "2" align="center" id="submit"><input type="submit" value="정보수정"></td></tr>
	</table>
	</form>
	<input type="button" value="메인으로" id="btn" onclick="location.href='02_main.jsp'" />


</body>
</html>