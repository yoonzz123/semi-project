package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.CartDao;
import com.igt.vo.Product;

public class CartService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		CartDao cDao = new CartDao();
		ArrayList<Product> cartList = new ArrayList<Product>();
		cartList = cDao.getCartList(id);
		request.setAttribute("cartList", cartList);
		
		return "mypage/cart";
	}

}
