<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" href="css/noticeForm.css" rel="stylesheet"/>
<article class="body">
	<h3 class='sub_header'>공지사항 목록</h3>	
	<div class='content'>
		<c:if test="${sessionScope.id eq 'admin'}"> 
			<div class="admin_write"><a href="noticeWriteForm.mvc">글쓰기</a></div>
		</c:if>
		<div class="title">
			<div class="title_no">NO</div>
			<div class="title_content">SUBJECT</div>
			<div class="title_name">NAME</div>
		</div>
		<c:forEach var="n" items="${ nList }">
		<div class="list">
			<div class="list_no">${n.nNo }</div>
			<div class="list_content"><a href="noticeDetail.mvc?nNo=${n.nNo}">${n.nTitle }</a></div>
			<div class="list_date"><fmt:formatDate value="${n.nRdate }" pattern="yy-MM-dd" /></div>
		</div>
		</c:forEach>
	</div>	
</article>
