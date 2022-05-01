package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.ProductDao;
import com.igt.dao.ReviewDao;
import com.igt.vo.Product;
import com.igt.vo.Review;




public class ProductDetailService implements CommandProcess {

	@Override
	public String requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		String no = request.getParameter("pNo");
		// String pageNum = request.getParameter("pageNum");
		// String type = request.getParameter("type");
		// String keyword = request.getParameter("keyword");
		
		ProductDao dao = new ProductDao();
		Product product = dao.getProduct(Integer.valueOf(no));		

		request.setAttribute("product", product);
		
		
		//리뷰 기능
		
		ReviewDao Rdao = new ReviewDao();
		ArrayList<Review> rList = Rdao.rList(Integer.valueOf(no));
		
		request.setAttribute("rList", rList);
		
		return "product/pDetail";
	}

}
