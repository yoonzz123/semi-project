package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;
import com.igt.vo.Member;



public class JoinResultService implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String mId = request.getParameter("mid");
		String mPw = request.getParameter("mpw");
		String mName = request.getParameter("mname");
		String mPost = request.getParameter("mpost");
		String mAdd = request.getParameter("madd");
		String mAdd2 = request.getParameter("madd2");
		String mPhone1 = request.getParameter("mphone1");
		String mPhone2 = request.getParameter("mphone2");
		String mPhone3 = request.getParameter("mphone3");
		String mEmailId = request.getParameter("memailId");
		String mEmailDomain = request.getParameter("mEmailDomain");
		
		String mPhone = mPhone1 + "-" + mPhone2 + "-" + mPhone3;
		String mEmail = mEmailId + "@" + mEmailDomain;
		
		
		Member member = new Member();
		member.setmId(mId);
		member.setmPw(mPw);
		member.setmName(mName);
		member.setmPost(Integer.parseInt(mPost));
		member.setmAdd(mAdd);
		member.setmAdd2(mAdd2);
		member.setmPhone(mPhone);
		member.setmEmail(mEmail);
		
		MemberDao dao = new MemberDao();
		dao.joinMember(member);
		
		return "r:index.mvc";
	}

}
