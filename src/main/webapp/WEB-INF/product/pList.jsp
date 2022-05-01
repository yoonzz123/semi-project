<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" href="css/productList.css" rel="stylesheet"/>
<article>
	<table class="listtable">
		<tr>
			<td colspan="2"><h2 class="list">상품 리스트</h2></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center;">
				<form name="searchForm" id="searchForm">
					<select name="type" id="type">
						<option value="pName">이름</option>
						<option value="pType">종류</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="keyword" id="keyword" /> 
					<input type="submit" value="검색" />
				</form>
			</td>
		</tr>
		<tr>
			<td><br/><br/></td>
		</tr>
		<tr>
			<c:if test="${ searchOption }">
				<tr>
					<td style="text-align:center;">"${ keyword }" 검색결과</td>
				</tr>
			</c:if>
			<c:if test="${ searchOption }">
				<tr>
					<td style="font-size:20px;"><a href="pList.mvc">전체보기</a></td>
				</tr>
			</c:if>
		</tr>
		<c:if test="${ searchOption and not empty pList }">
			<c:forEach var="p" items="${ pList }" varStatus="status">
				<tr class="listimg">
					<td colspan="2" class="listimg">
					<a href="pDetail.mvc?pNo=${ p.pNo }&pageNum=${ currentPage }
						&type=${ type }&keyword=${ keyword }">
					<img src="upload/${ p.pImg }"/></a></td>
				</tr>
				<tr class="listname">
					<td class="listname">상품명 : &nbsp;&nbsp;${ p.pName }</td>
				</tr>
				<tr class="listtype">
					<td class="listtype">종류 : &nbsp;&nbsp;${ p.pType }</td>
				</tr>
				<tr class="listprice">
					<td class="listprice">가격 : &nbsp;&nbsp;${ p.pPrice }</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="listpageing"><c:if test="${ startPage > pageGroup }">
						<a href="pList.mvc?pageNum=${ startPage - pageGroup }
							&type=${ type }&keyword=${ keyword }">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
						<c:if test="${ i == currentPage }">
						[ ${ i } ]
						</c:if>
						<c:if test="${ i != currentPage }">
							<a href="pList.mvc?pageNum=${ i }&type=${ type }
							&keyword=${ keyword }">[
								${ i } ]</a>
						</c:if>
					</c:forEach> <c:if test="${ endPage < pageCount }">
						<a href="pList.mvc?pageNum=${ startPage + pageGroup }
							&type=${ type }&keyword=${ keyword }">[다음]</a>
					</c:if></td>
			</tr>
		</c:if>
		
		<c:if test="${ not searchOption and not empty pList }">
			<c:forEach var="p" items="${ pList }" varStatus="status">
				<tr class="listimg">
					<td colspan="2" class="listimg">
					<a href="pDetail.mvc?pNo=${ p.pNo }&pageNum=${ currentPage }
						&type=${ type }&keyword=${ keyword }">
					<img src="upload/${ p.pImg }"/></a></td>
				</tr>
				<tr class="listname">
					<td class="listname">상품명 : &nbsp;&nbsp;${ p.pName }</td>
				</tr>
				<tr class="listtype">
					<td class="listtype">종류 : &nbsp;&nbsp;${ p.pType }</td>
				</tr>
				<tr class="listprice">
					<td class="listprice">가격 : &nbsp;&nbsp;${ p.pPrice }</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="listpageing"><c:if test="${ startPage > pageGroup }">
						<a href="pList.mvc?pageNum=${ startPage - pageGroup }
							&type=${ type }&keyword=${ keyword }">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
						<c:if test="${ i == currentPage }">
						[ ${ i } ]
						</c:if>
						<c:if test="${ i != currentPage }">
							<a href="pList.mvc?pageNum=${ i }&type=${ type }
							&keyword=${ keyword }">[
								${ i } ]</a>
						</c:if>
					</c:forEach> <c:if test="${ endPage < pageCount }">
						<a href="pList.mvc?pageNum=${ startPage + pageGroup }
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