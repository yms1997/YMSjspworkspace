<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 int grade = 4;

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>학번, 이름, 학년, 선택과목을 입력하는 폼</h2>
		    
	    <form method="post" action="ex10_from07Pro.jsp">
	    	<table border="1">
	    	<tr>
	    		<td>학번</td>
	    		<td><input type="number" name="num" value="test"></td>
	        </tr>
	        <tr>
	         	<td>이름</td>
	         	<td><input type="text" name="name"></td>
	        </tr>
	        <tr>
	        	<td>학년</td>
	        	<td>
		        	 <input type="radio" name="grade" value="1" <%if(grade == 1){%> checked  <%} %>>1학년&nbsp;
			         <input type="radio" name="grade" value="2" <%if(grade == 2){%> checked  <%} %>>2학년&nbsp;
			         <input type="radio" name="grade" value="3" <%if(grade == 3){%> checked  <%} %>>3학년&nbsp;
			         <input type="radio" name="grade" value="4" <%if(grade == 4){%> checked  <%} %>>4학년
	        	</td>
	        </tr>
	        <tr>
	        	<td> 선택과목</td>
	        	<td>
			        <select name="subject">
			             <option value="JAVA">JAVA</option>
			             <option value="JSP">JSP</option>
			             <option value="SPRING">SPRING</option>
			         </select>     	
	        	</td>
	        </tr>
	         <tr>
	        	<td>취미</td>
	        	<td>
		        	<input type="checkbox" name="hobbies" value="운동">운동
				   	<input type="checkbox" name="hobbies" value="독서">독서
				   	<input type="checkbox" name="hobbies" value="공부">공부  
				   	<input type="checkbox" name="hobbies" value="쇼핑">쇼핑        	
	        	</td>
	        </tr>
			<tr>
				<td>메모</td>
				<td><textarea rows="10" cols="50" name="memo">
				
				</textarea></td>
			</tr>
	         	<tr>
	         		<td colspan="2" align="center"><input type="submit" value="입력완료"></td>
	         	</tr>
	         </table>
	    </form>
	  </div>
</body>
</html>