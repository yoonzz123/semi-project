<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${member1 == true }">
	<table>
		<tr>
			<td>비밀번호는 :${ member.mPw }  </td>
		</tr>
	</table>
	</c:when>
	<c:otherwise>
		<h1>이름또는 아이디가 잘못입력되었습니다</h1>
	</c:otherwise>
</c:choose>
</body>
</html>