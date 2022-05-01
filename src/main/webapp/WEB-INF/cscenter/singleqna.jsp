<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
	<div class="wrapper">
		<div class="sub_nav"></div>
		<div class="content">
			<h3>1:1 문의 게시판</h3>
			<form>
				<div>
					<label>제목</label>
					<input type="text">
				</div>
				<div>
					<label>질문카테고리</label>
					<select>
						<option>취소/환불</option>
						<option>상품관련</option>
						<option>as관련</option>
					</select>
				</div>
				<div>
					<label>이미지 첨부</label>
					<input type="file">
				</div>
				<div>
					<label>상세내용</label>
					<div>
						<textarea rows="10" cols="50">
						</textarea>			
					</div>
				</div>
				<div>
					<input type="submit" value="문의보내기">
					<input type="reset" value="다시쓰기">
				</div>
			</form>
		</div>
	</div>
</article>