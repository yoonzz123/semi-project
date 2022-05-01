package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.MemberDao;

public class MemberDeleteService implements CommandProcess {

	@Override
	public String requestProcess(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("id");
		
		MemberDao dao = new MemberDao();
		dao.deleteMember(mId);
		
		session.invalidate();
		
		return "r:index.mvc";
	}

}
