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

public class NowOrderFormService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		int cQTY = Integer.parseInt(request.getParameter("odQTY"));
		
		OrdersDao oDao = new OrdersDao();
		ProductDao pDao = new ProductDao();
		Member m = oDao.getMember(id);
		
		ArrayList<Product> pList = new ArrayList<Product>();
		pList = pDao.getOrderProduct(pNo);		
		request.setAttribute("p", pList);
		request.setAttribute("m", m);
		request.setAttribute("cQTY", cQTY);
		
		return "orders/nowOrderForm";
	}

}
