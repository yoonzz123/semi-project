package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;
import com.igt.vo.Member;

public class PassProcessService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		Member member = dao.passMember(name,id);
		boolean member1 = dao.idCheck(name,id);
		
		
		request.setAttribute("member", member);
		request.setAttribute("name", name);
		request.setAttribute("member1", member1);
		
		System.out.println(member);
		
		return "f:/WEB-INF/id.passCheck/passProcess.jsp";
	}

}
