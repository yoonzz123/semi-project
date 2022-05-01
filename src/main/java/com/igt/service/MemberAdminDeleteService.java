package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;

public class MemberAdminDeleteService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mId = request.getParameter("mId");
		
		MemberDao dao = new MemberDao();
		dao.deleteMember(mId);
		
		return "r:memberAdmin.mvc";
	}

}
