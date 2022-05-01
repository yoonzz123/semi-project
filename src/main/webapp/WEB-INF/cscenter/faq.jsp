<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" href="css/css.css" rel="stylesheet"/>
<article>
<div class="faqTitle">
	<h2 class="titlejaju">자주하는 질문</h2>
</div>
<div class="faqMainDiv">
	<c:forEach var="f" items="${ fList }">
		<div class="faqTitle1">
		<input type="checkbox" id="answer01">
		<label for="answer01">${ f.fTitle }</label>
		<p>제목 ${ f.fContent }</p>	
		</div>
		<div class="faqTime">
		<p>공지 등록일 : <fmt:formatDate value="${ f.fRDate }" pattern="yyyy-MM-dd" /></p>
		</div>
		<c:if test="${sessionScope.id eq 'admin'}"> 
			<div class="faqWriteDelete">
				<a href="fDelete.mvc?fNo=${ f.fNo }">삭제</a>
			</div>
		</c:if>	
	</c:forEach>	
	<c:if test="${sessionScope.id eq 'admin'}"> 
		
	</c:if>	
</div>	
<div class="faqWriteA">
		<a href="fWriteForm.mvc">
			글쓰기
		</a>
</div>
</article>