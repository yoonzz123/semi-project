<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	<table>
		<tr>
			<td><h2>상품 리스트</h2></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
				<form name="searchForm" id="searchForm">
					<select name="type" id="type">
						<option value="pName">이름</option>
						<option value="pType">종류</option>
					</select>
					<input type="text" name="keyword" id="keyword" /> 
					<input type="submit" value="검색" />
				</form>
			</td>
		</tr>
		<tr>
			<c:if test="${ searchOption }">
				<tr>
					<td>"${ keyword }" 검색결과</td>
				</tr>
			</c:if>
			<c:if test="${ not searchOption }">
			<tr>
				<td><a href="pWriteForm.mvc">등록하기</a></td>
			</tr>
			</c:if>
			<c:if test="${ searchOption }">
				<tr>
					<td><a href="pList.mvc">리스트</a></td>
					<td><a href="pWriteForm.mvc">등록하기</a></td>
				</tr>
			</c:if>
		</tr>
		<tr>
			<td>이미지</td>
			<td>상품명</td>
			<td>종류</td>
			<td>가격</td>
		</tr>
		<%-- <c:forEach var="p" items="${ pList }" varStatus="status">
			<tr>
				<td>${ p.pNo }</td>
				<td><a href="pDetail.mvc?pNo=${ p.pNo }">${ p.pName }</a></td>
				<td>${ p.pType }</td>
				<td>${ p.pPrice }</td>
			</tr>
		</c:forEach> --%>
		<c:if test="${ searchOption and not empty pList }">
			<c:forEach var="p" items="${ pList }" varStatus="status">
				<tr>
					
					<td><img src="upload/${ p.pImg }"/></td>
					<td><a href="pDetail.mvc?pNo=${ p.pNo }&pageNum=${ currentPage }
						&type=${ type }&keyword=${ keyword }">${ p.pName }</a>
					</td>
					<td>${ p.pType }</td>
					<td><fmt:formatDate value="${ p.pRdate }" /></td>
					<td>${ p.pPrice }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><c:if test="${ startPage > pageGroup }">
						<a
							href="pList.mvc?pageNum=${ startPage - pageGroup }
							&type=${ type }&keyword=${ keyword }">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
						<c:if test="${ i == currentPage }">
						[ ${ i } ]
						</c:if>
						<c:if test="${ i != currentPage }">
							<a
								href="pList.mvc?pageNum=${ i }&type=${ type }
							&keyword=${ keyword }">[
								${ i } ]</a>
						</c:if>
					</c:forEach> <c:if test="${ endPage < pageCount }">
						<a
							href="pList.mvc?pageNum=${ startPage + pageGroup }
							&type=${ type }&keyword=${ keyword }">[다음]</a>
					</c:if></td>
			</tr>
		</c:if>
		
		<c:if test="${ not searchOption and not empty pList }">
			<c:forEach var="p" items="${ pList }" varStatus="status">
				<tr>
					
					<td><img src="upload/${ p.pImg }"/></td>
					<td><a
						href="pDetail.mvc?pNo=${ p.pNo }&pageNum=${ currentPage }
						&type=${ type }&keyword=${ keyword }">${ p.pName }</a>
					</td>
					<td>${ p.pType }</td>
					<td><fmt:formatDate value="${ p.pRdate }" /></td>
					<td>${ p.pPrice }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><c:if test="${ startPage > pageGroup }">
						<a
							href="pList.mvc?pageNum=${ startPage - pageGroup }
							&type=${ type }&keyword=${ keyword }">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
						<c:if test="${ i == currentPage }">
						[ ${ i } ]
						</c:if>
						<c:if test="${ i != currentPage }">
							<a
								href="pList.mvc?pageNum=${ i }&type=${ type }
							&keyword=${ keyword }">[
								${ i } ]</a>
						</c:if>
					</c:forEach> <c:if test="${ endPage < pageCount }">
						<a
							href="pList.mvc?pageNum=${ startPage + pageGroup }
							&type=${ type }&keyword=${ keyword }">[다음]</a>
					</c:if></td>
			</tr>
		</c:if>
		<c:if test="${ searchOption and empty pList }">
			<tr>
				<td>
					"${ keyword }" 가 포함된 상품이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:if test="${ not searchOption and empty pList }">
			<tr>
				<td>상품이 존재하지 않습니다.</td>
			</tr>
		</c:if>
	</table>
</article>