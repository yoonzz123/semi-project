package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;
import com.igt.vo.Member;

public class MemberUpdateService1 implements CommandProcess {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		int mpost = Integer.parseInt(request.getParameter("mpost"));
		String madd = request.getParameter("madd");
		String madd2 = request.getParameter("madd2");
		String mphone1 = request.getParameter("mphone1");
		String mphone2 = request.getParameter("mphone2");
		String mphone3 = request.getParameter("mphone3");

		String memailid = request.getParameter("memail");
		String memailDomain = request.getParameter("memailDomain");

		String mphone = (mphone1 + "-" + mphone2 + "-" + mphone3);
		String memail = (memailid + "@" + memailDomain);

		
		Member member0 = new Member(); 
		member0.setmId(mid);
		member0.setmPw(mpw);
		member0.setmName(mname);
		member0.setmPost(mpost);
		member0.setmAdd(madd); 
		member0.setmAdd2(madd2); 
		member0.setmPhone(mphone);
		member0.setmEmail(memail);

		MemberDao dao = new MemberDao();
		dao.updateMember(member0);

		return "r:index.mvc";

	}

}
