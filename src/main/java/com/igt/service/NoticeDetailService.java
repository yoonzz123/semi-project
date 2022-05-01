package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.NoticeDao;
import com.igt.vo.Notice;

public class NoticeDetailService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("nNo");
		
		NoticeDao dao = new NoticeDao();
		Notice notice = dao.getNotice(Integer.valueOf(no));
		
		request.setAttribute("notice", notice);
		
		
		return "notice/noticeDetail";
	}

}
