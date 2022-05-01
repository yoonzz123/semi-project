package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.NoticeDao;

public class NoticeWriteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		
	
		/*
		Notice notice = new Notice();
		notice.setnTitle(nTitle);
		notice.setnContent(nContent);
		*/
		NoticeDao dao= new NoticeDao();
		dao.insertNotice(nTitle, nContent);
		
		return "r:noticeForm.mvc";
	}

}
