package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.OrdersDao;
import com.igt.vo.Orders;

public class OrderService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("id");
		
		// 오더 리스트 불러와서 전송
		OrdersDao dao = new OrdersDao();
		ArrayList<Orders> oList = dao.getOrderList(mId);
		request.setAttribute("oList", oList);
		
		// 오더별 상세 주문 가져오기
		
		return "orders/orderList";
	}

}
