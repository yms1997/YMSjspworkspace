<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<%
    if(session.getAttribute("dao") == null){
      response.sendRedirect("index.jsp");
      return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>게시판</h1>

<h3><a href="_01_boardList.jsp">전체 게시글 확인하기</a></h3>
<h3><a href="_02_addDummyPro.jsp">더미 게시글 추가하기</a></h3>
<h3><a href="_03_deleteAllBoard.jsp">전체 게시글 삭제하기</a></h3>
<h3><a href="_04_addBoard.jsp">게시글 추가하기</a></h3>

<hr>

<h3><a href="_07_boardListPaging.jsp">페이징 게시판</a></h3>
<h3><a href="_08_boardListPaging2.jsp">페이징 게시판2</a></h3>
</body>
</html>
