package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.QnADao;
import com.igt.vo.QnA;

public class QnAListService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		QnADao dao = new QnADao();
		ArrayList<QnA> qnaList = dao.getQnAList();
		
		request.setAttribute("qnaList", qnaList);
		
		return "cscenter/qnaList";
	}

}
