package com.igt.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.OrdersDao;

public class UpdateStatusAction implements AjaxProcess {

	@Override
	public void ajaxProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		int oStatus = Integer.parseInt(request.getParameter("value"));
		
		OrdersDao dao = new OrdersDao();
		dao.updateStatus(oNo, oStatus);
		
		String result = dao.getStatus(oNo) + "";
		System.out.println("result : " + result);
		PrintWriter out = response.getWriter();
		out.write(result);			
	}
}
