package com.igt.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igt.service.*;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String PREFIX = "/WEB-INF/index.jsp?body=";
	private final String SUFFIX = ".jsp";
	
	public void init() throws ServletException {
		
		ServletContext sc = getServletContext();
		String uploadDir = sc.getInitParameter("uploadDir");
		String realPath = sc.getRealPath(uploadDir);
		File parentFile = new File(realPath);
		
		if(! (parentFile.exists() && parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		
		sc.setAttribute("uploadDir", uploadDir);
		sc.setAttribute("parentFile", parentFile);
	}
	
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
		System.out.println("바뀌나요?");
	}
	public void doProcess(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		CommandProcess service = null;
		String viewPage = null;
		
		
		
		if(command.equals("/*.mvc")	|| command.equals("/index.mvc")) {
			service = new MainService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/joinInfo.mvc")) {
			service = new JoinResultService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/join.mvc")) {
			service = new JoinService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/loginForm.mvc")) {
			service = new LoginFormService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/login.mvc")) {
			service = new LoginService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/logout.mvc")) {
			service = new LogoutService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/pList.mvc")) {
			service = new ProductListService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/writeForm.mvc")) {
			service = new ProductWriteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/pDetail.mvc")) {
			service = new ProductDetailService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/rWrite.mvc")) {
			service = new ReviewWriteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/pDetail.mvc")) {
			service = new ProductDetailService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/qnaList.mvc")) {
			service = new QnAListService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/qnaDetail.mvc")) {
			service = new QnADetailService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/pWriteForm.mvc")) {
			viewPage = "product/pWrite";
		} else if(command.equals("/pWrite.mvc")) {
			service = new ProductWriteService();
			viewPage = service.requestProcess(request,response);
		}else if(command.equals("/fnq.mvc")) {
			service = new FnQListService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/qnaWriteForm.mvc")) {
			service = new QnAWriteFormService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/qnaInfo.mvc")) {
			service = new QnAWriteResultService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/cart.mvc")) {
			service = new CartService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/cartDelete.mvc")) {
			service = new CartDeleteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/cartOrder.mvc")) {
			service = new CartOrderFormService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/order.mvc")) {
			service = new OrderService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/update.mvc")) {
			service = new UpdateService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/nameCheck.mvc")) {
			service = new NameCheckService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/nameProcess.mvc")) {
			service = new NameProcessService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/passCheck.mvc")) {
			service = new PassCheckService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/passProcess.mvc")) {
			service = new PassProcessService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/deleteProcess.mvc")) {
			service = new ListDeleteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/nowOrderForm.mvc")) {
			service = new NowOrderFormService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/orderInsert.mvc")) {
			service = new OrderInsertService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/rDelete.mvc")) {
			service = new ReviewDeleteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/rUpdate.mvc")) {
			service = new ReviewUpdateService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/orderAdmin.mvc")) {
			service = new OrderAdminService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/orderAdmin.mvc")) {
			service = new OrderAdminService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/fDelete.mvc")) {
			service = new FaQDeleteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/fWriteForm.mvc")) {
			service = new FaQWriteFormService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/FaQWriteService.mvc")) {
			service = new FaQWriteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/memberAdmin.mvc")) {
			service = new MemberAdmainService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/mAdminDelete.mvc")) {
			service = new MemberAdminDeleteService();
			viewPage = service.requestProcess(request,response);
		}else if(command.equals("/noticeForm.mvc")) {
			service = new NoticeList();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/noticeDetail.mvc")) {
			service = new NoticeDetailService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/noticeDeleteProcess.mvc")) {
			service = new NoticeDeleteProcess();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/noticeWriteForm.mvc")) {
			viewPage ="notice/noticeWrite";
		} else if(command.equals("/nWrite.mvc")) {
			service = new NoticeWriteService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/pListType.mvc")) {
			service = new ProductListTypeService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/game.mvc")) {
			service = new GameService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/Universe.mvc")) {
			viewPage = "Universe/universe";
		} else if(command.equals("/report.mvc")) {
			viewPage = "f:/WEB-INF/report/report.jsp";
		}	else if(command.equals("/memberUpdateForm.mvc")) {
			service = new MemberUpdateFormService();
			viewPage = service.requestProcess(request,response);
		} else if(command.equals("/MemberUpdateCheckForm.mvc")) {
			service = new MemberCheckFormService();
			viewPage = service.requestProcess(request, response);
		} else if(command.equals("/memberUpdateS.mvc")) {
			service = new MemberUpdateService1();
			viewPage = service.requestProcess(request,response);
		}	else if(command.equals("/memberDelete.mvc")) {
			service = new MemberDeleteService();
			viewPage = service.requestProcess(request,response);
		}	
		
		if(viewPage != null) {
			
			String view = viewPage.split(":")[0];
			
			if(view.equals("r") || view.equals("redirect")) {
				response.sendRedirect(viewPage.split(":")[1]);
				
			} else if(view.equals("f") || view.equals("forward")) {
				RequestDispatcher rd = 
						request.getRequestDispatcher(viewPage.split(":")[1]);	
				rd.forward(request, response);
				
			} else { 
				RequestDispatcher rd = 
						request.getRequestDispatcher(PREFIX + view + SUFFIX);	
				rd.forward(request, response);
			}
		}
	}
}
