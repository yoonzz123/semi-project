<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" href="css/qnaList.css" rel="stylesheet"/>
<link type="text/css" href="css/css.css" rel="stylesheet"/>
<script type="text/javascript" src="js/qna.js"></script>
<article>
	<div class="wrapper">
		<div class="sub_nav"></div>
		<div class="content">
			<h3 class="qnaMain">QnA</h3>
			<table class="qnaTable">
			<tr class="qnaTitle">
				<th>No</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>
			<c:if test="${sessionScope.isLogin }">
			<div class="qnaWrite">
			<a href="qnaWriteForm.mvc">작성하기</a>
			</div>
			</c:if>
			<c:if test="${ empty qnaList }">
				<tr>
					<td>게시글이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:if test="${ not empty qnaList }">
			<c:forEach var="b" items="${ qnaList }">
				<tr class="qnaList">
					<td class="qnaRepeatNo">${ b.qNo }</td>
					<td class='qnaRepeatTitle'><a href="qnaDetail.mvc?qNo=${ b.qNo }">${ b.qTitle }</a></td>
					<td class="qnaRepeatId">${ b.mId }</td>
					<td class="qnaRepeatRdate"><fmt:formatDate value="${b.qRDate }" pattern="yyyy-MM-dd" /></td>
				</tr>
				<c:if test="${ not empty b.qrTitle }">
				<tr>
					<td></td>
					<td colspan='4'><a href="qnaDetail.mvc?qNo=${ b.qNo }"> ${b.qrTitle }</a></td>
				</tr>
				</c:if>
			</c:forEach>
			</c:if>
			</table>
			
		</div>
	</div>
	<div class="footerMargin"> </div>
	<div class="hand"></div>
</article>