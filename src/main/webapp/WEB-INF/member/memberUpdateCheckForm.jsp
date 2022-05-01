<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<article>
	<div class="wrapper">
		<div class="sub_nav"></div>
		<div class="content">
			<h3> 회원정보 수정</h3>
			<form action="memberUpdateForm.mvc" method="Post">
				<div>
					<label>비번확인:</label>
					<input name="mPw" type="password">
				</div>
			    <div>
			      <label>회원정보 수정</label>
			      <input type="submit" value="수정하기">
			    </div>
			</form>
		</div>
	</div>
	
</article>