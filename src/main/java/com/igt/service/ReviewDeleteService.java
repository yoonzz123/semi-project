package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.ReviewDao;

public class ReviewDeleteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		
		System.out.println(rNo);
		
		ReviewDao dao = new ReviewDao();
		dao.deleteReview(rNo);
		
		return "r:pDetail.mvc?pNo=" + pNo;
	}

}
