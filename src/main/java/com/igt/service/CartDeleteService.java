package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.CartDao;

public class CartDeleteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("id");
		int pNo = Integer.parseInt(request.getParameter("delete_pNo"));
		
		CartDao dao = new CartDao();
		dao.deleteCart(mId, pNo);
		
		return "r:cart.mvc";
	}

}
