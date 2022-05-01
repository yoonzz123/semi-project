<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link type="text/css" href="css/default.css" rel="stylesheet"/>
<link type="text/css" href="css/header.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/review.js"></script>
<script type="text/javascript" src="js/product.js"></script>
<script type="text/javascript" src="js/cart.js"></script>
<script type="text/javascript" src="js/order.js"></script>
</head>
<body>
	<div id="wrap">		
		<%@ include file="pages/header.jsp" %>		
		<c:if test="${ not empty param.body }">
			<jsp:include page="${ param.body }" />
		</c:if>		
		<%@ include file="pages/footer.jsp" %>
	</div>
</body>
</html>