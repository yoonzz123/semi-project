package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.Product;


public class ProductDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 검색어 호출
	public int getProductCount(String type, String keyword) {

		// select count(*) from product0 where pName like '%바지%';

		String sqlCount = "select count(*) from product0 where "
				+ type + " like ?";

		int count = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sqlCount);
			pstmt.setString(1, "%" + keyword + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	// 이름, 종류 에서 검색어가 포함된 상품 호출

	public ArrayList<Product> searchList(String type, String keyword, int startRow, int endRow) {

		String sqlSearchList = "select * from (select rownum num, "
				+ "pNo, pImg, pName, pType, pPrice from "
				+ "(select * from product0 where " + type + " like ? "
				+ "order by pNo desc)) where num >= ? and num <= ?";

		ArrayList<Product> productList = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sqlSearchList);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rs = pstmt.executeQuery();

			productList = new ArrayList<Product>();

			while (rs.next()) {
				Product product = new Product();
				product.setpNo(rs.getInt("pNo"));
				product.setpName(rs.getString("pName"));
				product.setpImg(rs.getString("pImg"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpType(rs.getString("pType"));

				productList.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	//상품삭제
	public void deleteProduct(int pNo) {
		String product0Delete ="DELETE FROM PRODUCT0 WHERE pNo=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(product0Delete);
			pstmt.setInt(1, pNo);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
			
		}
	}
	
	
	public ArrayList<Product> productList(int startRow, int endRow) {

		String sqlProductList = "select * from (select rownum num, "
				+ "pNo,pImg, pName, pType, pPrice from (select * from product0 "
				+ "order by pNo desc)) where num >= ? and num <= ?";

		ArrayList<Product> pList = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sqlProductList);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			
				pList = new ArrayList<Product>();

				while (rs.next()) {
					Product product = new Product();

					product.setpNo(rs.getInt("pNo"));
					product.setpImg(rs.getString("pImg"));
					product.setpName(rs.getString("pName"));
					product.setpType(rs.getString("pType"));
					product.setpPrice(rs.getInt("pPrice"));

					pList.add(product);
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pList;
	}
	
	// 제품 목록
	public ArrayList<Product> productList() {
		// TODO Auto-generated method stub

		
		String sqlList = "select * from product0 order by pNo desc";
		ArrayList<Product> productList = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sqlList);
			rs = pstmt.executeQuery();

			productList = new ArrayList<Product>();

			while (rs.next()) {
				Product pList = new Product();

				pList.setpImg(rs.getString("pImg"));
				pList.setpName(rs.getString("pName"));
				pList.setpType(rs.getString("pType"));
				pList.setpPrice(rs.getInt("pPrice"));

				productList.add(pList);
			}

			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	public int getProductCount() {

		String sqlCount = "select count(*) from product0";
		int count = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sqlCount);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	// 제품 상세정보
	public Product getProduct(int pNo) {
		String productSql = "select * from product0 where pNo=?";

		Product product = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(productSql);
			pstmt.setInt(1, pNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				product = new Product();
				product.setpNo(rs.getInt("pNo"));
				product.setpName(rs.getString("pName"));
				product.setpType(rs.getString("pType"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImg(rs.getString("pImg"));
				product.setpDetail(rs.getString("pDetail"));
				product.setpRdate(rs.getTimestamp("pRdate"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return product;
	}

	// 상품 등록하기
	public void insertProduct(Product product) {
		String sqlInsert = "insert into product0(pNo, pName, pType, pPrice, pImg, pDetail, pRdate) "
				+ "values(product0_seq.nextval,?,?,?,?,?, '2022-01-31')";

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sqlInsert);

			pstmt.setString(1, product.getpName());
			pstmt.setString(2, product.getpType());
			pstmt.setInt(3, product.getpPrice());
			pstmt.setString(4, product.getpImg());
			pstmt.setString(5, product.getpDetail());

			

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	//타입별 상품 불러오기
	public ArrayList<Product> productList(String pType) {
		String SQL = "SELECT * FROM product0 WHERE pType = ?";
		ArrayList<Product> pList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, pType);
			rs = pstmt.executeQuery(); 
			
			pList = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product();
				p.setpNo(rs.getInt("pNo"));
				p.setpName(rs.getString("pName"));
				p.setpType(rs.getString("pType"));
				p.setpPrice(rs.getInt("pPrice"));
				p.setpImg(rs.getString("pImg"));
				p.setpDetail(rs.getString("pDetail"));
				p.setpRdate(rs.getTimestamp("pRDate"));
				pList.add(p);
			}
			return pList;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pList;
	}
	// 오더 상품리스트
	public ArrayList<Product> getOrderProduct(int pNo) {
		String getpListSql = "SELECT * FROM product0 WHERE pno=?";
		ArrayList<Product> pList = new ArrayList<Product>();
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getpListSql);
			pstmt.setInt(1, pNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Product p = new Product();
				p.setpName(rs.getString("pName"));
				p.setpType(rs.getString("pType"));
				p.setpPrice(rs.getInt("pPrice"));
				p.setpImg(rs.getString("pImg"));
				p.setpNo(rs.getInt("pNo"));
				
				pList.add(p);
			}
		} catch(SQLException e) {
			System.out.println("OrdersDao - getOrderProduct()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pList;
	}

	// 카트 상품리스트
	public Product getCartProduct(String mId, int pNo) {
		String getpListSql = "SELECT * FROM cart0 c JOIN product0 p ON c.pNo = p.pNo WHERE c.mID=? and p.pNo=?";
		Product p = new Product();
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getpListSql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, pNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				p.setpName(rs.getString("pName"));
				p.setpType(rs.getString("pType"));
				p.setpPrice(rs.getInt("pPrice"));
				p.setcQTY(rs.getInt("cQTY"));
				p.setpImg(rs.getString("pImg"));
				p.setpNo(rs.getInt("pNo"));
				
			}
		} catch(SQLException e) {
			System.out.println("OrdersDao - getProduct()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return p;
	}
}

