<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link type="text/css" href="css/productList.css" rel="stylesheet">
<article>
	<form name="pWrite" action="pWrite.mvc" id="pWrite"
	method="post" enctype="multipart/form-data">
		<table class="writetable">
			<tr>
				<td colspan="4"><h2 class="write">여기는 상품 등록</h2></td>
			</tr>
			<tr>
				<td>상품명<br/><input type="text" name="pName"/></td>
				<td>가격<br/><input type="text" name="pPrice"/></td>
			</tr>
			<tr>
				<td><p>종류</p>
					<select name="pType">
						<option value="outer">아웃터</option>
						<option value="top">상의</option>
						<option value="bottom">하의</option>
					</select>
				</td>
				<td><br/>상세정보<br/><input type="text" name="pDetail"/></td>
			</tr>
			<tr>
				<td><br/>이미지첨부
					<input type="file" name="pImg" size="100" id="pImg" maxlength="200"/>
					<br/><br/><br/><br/>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center;"><input type="reset" value="다시쓰기"/>
					<input type="submit" value="등록하기"/>
					<input type="button" value="목록으로"
					onclick="location.href='pList.mvc'"/></td>
			</tr>
		</table>
	</form>
</article>