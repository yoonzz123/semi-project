package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.FaQDao;
import com.igt.vo.FaQ;

public class FaQWriteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fTitle = request.getParameter("fTitle");
		String fContent = request.getParameter("fContent");
		
		FaQ f = new FaQ();
		f.setfTitle(fTitle);
		f.setfContent(fContent);
		
		FaQDao dao = new FaQDao();
		dao.insertFaQ(f);
		
		return "r:fnq.mvc";
	}

}
