<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" href="css/pDetail.css" rel="stylesheet"/>
<article class="pDetail">
	<h3 class="main-title">상품 상세보기</h3>

	<form id="checkForm" name="ckeckForm">
   <div>
   <input name="pNo" type="hidden" value="${ product.pNo }">
   </div>
   </form>
   
	<!-- 제품 이미지랑 이름, 가격 -->
	<div class="grid-2-box">
	<hr/>
		<div class="p-img">
			<img src="upload/${ product.pImg }" width="100%">
		</div>

		<div class="p-Info">
			<h3 class="p-name">${ product.pName }</h3>
			<h6 class="p-n-sub">[해외 배송 가능상품]</h6>
			<hr/>
			<p class="price">
				<span class="inof-Td">가격 : </span>
				<strong>${ product.pPrice }</strong>원
			</p>
			<p class="Shipping">
				<span class="inof-Td">국내 해외배송</span>
				<input type="radio" name="Shipping"checked="checked"/>
				<label for="Shipping_select">국내배송</label>
				<input type="radio" name="Shipping" />
				<label for="Shipping_noselect">해외배송</label>
			</p>
			<p class="Shipping_price">
				<span class="inof-Td">배송비</span> 
						2,500원 (30,000원 이상 구매시 무료배송)</p>
			<hr/>
			<p>
				<span class="inof-Td">타입 : </span>
				${ product.pType }
			</p>
			<hr />
			<div class="pay_btn">
			<form action="nowOrderForm.mvc" method="POST" id="nowBuyForm">
				<input id="mId" name="mId" type="hidden" value="${ sessionScope.id }">
				<input id="pNo" name="pNo" type="hidden" value="${ product.pNo }">
				<span class="inof-Td">수량 : </span>
				<input name="odQTY" type="number" value="1" id="odQTY" size="6" required><br>
				<input type="submit" id="btnOrder" class="btn" value="BUY">
			</form>
			<form action="#" method="POST" id="nowBuyForm">
				<input id="cart_mId" name="mId" type="hidden" value="${ sessionScope.id }">
				<input id="cart_pNo" name="pNo" type="hidden" value="${ product.pNo }">
				<input type="button" id="btnCart" class="btn"  value="CART" />
			</form>
			</div>
		</div>
	</div>

	<hr />
		<h3 class="p-detail">상품 상세설명</h3>
		<p>
			${ product.pDetail }
		</p>
	<hr />
	<!-- 관리자용 버튼 -->
	<c:if test="${sessionScope.id eq 'admin'}"> 
		<div>
			<input type="button" id="pUpdate" class="btn-admin" value="수정하기" />
			<input type="button" id="pDelete" class="btn-admin" value="삭제하기" />
			<hr />	
		</div>
	</c:if>
	
	<!--리뷰기능  -->
	<c:if test="${sessionScope.isLogin}">
	<div class="r-write">
		<button class="r-toggle-btn">리뷰쓰기</button>
		<div class="hidden">
			<form action="rWrite.mvc" class="reviewForm" method="POST" enctype="multipart/form-data">
				<input name="pNo" type="hidden" value="${ product.pNo }">
				<input name="mId" type="hidden" value="${sessionScope.id }" id="mId">
				<div class="m-center">
					<div class="r-writeTable">
						<label class="r-Th">제 목 </label>
						<span><input class="r-input" name="rTitle" type="text"></span>
					</div>
					<div class="r-writeTable">
							<span id='r-content' class="r-Th">상세내용</span>
							<textarea class="r-input"  name="rContent" rows="10" cols="50" placeholder="상품 품질에 대한 고객님의 솔직한 리뷰를 남겨주세요."></textarea>
					</div>
					<div class="r-writeTable">
							<label class="r-Th">사진 첨부</label>
							<input name="rImg" type="file" ${ empty r.rImg ? "" : "disabled" }>
							<input class="r-btn" type="submit" value="리뷰쓰기">
							<input class="r-btn"  type="reset" value="다시쓰기">
					</div>
				</div>
			</form>
		</div>
	</div>
	
	</c:if>
	<c:if test="${ not empty rList }">
		<c:forEach var="r" items="${ rList }" varStatus="status">
			<div class="r-list">
				<b style="font-size:large;">${ r.mId }</b>&emsp;
				<fmt:formatDate value="${ r.rRDate }" pattern="yyyy-MM-dd" /><br/>
				<p>
					<span class="r-l-title"><b>제목</b></span> 
					<span>${ r.rTitle }</span>
				</p>
				<p class="r-l-img">
					<c:if test="${ empty r.rImg }">
						<b>첨부파일 </b> &nbsp;<img src="images/cross.png" width="12px">
					</c:if>
				</p>
				<c:if test="${ not empty r.rImg }">
					<img src="upload/${ r.rImg }" width="300px">
				</c:if>
			</div>
			<p class="r-l-content">${ r.rContent }</p>
			<br/>
			<c:if test="${ sessionScope.id eq r.mId or sessionScope.id eq 'admin' }">
			
			<div>
			<form action="rDelete.mvc" style="float:left;" method="POST">
				<input name="pNo" type="hidden" value="${ product.pNo }">
				<input name="rNo" type="hidden" value="${ r.rNo }">			
				<input class="r-l-btn" type="submit" value ="삭제하기">
			</form>
			<button class="r-toggle-btn">수정하기</button>
			<div class="hidden">
				<form action="rUpdate.mvc" class="reviewForm" method="POST" enctype="multipart/form-data">
					<input name="rNo" type="hidden" value="${ r.rNo }">
					<input name="pNo" type="hidden" value="${ product.pNo }">
					<input name="mId" type="hidden" value="${sessionScope.id }" id="mId">
					<div class="m-center">
						<div class="r-writeTable">
							<label class="r-Th">제 목 </label>
							<span><input class="r-input" name="rTitle" type="${r.rTitle }"></span>
						</div>
						<div class="r-writeTable">
							<span id='r-content' class="r-Th">상세내용</span>
							<textarea class="r-input"  name="rContent" rows="10" cols="50" >${ r.rContent }</textarea>
						</div>
						<div class="r-writeTable">
							<label class="r-Th">사진 첨부</label>
							<input name="rImg" type="file" ${ empty r.rImg ? "" : "disabled" }>
							<input class="r-btn" type="submit" value="리뷰쓰기">
							<input class="r-btn"  type="reset" value="다시쓰기">
						</div>
					</div>
				</form>
			</div>
			</div>
			</c:if>
			<hr/>
		</c:forEach>
	</c:if>
	
	<c:if test="${ empty rList }">
		<p>작성된리뷰없음</p>
	</c:if>

	<!-- 리뷰기능 끝 -->
</article>