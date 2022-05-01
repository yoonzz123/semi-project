package com.igt.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.dao.MemberDao;

public class IsIdCheckAction implements AjaxProcess {

	@Override
	public void ajaxProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("mid");
		
		MemberDao dao = new MemberDao();
		boolean IdCheck = dao.isIdCheck(id);
		String message = IdCheck + "";
		PrintWriter out = response.getWriter();
		out.write(message);	
		
	}

}
