<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%
    String url = "jdbc:mysql://localhost:3306/데이터베이스이름?charaterEncoding=UTF-8&serverTimezone=UTC";
    String user = "root";
    String password = "1234";
    Connection conn = null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url, user, password);
      System.out.println(conn);
    }catch (SQLException e){
      e.printStackTrace();
      System.out.println("연동실패");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% if(conn != null) {%>
    <h1> 연동 성공 </h1>
    <%}else{ %>
    <h1> 연동 실패 </h1>
    <%} %>
</body>
</html>
