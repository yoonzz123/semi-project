package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igt.dao.MemberDao;
import com.igt.vo.Member;

public class MemberUpdateFormService implements CommandProcess {

	@Override
	public String requestProcess(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mPw = request.getParameter("mPw");
		
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("id");
		
		MemberDao dao = new MemberDao();
		boolean result = dao.memberCheckPass(mId, mPw);
		
		if(result == true) {
			Member m = dao.getMemberInfo(mId);
			session.setAttribute("m", m);
			return "member/memberupdate";
		}
		
		
		return "r:MemberUpdateCheckForm.mvc";
	}

}
