<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link type="text/css" href="css/noticeDetail.css" rel="stylesheet"/>
<article class="body">
<h3 class='sub_header'>NOTICE</h3>	
<form name="nWrite" action="nWrite.mvc" id="nWrite" >
	<div class="content">
		<div class="c_Title">
			<div class="c_TitleTh">SUBJECT</div>
			<div class="c_TitleTd">
				<input type="text" name="nTitle">
			</div>
		</div>
		<div class="c_Content">
			<textarea class="c_ContentTd" name="nContent" rows="5" cols="33" placeholder="내용을 입력해주세요."></textarea>
		</div>
		<div class="btn">
			<input class="nDelete" type="reset" value="다시쓰기"/>
			<input class="nDelete" type="submit" value="등록하기"/>
			<input class="nDelete" type="button" value="목록으로" onclick="location.href='noticeForm.mvc'"/>
		</div>
	</div>
</form>	
</article>