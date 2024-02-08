<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file= "../../header.jsp" %>
<h1 class="py-3"> 로그인 </h1>

<form action="${ctx}/memberLogin.do" method="post">
<table class="table table-bordered">
  <tr>
    <td>아이디</td>
    <td><input class="col-12" type="text" name="id" id="id"/></td>
  </tr>
  <tr>
    <td>패스워드</td>
    <td><input class="col-12" type="password" name="pw" id="pw"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="button" value="로그인" class="col-3 btn btn-primary" id="login" onclick="LoginCheck(form)"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>
<script type="text/javascript">
	function LoginCheck(form){
		if(!form.id.value.trim()){
			alert("아이디를 입력해주세요");
			form.id.focus();
		}
		if(!form.pw.value.trim()){
			alert("비밀번호를 입력해주세요");
			form.pw.focus();
		}
		form.submit();
	}
	document.getElementById("login").addEventListener("click", () => {
		let id = document.getElementById("id").value.trim();
		let pw = document.getElementById("pw").value.trim();
		
		if(id.length === 0){
			alert("id 값을 입력해주세요")
			document.getElementById("id").focus();
			return;
		}
		else if(pw.length === 0){
			alert("pw 값을 입력해주세요")
			document.getElementById("pw").focus();
			return;
		}
		fetch("memberLogin.do", {
			method: "POST",
		    headers: {
		      "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
		    },
		    body: "id=" + id, "pw=" + pw
		})
		.then(response => response.text())
		.then
	})
</script>