<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
	<div class="wrapper">
		<div class="sub_nav"></div>
		<div class="content">
			<h3>장바구니</h3>
			
				<div id='cart_header'>
					<input type='checkbox' id='cart_selectAll'>
					<span><b>전체 선택</b></span>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					
				</div>
				<hr>
				<c:if test="${ empty cartList }">
				<span>장바구니가 비어있습니다.</span>
				</c:if>
				<!-- content -->
				<div id='cart_content'>
					<c:forEach var="c" items="${ cartList }">
					<div>
						
						<input type='checkbox' class='cart_check' name='cart_check' value='${c.cQTY}' data-price="${c.pPrice }" data-pNo="${ c.pNo }"/>
						<span><img src="upload/"${ p.pImg } width="100px"></span>	&emsp; | 	&emsp;
						<span>${ c.pName }</span>&emsp; | 	&emsp;
						<span>수량 : <input type='number' value='${ c.cQTY }' 	data-price="${ c.pPrice }" size='4' min='1' max='100' /></span>&emsp; | 	&emsp;
						<span >합계 : <span class='price'>${ c.pPrice * c.cQTY }</span> 원</span>&emsp; | 	&emsp;
						<span><input type='button' class="cart_delete" data-pNo="${c.pNo }" value='삭제' /></span>
					</div>
					<hr>
					</c:forEach>
				</div>
				<!-- delete Form -->
				<form action="cartDelete.mvc" method="post" class="c_deleteForm">
					<input type="hidden" name="delete_pNo" class="delete_pNo" />
				</form>
				
				<!-- payment Form -->
				<form action="cartOrder.mvc" id="pay_Form" name="pay_Form" method="post">
				</form>
				
					<!-- total -->
				<div id='cart_total'>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					
					<span>주문 총 금액 : </span>
					<span id='totalamount'>0 원</span>
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<span>
						<input type="button" id='payment' value='결제하기' />
					</span>
				</div>
		
		
		</div>
	</div>
</article>