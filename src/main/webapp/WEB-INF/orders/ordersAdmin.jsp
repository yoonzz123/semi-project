<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" href="css/adminorderList.css" rel="stylesheet">
<article>
	<h3 class="adminordertitle"> 주문 관리 페이지 </h3><br/>
	<c:forEach var="o" items="${ o }" varStatus="status">
	<table id="oListtable">
		<tr>
			<td class="adminorder">
				주문 날자 :
			</td>
			<td>
				${ o.oRdate }
			</td>
		</tr>
		<tr>
			<td class="adminorder">
				주문 상태 :
			</td>
			<td>
				<c:if test="${ o.oState eq 0}">
					배송준비중
				</c:if>
				<c:if test="${ o.oState eq 1}">
					배송중
				</c:if>
				<c:if test="${ o.oState eq 2}">
					배송완료
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="adminorder">
				주문 금액 :
			</td>
			<td>
				${ o.oPrice }<br/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table>
					<tr>
						<th class="adminname">상품명</th>
						<th class="adminname">상품타입</th>
						<th class="adminname">가격</th>
						<th class="adminname">주문수량</th>
						<th class="adminname">총가격</th>
						<th class="adminname">이미지</th>
					</tr>
					
					<tr class="admincontent">
						<td>${ p[status.index].pName }</td>	
						<td>${ p[status.index].pType }</td>	
						<td>${ p[status.index].pPrice }</td>	
						<td>${ p[status.index].cQTY }</td>	
						<td>${ p[status.index].cQTY * p[status.index].pPrice }</td>	
						<td>${ p[status.index].pImg }<br/><br/></td>
					</tr>
					<tr>
						<td colspan="5">${ o.oPrice }</td>
						
						<c:if test="${ o.oState eq 0}"> 
						<td><input type ="button" class="btnoStatus" name="btnoStatus" value="배송 준비" data-oNo="${o.oNo }"></td>
						</c:if>
						<c:if test="${ o.oState eq 1}"> 
						<td><input type ="button"  class="btnoStatus" name="btnoStatus" value="배송 중" data-oNo="${o.oNo }"></td>
						</c:if>
						<c:if test="${ o.oState eq 2}"> 
						<td><input type ="button" class="btnoStatus" name="btnoStatus" value="배송 완료" data-oNo="${o.oNo }"></td>
						</c:if>
						<td>
						<form action="#">
							<input type="hidden" id="Status" name="Status" value='1' />
						</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br/>
	</c:forEach>
	
</article>