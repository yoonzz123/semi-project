package com.igt.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.QnADao;

public class QnA_ReplyAction implements AjaxProcess {

	@Override
	public void ajaxProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String qac = request.getParameter("qac");
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		QnADao dao = new QnADao();
		int count = dao.getQnA_ReplyCount() + 1;
		dao.insertQnA_Reply(count, qNo, qac);
		
	}
}
