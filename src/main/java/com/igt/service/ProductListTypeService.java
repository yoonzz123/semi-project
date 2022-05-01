package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.ProductDao;
import com.igt.vo.Product;

public class ProductListTypeService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pType = request.getParameter("pType");
		
		ProductDao dao = new ProductDao();
		ArrayList<Product> pList =  dao.productList(pType);
		
		request.setAttribute("pList", pList);
		
		return "product/pList";
	}

}
