package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.ReviewDao;
import com.igt.vo.Review;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewUpdateService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uploadDir = 
				(String) request.getServletContext().getAttribute("uploadDir");
		String realPath = request.getServletContext().getRealPath(uploadDir);		
		
		int maxFileSize = 100 * 1024 * 1024;
		String encoding = "UTF-8"; 
		
		MultipartRequest multi = new MultipartRequest(request, realPath, 
				maxFileSize, encoding, new DefaultFileRenamePolicy());	
		
		int rNo = Integer.parseInt(multi.getParameter("rNo"));
		int pNo = Integer.parseInt(multi.getParameter("pNo"));
		String rTitle = multi.getParameter("rTitle");
		String rContent = multi.getParameter("rContent");
		String rImg = multi.getFilesystemName("rImg");
		
		Review r = new Review();
		r.setrNo(rNo);
		r.setrTitle(rTitle);
		r.setrContent(rContent);
		r.setrImg(rImg);
		
		ReviewDao dao = new ReviewDao();
		dao.updateReview(r);
		
		return "r:pDetail.mvc?pNo=" + pNo;
	}

}
