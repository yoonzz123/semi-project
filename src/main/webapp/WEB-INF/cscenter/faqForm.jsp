<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link type="text/css" href="css/css.css" rel="stylesheet"/>
<article>
<div class="faqWriteMain">
<form action="FaQWriteService.mvc">
	<table class="faqWriteTable">
		<tr>
			<td>
				<label>제목</label>
			</td>
			<td>
				<input name="fTitle" type="text">
			</td>
		</tr>
		<tr>
			<td>
				<label>내용</label>
			</td>
			<td>
				<textarea name="fContent" rows="10" cols="50">
				</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="faqWriteSubmit">
				<input type="submit" value="자주묻는질문 등록">
			</td>
		</tr>
	</table>
</form>
</div>    
</article>