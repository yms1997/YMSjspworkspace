<%@page import="gugudon.GugudanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

if(session.getAttribute("dao")== null){
	response.sendRedirect("index.jsp");
	return;
}
GugudanDAO dao = (GugudanDAO)session.getAttribute("dao");
  
 String answer = request.getParameter("answer");
 boolean check = dao.checkAnswer(answer);
 

 
 if(check){
	
	 
	 %>
	 <script>
	   alert("정답입니다");
	   location.href="gugudan.jsp";
	   //history.go(-1);
	   //history.back();
	 </script>
	 <%
	 
 }else{
	 %>
	 <script>
	   alert("오답입니다");
	   location.href="gugudan.jsp";
	  // history.back();
	 </script>
	 <%	 
	 
 }

%>