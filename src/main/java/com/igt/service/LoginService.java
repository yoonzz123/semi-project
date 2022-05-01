package com.igt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.MemberDao;

public class LoginService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id = request.getParameter("loginId");
		String pass = request.getParameter("loginPw");
		
		MemberDao dao = new MemberDao();
		int result = dao.loginMember(id, pass);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		if(result == -1) {
			out.println("<script>");
			out.println(" alert('해당 id가 존재하지 않습니다.')");
			out.println(" window.history.back()");
			out.println("</script>");
			return null;
		} else if(result == 0) {
			out.println("<script>");
			out.println(" alert('비밀번호가 맞지 않습니다.')");
			out.println(" window.history.back()");
			out.println("</script>");
			return null;
		} else if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("isLogin", true);
		}
		return "r:index.mvc";
	}

}
