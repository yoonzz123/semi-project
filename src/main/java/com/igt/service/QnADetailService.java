package com.igt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.QnADao;
import com.igt.vo.QnA;
import com.igt.vo.QnA_Reply;

public class QnADetailService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		
		QnADao dao = new QnADao();
		QnA qna = dao.getQnA(qNo);
		QnA_Reply reply = dao.getQnA_Reply(qNo);
		
		String QnAId = qna.getmId();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");	
		boolean isLogin = session.getAttribute("isLogin") != null ? 
				(Boolean) session.getAttribute("isLogin") : false;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(isLogin != true) {
			out.println("<script>");
			out.println(" alert('로그인 후 이용해주세요.')");
			out.println(" location.href = 'qnaList.mvc'");
			out.println("</script>");
			return null;
		} else if(!(id.equals(QnAId)) && !(id.equals("admin"))) {
			out.println("<script>");
			out.println(" alert('QnA 읽기 권한은 글쓴이만 가능합니다.')");
			out.println(" window.history.back()");
			out.println("</script>");
			return null;
		}
		
		request.setAttribute("qna", qna);
		request.setAttribute("reply", reply);
		
		return "cscenter/qnaDetail";
	}

}
