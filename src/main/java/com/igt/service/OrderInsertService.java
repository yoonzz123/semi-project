package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.OrdersDao;
import com.igt.vo.Orders;
import com.igt.vo.Orders_detail;

public class OrderInsertService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//파라미터값
		String mId = request.getParameter("mId");
		String oName = request.getParameter("oName");
		String oPhone = request.getParameter("oPhone");
		String oAdd = request.getParameter("oAdd");
		String oAdd2 = request.getParameter("oAdd2");
		int oPost = Integer.parseInt(request.getParameter("oPost"));
		int oPrice = Integer.parseInt(request.getParameter("oPrice"));
		int oPay = Integer.parseInt(request.getParameter("oPay"));
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		int odQTY = Integer.parseInt(request.getParameter("odQTY"));
		
		Orders orders = new Orders();
			orders.setmId(mId);
			orders.setoName(oName);
			orders.setoPhone(oPhone);
			orders.setoAdd(oAdd);
			orders.setoAdd2(oAdd2);
			orders.setoPost(oPost);
			orders.setoPrice(oPrice);
			orders.setoPay(oPay);
			
		//주문 입력하고 주문번호 받아옴
		OrdersDao dao = new OrdersDao();
		dao.insertOrder(orders);
		int oNo = dao.getoNo();
		
		//상세디테일 입력
		Orders_detail orders_detail = new Orders_detail();
			orders_detail.setpNo(pNo);
			orders_detail.setoNo(oNo);
			orders_detail.setOdQTY(odQTY);
		dao.insertOrdersDetail(orders_detail);
		
		return "r:order.mvc";
	}

}
