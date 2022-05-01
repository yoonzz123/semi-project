package com.igt.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;
import com.igt.vo.Member;

public class MemberAdmainService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDao dao = new MemberDao();
		ArrayList<Member> mList = dao.getmList();
		
		request.setAttribute("mList", mList);
		
		return "member/memberAdmin";
	}

}
