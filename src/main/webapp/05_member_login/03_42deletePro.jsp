<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="commom.js"></script>
<% 
  if(session.getAttribute("log")== null){
	  response.sendRedirect("index.jsp");
	  return;
  }

int idx = (int)session.getAttribute("log");
String pw = request.getParameter("pw");

ArrayList<String> pwlist = (ArrayList<String>)session.getAttribute("pwList");
ArrayList<String> idlist = (ArrayList<String>)session.getAttribute("idList");
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("nameList");
ArrayList<String> genderlist = (ArrayList<String>)session.getAttribute("genderList");

if(pw.equals(pwlist.get(idx))){

pwlist.remove(idx);
idlist.remove(idx);
namelist.remove(idx);
genderlist.remove(idx);

session.setAttribute("log", -1);

%>
<script>
msgGoMain("회원 탈퇴 완료 ");
</script>

<%
}else{
	%>
	<script>
	msgUrl("비밀번호를 다시입력해주세요" ,"03_41deleteForm.jsp" );
	</script>
	<%
}
%>