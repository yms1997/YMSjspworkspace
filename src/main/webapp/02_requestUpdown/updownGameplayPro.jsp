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
   int com = Integer.parseInt(request.getParameter("com"));
    int me = Integer.parseInt(request.getParameter("me"));
    String msg ="";
    if(me > com){
    	msg="DOWN";
    }else if(me < com){
    	msg ="UP";
    }else{
    	msg="BINGO";
    }

%>

<h1> <%= msg %></h1>

<%
if(me == com){
%>
	<a href="index.jsp"> 처음으로 </a>
	
<% }else{%>
   <a href="updownGameplay.jsp?com=<%=com%>"> 뒤로가기 </a>
   <button onclick="goUrl(<%=com%>)"> 뒤로가기 </button>
<%} %>
</body>
</html>

<script type="text/javascript">
	function goUrl(com) {
		location.href="updownGameplay.jsp?com="+ com;
	}
</script>