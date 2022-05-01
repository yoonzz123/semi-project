<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" href="css/qnaDetail.css" rel="stylesheet"/>
<link type="text/css" href="css/css.css" rel="stylesheet"/>
<article class="qnaWriteArticle">
	<div class="qnaWriteFormWrap">
		<div class="qnaWriteFormWrap1">
	<h3 style="margin-top: 5%;">QnA 작성</h3>
	<form action="qnaInfo.mvc">
		<div class="qnaWriteTitle">
			<label><b>제목</b></label>&emsp;&emsp;
			<input type="text" id="qTitle" name="qTitle">
		</div>
		<div class="qnaWriteId">
			<label><b>글쓴이</b></label>&emsp;&nbsp;
			<span>${ sessionScope.id }</span>
		</div>
		<div>
			<label><b>문의 내용</b></label>
			<div>
				<textarea rows="10" cols="50" id="qContent" name="qContent"></textarea>			
			</div>
		</div>
		<div class="qnaWritebtn">
			<input type="submit" value="리뷰작성하기" id="btnQnAWrite">
			<input type="reset" value="다시쓰기">
		</div>
	</form>
		</div>
	</div>
</article>