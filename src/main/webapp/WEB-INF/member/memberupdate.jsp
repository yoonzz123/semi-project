<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<article>
         <div>
		<h2>회원정보 수정하기</h2>
		<form id="updateForm" action="memberUpdateS.mvc" method="post">
			<table>
			  <tr>
			  <td><label>아이디 :</label></td>
			  <td>
			 <input type="text" name="mid" value="${m.mId }" readonly>
			 </td>
			 </tr>
			 <tr>
			<td><label>새 비밀번호:</label></td>			
		      <td> 
		       <input type="text" name="mpw" id="mpw">
		      </td>
		      </tr>
			 <tr>
			 <td><label>이름 : </label> 
			 <td>
			 <input type="text" name="mname" value="${m.mName}">
			 </td>
			 </tr>
			 <tr>
			<td><label>우편번호 :</label></td>
			<td>
			 <input type="text" name="mpost" value="${m.mPost }" id="mpost" readonly>
			 <input type="button" value="우편번호 검색" id="btnZipcode"/>
			 </td>
			 </tr>
			 <tr>
			 <td><label>주소 : </label></td>
			 <td>
			 <input type="text" name="madd" value="${m.mAdd }" id="madd" readonly>
			 </td>
			 </tr>
			<tr>
			<td><label>상세주소 :</label></td>
			<td>
			 <input type="text" name="madd2" value="${m.mAdd2 }" id="madd2">
			</td>
			</tr>
			<tr>
			<td><label>휴대폰 :</label></td>
			<td>
			 <select name="mphone1" id="mphone1">
			        <option${m.mPhone.split('-')[0] == 010 ? "selected" : ""}>010</option>
			        <option${m.mPhone.split('-')[0] == 011 ? "selected" : ""}>011</option>
			        <option${m.mPhone.split('-')[0] == 016 ? "selected" : ""}>016</option>
             </select>
             <input type="text" id="mPhone2" name="mphone2" size="5" maxlength="4"
                   value="${m.mPhone.split('-')[1] }"/>-
             <input type="text" id="mPhone3" name="mphone3" size="5" maxlength="4"
                   value="${m.mPhone.split('-')[2] }"/>    
 			
 			<tr>
					<td><label>이메일:</label></td>
					<td>
					<input type="text" id="emailId" name="memail" width="100px"
						value="${m.mEmail.split('@')[0] }"/>@
						<input type="text" id="emailDomain" name="memailDomain"
						value="${sessionScope.m.mEmail.split('@')[1] }"/>
						 <select name="selectDomain" id="selectDomain">
							<option>직접입력</option>
							<option>네이버</option>
							<option>한메일</option>
							<option>구글</option>
						</select>
					</td>
				</tr>
			</table>
			<input type="submit" value="수정하기">
		</form>	
		<a href="memberDelete.mvc" id="memberDeleteBtn">삭제하기</a>
		</div>
</article>
