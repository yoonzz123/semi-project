<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link type="text/css" href="css/orderList.css" rel="stylesheet"/>
<article>
	<div class="orderFormMainDiv">
		<form action="orderInsert.mvc" method="POST">
			<div class="orderH">
			<h3>구매자정보</h3>
			</div>
			<table class="orderMainTable">
				<tr>
					<td class="orderName">
						구매자이름 : 
					</td>
					<td class="orderInput">
						<input name="oName" type="text" value="${ m.mName }">
					</td>
				</tr>
				<tr>
					<td class="orderEmail">
						이메일 : 
					</td>
					<td class="orderInput">
						<input name="oEmail" type="email" value="${ m.mEmail }">
					</td>
				</tr>
				<tr>
					<td class="orderPhone">
						휴대폰 번호 : 
					</td>
					<td class="orderInput">
						<input name="oPhone" type="text" value="${ m.mPhone }">
					</td>
				</tr>
				<tr class="orderInput">
					<td class=" orderPost">
						우편번호 : 
					</td>
					<td class="orderInput">
						<input name="oPost" id="mpost" type="text" value="${ m.mPost }" readonly>
						<input type="button" value="우편번호 검색" id="btnZipcode" />
					</td>
				</tr>
				<tr>
					<td class="orderAdd">
						주소 : 
					</td>
					<td class="orderInput">
						<input name="oAdd" id="madd" type="text" value="${ m.mAdd }" size="60"readonly>
					</td>
				</tr>
				<tr>
					<td class="orderAdd2">
						상세주소 : 
					</td>
					<td class="orderInput">
						<input name="oAdd2" type="text" value="${ m.mAdd2 }">
					</td>
				</tr>						
			</table>
			<div class="ordersubTitle">
			<h3>구매상품</h3>
			</div>
			<table class="ordersubTable">
				<tr>
					<th>상품명</th>
					<th>상품타입</th>
					<th>가격</th>
					<th>주문수량</th>
					<th>총가격</th>
					<th>이미지</th>
				</tr>
				<c:forEach var="p" items="${ p }">
				<tr>
					<td>${ p.pName }</td>
					<td>${ p.pType }</td>
					<td>${ p.pPrice }원</td>&emsp;
					<td>${ p.cQTY }개</td>
					<td>${ p.pPrice * p.cQTY }</td>
					<td><img src="upload/${ p.pImg }" width="100px"></td>
				</tr>
				</c:forEach>
			</table>
			<div class="ordersubH">
			<h3>결제수단</h3>
			</div>
			<div class="orderPay">
			<label for="oPay1">현금</label>
			<input type="radio" name="oPay" value="1" id="oPay1" checked>
			<label for="oPay2">카드</label>
			<input type="radio" name="oPay" value="2" id="oPay2">
			<input type="submit" value="구매하기">
			</div>
			<input name="mId" type="hidden" value="${ sessionScope.id }">
			<c:forEach var="p" items="${ p }">
			<input name="pNo" type="hidden" value="${ p.pNo }">
			<input name="oPrice" type="hidden" value="${ p.pPrice * p.cQTY }">
			<input name="odQTY" type="hidden" value="${ p.cQTY }">
			</c:forEach>
			
			
		</form>
		</div>
</article>