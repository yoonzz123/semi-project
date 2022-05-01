package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;
import com.igt.vo.Member;

public class NameProcessService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String name = request.getParameter("name");
			
			MemberDao dao = new MemberDao();
			Member member =  dao.getMember(name);
			boolean member1 = dao.idCheck(name);
			
			
			request.setAttribute("member", member);
			request.setAttribute("name", name);
			request.setAttribute("member1", member1);
			
		return "f:/WEB-INF/id.passCheck/nameProcess.jsp";
	}

}
