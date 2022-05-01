package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.NoticeDao;
import com.igt.vo.Notice;

public class NoticeList implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		NoticeDao dao = new NoticeDao();
		ArrayList<Notice> nList = null;
		
		nList = dao.getNoticeList();
		
		
		request.setAttribute("nList", nList);
		return "notice/noticeForm";
	}

}
