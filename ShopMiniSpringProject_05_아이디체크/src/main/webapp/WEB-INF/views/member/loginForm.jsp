<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 미리 만들긴 했지만 loginController에서 넘어온 mesg 받아서 출력해주는 코드. -->
<c:if test="${!empty mesg }">
	<script>
		alert('${mesg}');
	</script>
</c:if>

<form action="login" method="get">
아이디:<input type="text" name="userid"><br>
비밀번호:<input type="text" name="passwd"><br>
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>