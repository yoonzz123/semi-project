package com.igt.ajax;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ajaxController", urlPatterns="*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//dfjiosdjfiosdjifojdsiojfioddj
	
	public void init() throws ServletException {
		//dfjoidsjifosjiosdfjifdosfsjio
		ServletContext sc = getServletContext();
		String uploadDir = sc.getInitParameter("uploadDir");
		String realPath = sc.getRealPath(uploadDir);
		File parentFile = new File(realPath);
		
		if(! (parentFile.exists() && parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		
		sc.setAttribute("uploadDir", uploadDir);
		sc.setAttribute("parentFile", parentFile);
		System.out.println("init - " + parentFile);
	}
	
	public void doAjax(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		//diwhwidhwdwdwd
		AjaxProcess ajaxAction = null;
		String command = request.getRequestURI();
		command = command.substring(request.getContextPath().length());	
		System.out.println("command : " + command);
		if(command.equals("/isIdCheck.ajax")) {
			ajaxAction = new IsIdCheckAction();
			ajaxAction.ajaxProcess(request, response);
		} else if (command.equals("/qna_reply.ajax")) {
			ajaxAction = new QnA_ReplyAction();
			ajaxAction.ajaxProcess(request, response);
		}else if (command.equals("/qna_replyUpdate.ajax")) {
			ajaxAction = new QnA_ReplyUpdateAction();
			ajaxAction.ajaxProcess(request, response);
		}else if(command.equals("/cart.ajax")) {
			ajaxAction = new CartAction();
			ajaxAction.ajaxProcess(request, response);
		}else if(command.equals("/updateStatus.ajax")) {
			ajaxAction = new UpdateStatusAction();
			ajaxAction.ajaxProcess(request, response);
		}
		
		
	}
		//wodjwdiwhdwidwd
	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		doAjax(request, response);
	}
	//dwidhiwdhwiodjwd
	@Override
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		//dwihdiwdhwidd
		doAjax(request, response);
	}
}
