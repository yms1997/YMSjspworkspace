<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

ArrayList<String> pwlist = (ArrayList<String>)session.getAttribute("pwList");
ArrayList<String> idlist = (ArrayList<String>)session.getAttribute("idList");
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("nameList");
ArrayList<String> genderlist = (ArrayList<String>)session.getAttribute("genderList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 회원 목록 </h1>

<table>
<tr>
  <th>아이디 </th>
  <th>패스워드 </th>
  <th>이름 </th>
  <th>성별 </th>
  <th> 삭제 </th>
</tr>

<% for(int i =0; i < idlist.size(); i++ ) {%>
<tr>
  <th> <%= idlist.get(i)%> </th>
  <th><%= pwlist.get(i)%> </th>
  <th><%= namelist.get(i)%> </th>
  <th><%= genderlist.get(i)%> </th>
  <th> <button onclick="location.href='01_12_adminUserDelete.jsp?idx=<%=i%>'" > 삭제 </button> </th>
</tr>
<% } %>

</table>


</body>
</html>