package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.FaQDao;
import com.igt.vo.FaQ;

public class FnQListService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FaQDao dao = new FaQDao();
		ArrayList<FaQ> fList = dao.getFaQList();
		
		request.setAttribute("fList", fList);
		
		return "cscenter/faq";
	}

}
