<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" href="css/qnaDetail.css" rel="stylesheet"/>
<link type="text/css" href="css/css.css" rel="stylesheet"/>
<article>
	<div class="wrapper">
		<div class="sub_nav"></div>
		<div class="content">
			<input type="hidden" id="btnqNo" data-no="${qna.qNo }" />
			<h3 style="margin-top:70px; ">QnA Detail</h3>
			<table class="qnaTable">
				<tr>
					<th class="qnaTitle">제목</th>
					<td>&emsp;&emsp;${qna.qTitle }</td>
				</tr>
				<tr>
					<th class="qnaContent">상세내용</th>
					<td>&emsp;&emsp;${qna.qContent }
				</tr>
				<tr><td>&nbsp;</td></tr>
			</table>
			<hr>
			&nbsp;
			<table id='replyTable'>				
				<c:if test="${sessionScope.id eq 'admin' }">
					<c:if test="${ not empty reply.qrContent }">
						<tr id="answerTr1">
							<th class="replyTableTh">운영자 답변</th>
							<td class='answerContent'>&emsp;${ reply.qrContent }</td> 
						</tr>
						<tr>
						<td id='btn' >
							<input type='button' name='btnAnswer2' id='btnAnswer2' value='수정하기' />
						</td>
					</tr>
					</c:if>
					
					<c:if test="${ empty reply.qrContent }">
					<tr id="answerTr2">
						<th class="replyTableTh">운영자 답변</th>
						<td id="admin_answer">
							<textarea class="answerContent" name="answerContent" rows="5">
								${reply.qrContent }
							</textarea>
						</td>
					</tr>
					<tr>
						<td id='btn' colspan="3" class="qnabtn">
							<input type='button' name='btnAnswer1' id='btnAnswer1' value='답변하기' />
						</td>
					</tr>
					</c:if>
				</c:if>
				<c:if test="${sessionScope.id ne 'admin'}">
				<tr>
					<th>운영자 답변</th>
					<c:if test="${not empty reply.qrContent }">
					<td>&emsp;${reply.qrContent }</td>
					</c:if>
					<c:if test="${empty reply.qrContent }">
					<td>&emsp;답변 대기중입니다.</td>
					</c:if>
				</tr>
				</c:if>
				<tr><td>&nbsp;</td></tr>
			</table>
		</div>
	</div>
</article>