<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("dao") == null){
        response.sendRedirect("index.jsp");
        return;
    }
    BoardDAO dao = (BoardDAO)session.getAttribute("dao");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>게시글 추가하기</h1>
<form method="post" action="_04_addBoardPro.jsp">
    <table border="1">
        <tr>
            <th>번호</th>
            <td><%= dao.getTotalData() + 1 %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" required></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" name="subject" required></td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea rows="10" cols="20" name="contents" required></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="작성완료">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
