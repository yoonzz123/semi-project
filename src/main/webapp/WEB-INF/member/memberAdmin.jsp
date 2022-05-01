<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" href="css/memberAdmin.css" rel="stylesheet"/>
<article>
	<h3 class="title">회원 관리 페이지</h3>
	<div class="mem-Table">
		<div class="mem-Tr">
			<div class="mem-Td-id "> ID </div>
			<div class="mem-Td-name"> 이름 </div>
			<div class="mem-Td-phone"> 전화번호 </div>
			<div class="mem-Td-email"> 이메일 </div>
			<div class="mem-Td-regdate"> 가입일 </div>
			<div class="mem-Td-delete"> 관리 </div>
		</div>
		<c:forEach var="m" items="${ mList }">
		<div class="mem-Tr">
			<div class="mem-Td-id "> ${ m.mId } </div>
			<div class="mem-Td-name"> ${ m.mName } </div>
			<div class="mem-Td-phone"> ${ m.mPhone } </div>
			<div class="mem-Td-email"> ${ m.mEmail } </div>
			<div class="mem-Td-regdate">
				<fmt:formatDate value="${ m.mRDate }" type="date" dateStyle="short" />
			 </div>
			<div class="mem-Td-delete">
				<a href="mAdminDelete.mvc?mId=${ m.mId }" style="color:red;">
						<img src="images/cross.png" />
					</a>
			</div>
		</div>
	</c:forEach>
	</div>
	
</article>