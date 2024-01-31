<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script type="text/javascript" src="commom.js"></script>
<% 
  if(session.getAttribute("log")== null){
	  response.sendRedirect("index.jsp");
  }

  String name = request.getParameter("name");
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  String gender = request.getParameter("gender");

  ArrayList<String> pwlist = (ArrayList<String>)session.getAttribute("pwList");
  ArrayList<String> idlist = (ArrayList<String>)session.getAttribute("idList");
  ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("nameList");
  ArrayList<String> genderlist = (ArrayList<String>)session.getAttribute("genderList");

  pwlist.add(pw);
  idlist.add(id);
  namelist.add(name);
  genderlist.add(gender);
%>

<script>
    msgGoMain("회원 가입 완료 ");
</script>
