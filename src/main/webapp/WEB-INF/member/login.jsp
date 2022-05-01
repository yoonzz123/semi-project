<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" href="css/login.css" rel="stylesheet"/>
<article class="login-container">
	<div class="center">
	<h2>쇼핑몰에 로그인하세요.</h2>
	<form method="post" action="login.mvc" method="post">
	
		<div class="txt_field">
			<input type="text" id="loginId" name="loginId" required placeholder="아이디를 입력해주세요.">	
		</div>
		<div class="txt_field">
			<input type="password"  id="loginPw" name="loginPw" required placeholder="비밀번호를 입력해 주세요.">		
		</div>	
		<input type="submit" value="Login" class="login-submit">
		
		<div class="signup_link">
			<div class="pass">
				<input type="button" id="idSerch" name="idSerch" value="아이디찾기">
				<input type="button" id="passSerch" name="passSerch" value="비밀번호찾기">
			</div>
				ID가 없으십니까?
				<a href="join.mvc" class=now>지금 만드세요.</a>
		</div>		
	</form>
	</div>
</article>