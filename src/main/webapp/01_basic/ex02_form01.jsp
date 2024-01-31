<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		[1] form 태그
			(1) submit 버튼과 함께 쓰여 입력받은 데이터를 다음 페이지로 전달한다.
			(2) 속성
				1) action="내용을 처리할 페이지명"
				2) method="get" 또는 "post"
					. 데이터 전달 방식으로 get방식이 기본 속성
					. get방식은 데이터가 주소로 노출되어 보안에 취약하고 데이터 용량에 제한이 있다.
					. post방식은 데이터가 주소로 노출되지 않아 보안에 강하고 대용량 데이터 전달이 가능하다.
		
		[2] input 태그
			(1) 자바의 Scanner처럼 내용을 입력할 수 있는 태그이다.
			(2) 속성
				1-1) type="text"
					내용을 입력할 수 있다.
				1-2) name="age"
					자바의 변수를 생각하면 쉽다.
					age변수에 input에 입력된 내용을 저장한다.
				
				2-1) type="submit"
					버튼을 누르면 form의 action속성에 입력한 페이지로 이동한다.
				2-2) value="입력완료"
					버튼의 이름을 지정한다.
	 --%>
	 
	 <form action="ex03_form02.jsp" method="post">
	 이름 : <input type="text" name="name" /> <br>
	  나이 : <input type="number" name="age" /> <br>
	  <button> 전송 </button>
	 </form>

</body>
</html>