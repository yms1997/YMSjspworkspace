<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script>
function printMsg( url ,msg) {
	alert(msg);
	location.href=url;
}
</script>

  <%
  String inputId = request.getParameter("inputId");
  String inputPw = request.getParameter("inputPw");
  ArrayList<String> list = (ArrayList<String>)session.getAttribute("user");
  boolean pass = false;
  String dbId = list.get(0);
  String dbPw = list.get(1);
  if(dbId.equals(inputId) && dbPw.equals(inputPw)){
	  session.setAttribute("log", dbId);
	  pass = true;
  }
   %>

<% if(pass){ %>
<script>
printMsg( 'index.jsp' ,"로그인 성공");
</script>

<%}else{ %>
<script>
printMsg( 'login.jsp' ,"로그인 실패");
</script>
<%} %>


