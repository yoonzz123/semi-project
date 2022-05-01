<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" href="css/noticeDetail.css" rel="stylesheet"/>
<article class="body">
	<h3 class='sub_header'>NOTICE</h3>	
	<form id="noticeForm" name="ckeckForm">
   		<div>
   			<input name="nNo" type="hidden" value="${ notice.nNo }">
   		</div>
   </form>
	<div class="content">
		<div class="c_Title">
			<div class="c_TitleTh">SUBJECT</div>
			<div class="c_TitleTd">${notice.nTitle}</div>
		</div>
		<div class="c_Date">
			<div class="c_DateTh">DATE</div>
			<div class="c_DateTd">${notice.nRdate}</div>
		</div>
		<div class="c_Content">
			<div class="c_ContentTd">${notice.nContent}</div>
		</div>
		<div class="btn" class="admin_write">
			<c:if test="${sessionScope.id eq 'admin'}"> 
				<input type="button" id="nDelete" value="삭제하기"/>
			</c:if>		
		</div>
	</div>
</article>