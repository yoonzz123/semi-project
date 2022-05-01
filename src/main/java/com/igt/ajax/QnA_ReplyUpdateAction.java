package com.igt.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.QnADao;

public class QnA_ReplyUpdateAction implements AjaxProcess {

	@Override
	public void ajaxProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		QnADao dao = new QnADao();
	
		String qrContent = request.getParameter("qrContent");
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		
		dao.updateQnA_Reply(qNo, qrContent);
		
		
		
	}

}
