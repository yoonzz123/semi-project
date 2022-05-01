<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link type="text/css" href="css/css.css" rel="stylesheet"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<article class="join-container">
	<div class="join-center">
		<h2>쇼핑몰에 회원가입하세요.</h2>
		<form id="joinForm" action="joinInfo.mvc" name="joinForm" id="joinForm" method="post">
			<input type="hidden" id="isIdCheck" name="isIdCheck" value="false" />
			<table>
				<tr>
					<td><label>아이디:</label></td>
					<td>
						<input type="text" id="mid" name="mid">
						<input type="button" id="btnIdCheck" name="btnIdCheck" value="중복 확인" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<span id="IdCheck"></span>
					</td>
				</tr>
				<tr>
					<td><label>비밀번호:</label></td>
					<td>
						<input type="password" id="mpw" name="mpw">
					</td>
				</tr>
				<tr>
					<td><label>비밀번호 확인:</label></td>
					<td>
						<input type="password" id="mpw2" name="mpw2">
					</td>
				</tr>
				<tr>
					<td><label>이름:</label></td>
					<td>
						<input type="text" id="mname" name="mname">
					</td>
				</tr>
				<tr>
					<td><label>우편번호:</label></td>
					<td>
						<input type="text" id="mpost" name="mpost" readonly>
						<input type="button" value="우편번호 검색" id="btnZipcode" />
					</td>
				</tr>
				<tr>
					<td><label>주소:</label></td>
					<td>
						<input type="text" id="madd" name="madd" readonly size="20">
					</td>
				</tr>	
				<tr>
					<td><label>상세주소:</label></td>
					<td>
						<input type="text" id="madd2" name="madd2" size="20">
					</td>
				</tr>	
				<tr>
					<td><label>휴대폰:</label></td>
					<td>
						<select name="mphone1" id="mphone1">
							<option>010</option>
							<option>011</option>
							<option>016</option>
						</select>
						-
						<input type="text" id="mphone2" name="mphone2" size="5" maxlength="4"> - 
						<input type="text" id="mphone3" name="mphone3" size="5" maxlength="4">
					</td>
				</tr>
				<tr>
					<td><label>이메일:</label></td>
					<td>
						<input type="text" id="emailId" name="emailId" width="100px">@
						<input type="text" id="emailDomain" name="emailDomain">
						<select>
							<option>직접입력</option>
							<option>네이버</option>
							<option>한메일</option>
							<option>구글</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="login-submit"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a href="loginForm.mvc">로그인</a> 
						&nbsp;&nbsp;| &nbsp;&nbsp;  
						<a href="#">아이디/비밀번호찾기</a>
					</td>
				</tr>	
				<tr>
					<td>&nbsp;</td>
				</tr>						
			</table>
		</form>
	</div>
</article>