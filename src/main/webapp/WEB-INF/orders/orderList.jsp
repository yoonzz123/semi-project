<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" href="css/orderList1.css" rel="stylesheet">
<article>
	<c:forEach var="o" items="${ oList }" varStatus="status">
	<table id="oListtable">
		<tr>
			<td class="order">
				주문 날자 :
			</td>
			<td>
				${ o.oRdate }
			</td>
		</tr>
		<tr>
			<td class="order">
				주문 상태 :
			</td>
			<td>
				<span style="color:red;">
				<c:if test="${ o.oState eq 0}"> 
					배송준비중
				</c:if>
				<c:if test="${ o.oState eq 1}"> 
					배송중
				</c:if>
				<c:if test="${ o.oState eq 2}"> 
					배송완료
				</c:if>
				</span>
			</td>
		</tr>
		<tr>
			<td class="order">
				주문 금액 :
			</td>
			<td>
				${ o.oPrice }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:forEach var="od" items="${ od_List[status.index] }">
					<c:set var="odQTY" value="${ od.odQTY }" />
				</c:forEach>
				<table>
					<tr>
						<th class="name">상품명</th>
						<th class="name">상품타입</th>
						<th class="name">가격</th>
						<th class="name">주문수량</th>
						<th class="name">총가격</th>
						<th class="name">이미지</th>
					</tr>
					<c:forEach var="p" items="${ p_List[status.index] }">
					<tr class="content">
						<td>${ p.pName }</td>
						<td>${ p.pType }</td>
						<td>${ p.pPrice }</td>
						<td>${ odQTY }</td>
						<td>${ p.pPrice * odQTY }</td>
						<td><img src="upload/${ p.pImg }" width="100px"></td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="6">${ o.oPrice }</td>
					</tr>
				</table>
				 				
			</td>
		</tr>
	</table>
	<br/>
	</c:forEach>
	
</article>