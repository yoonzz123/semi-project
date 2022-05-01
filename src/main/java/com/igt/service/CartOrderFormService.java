package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.OrdersDao;
import com.igt.dao.ProductDao;
import com.igt.vo.Member;
import com.igt.vo.Product;

public class CartOrderFormService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String[] pNoList = request.getParameterValues("pay_pNo");
		int i = 0;
		
		OrdersDao oDao = new OrdersDao();
		
		// member 정보 
		ProductDao pDao = new ProductDao();
		Member m = oDao.getMember(id);
		
		// Cart 테이블에 담긴 Product테이블 정보
		ArrayList<Product> pList = new ArrayList<Product>();
		for(i = 0; i < pNoList.length; i++) {
			Product p = new Product();
			p = pDao.getCartProduct(id, Integer.parseInt(pNoList[i]));
			pList.add(p);
		}
		
		request.setAttribute("p", pList);
		request.setAttribute("m", m);
		
		return "orders/nowOrderForm";
	}

}
