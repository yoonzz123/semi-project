package com.igt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.igt.dao.ProductDao;
import com.igt.vo.Product;

public class ProductWriteService implements CommandProcess {

	@Override
	public String requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		String uploadDir = 
				(String) request.getServletContext().getAttribute("uploadDir");
		String realPath = request.getServletContext().getRealPath(uploadDir);
		
		int maxFileSize = 100 * 1024 * 1024;
		
		String encoding = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, realPath,
				maxFileSize, encoding, new DefaultFileRenamePolicy());
		
		// 상품명 가격 종류 이미지 상세정보 등록일
		String pName = multi.getParameter("pName");
		Integer pPrice = Integer.parseInt(multi.getParameter("pPrice"));
		String pType = multi.getParameter("pType");
		String pDetail = multi.getParameter("pDetail");
		
		Product product = new Product();
		product.setpName(pName);
		product.setpPrice(pPrice);
		product.setpType(pType);
		product.setpDetail(pDetail);
		
		String fileName = multi.getFilesystemName("pImg");
		System.out.println("파일명 : " + fileName);
		
		product.setpImg(fileName != null ?  fileName : null);
		
		if(product.getpImg() == null) {
			System.out.println("파일이 업로드 되지 않음");
		}
		
		ProductDao dao = new ProductDao();
		dao.insertProduct(product);
		
		return "r:pList.mvc";
	}

}
