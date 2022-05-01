package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.ProductDao;

public class ListDeleteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pNo = request.getParameter("pNo");
		
		
		ProductDao dao = new ProductDao();
		int no = Integer.parseInt(pNo);
		dao.deleteProduct(no);
		
		return "product/pList";
	}

}
