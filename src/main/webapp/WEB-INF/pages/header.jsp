<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<div class="mainDiv">
	<div class="team">
		<a href="index.mvc">Team IT-Imagination</a>
	</div>
	<div class="main-a">
	<c:if test="${not sessionScope.isLogin}">
		<a href="join.mvc">회원가입</a>
		<a href="loginForm.mvc">로그인</a>
	</c:if>
	<c:if test="${sessionScope.isLogin}"> 
	안녕하세요. ${sessionScope.id }님 &emsp;
		<a href="logout.mvc">로그아웃</a>
		<a href="MemberUpdateCheckForm.mvc">정보수정</a>
	</c:if>
	</div>	
	
		<div class="dropdown-wrap">
		 <div class="dropdown">
		      <div class="dropbtn">상품페이지</div>
			      <div class="dropdown-content">
			      	<a href="pList.mvc">상품리스트</a>
			      	<a href="pListType.mvc?pType=outer">아웃터</a>
			        <a href="pListType.mvc?pType=top">상의</a>
			        <a href="pListType.mvc?pType=bottom">하의</a>
			        <c:if test="${sessionScope.id eq 'admin'}"> 
						<a href="pWriteForm.mvc">상품등록</a>
					</c:if>
			      </div>
	    </div>
	 	<div class="dropdown">
		      <div class="dropbtn">고객센터</div>
			      <div class="dropdown-content">
			      	<a href="qnaList.mvc">QnA</a>
			        <a href="noticeForm.mvc">공지사항</a>
			        <a href="fnq.mvc">자주묻는질문</a>
			        <a href="report.mvc">홈페이지 만든이</a>
			      </div>
	    </div>
	    <div class="dropdown">
		      <div class="dropbtn">마이페이지</div>
			      <div class="dropdown-content">
			      	<c:if test="${sessionScope.id ne 'admin'}"> 
						<a href="cart.mvc">장바구니</a>
				        <a href="order.mvc">구매내역</a>
					</c:if>
			        <c:if test="${sessionScope.id eq 'admin'}"> 
						<a href="orderAdmin.mvc">구매내역관리</a>
						<a href="memberAdmin.mvc">회원관리</a>
						 <a href="game.mvc">Game</a>
				        <a href="Universe.mvc">Universe</a>
					</c:if>
			      </div>
	    </div>
	    
	    </div> 
	</div>
	
</header>