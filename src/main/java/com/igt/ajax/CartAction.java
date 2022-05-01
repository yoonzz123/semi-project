package com.igt.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.CartDao;

public class CartAction implements AjaxProcess {

	@Override
	public void ajaxProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int cQTY = Integer.parseInt(request.getParameter("cQTY"));
		
		String id = (String) session.getAttribute("id");
		int pNo =  Integer.parseInt(request.getParameter("pNo"));
		
		CartDao dao = new CartDao();
		boolean isOverlap = dao.isOverlapCheck(id, pNo);
		if(!isOverlap) {
			dao.insertCart(cQTY, id, pNo);
		} else {
			dao.updateCart(cQTY, id, pNo);
		}
	}

}
