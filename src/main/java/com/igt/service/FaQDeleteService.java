package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.FaQDao;

public class FaQDeleteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int fNo = Integer.parseInt(request.getParameter("fNo"));
		
		FaQDao dao = new FaQDao();
		dao.deletef(fNo);
		
		return "r:fnq.mvc";
	}

}
