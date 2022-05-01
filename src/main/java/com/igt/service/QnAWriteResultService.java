package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.QnADao;

public class QnAWriteResultService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");
		int count = 0;
	
		QnADao dao = new QnADao();
		
		count = dao.getQnACount() + 1;
		dao.insertQnA(count, id, qTitle, qContent);		
		
		return "r:qnaList.mvc";
	}

}
