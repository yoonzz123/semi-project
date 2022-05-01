package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.ProductDao;
import com.igt.vo.Product;

public class ProductListService implements CommandProcess {

	
	private static final int PAGE_SIZE = 3;
	
	private static final int PAGE_GROUP = 5;
	
	@Override
	public String requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		String pageNum = request.getParameter("pageNum");
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		//  1 * 3 - ( 3 - 1)  = 1
		//  3 * 3 - = 7
		
		int startRow = currentPage * PAGE_SIZE - (PAGE_SIZE - 1);
		
		//  1 + 3 - 1 = 3
		//  
		int endRow = startRow + PAGE_SIZE - 1;
		
		int listCount = 0;
		// 상품 리스트 불러오기
		ProductDao dao = new ProductDao();
		ArrayList<Product> pList = null;
		
		boolean searchOption = (type == null || type.equals("")
				|| keyword == null || keyword.equals("")) ? false : true;
		
		if(! searchOption) {
			listCount = dao.getProductCount();
			pList = dao.productList(startRow, endRow);
		}else {
			listCount = dao.getProductCount(type, keyword);
			pList = dao.searchList(type, keyword, startRow, endRow);
		}	
		
		int pageCount = listCount / PAGE_SIZE
				+ (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
				- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		request.setAttribute("pList", pList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageGroup",PAGE_GROUP);
		request.setAttribute("listCount", listCount);
		request.setAttribute("searchOption", searchOption);
		
		if(searchOption) {
			request.setAttribute("keyword", keyword);
			request.setAttribute("type", type);
		}
		
		
		return "product/pList";
	}

}
