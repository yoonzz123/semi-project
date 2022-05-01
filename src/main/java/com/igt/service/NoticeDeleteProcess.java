package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.NoticeDao;

public class NoticeDeleteProcess implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nNo = request.getParameter("nNo");
		
		
		NoticeDao dao = new NoticeDao();
		int no = Integer.parseInt(nNo);
		dao.deleteNotice(no);
		
		
		return "r:notice/noticeForm";
	}

}
