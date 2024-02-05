<%@ page import="board.BoardDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%
    if(session.getAttribute("dao") == null){
      session.setAttribute("dao", new BoardDAO());
    }
    response.sendRedirect("_00_main.jsp");
%>