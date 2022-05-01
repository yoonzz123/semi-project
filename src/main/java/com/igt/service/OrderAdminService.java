package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.OrdersDao;
import com.igt.vo.Orders;
import com.igt.vo.Product;

public class OrderAdminService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrdersDao oDao = new OrdersDao();
		
		ArrayList<Orders> odList = new ArrayList<Orders>();
		ArrayList<Product> pList = new ArrayList<Product>();
		
		odList = oDao.getOdList();	
		pList = oDao.getOdProductList();
		
		request.setAttribute("o", odList);
		request.setAttribute("p", pList);
		
		return "orders/ordersAdmin";
	}

}
