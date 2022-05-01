package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.Product;

public class CartDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean isOverlapCheck(String id, int pNo){
		
		String overlapSql = "SELECT * FROM cart0 WHERE mid=? and pno=?";
		boolean result = false;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(overlapSql);
			pstmt.setString(1, id);
			pstmt.setInt(2, pNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("CartDao - isOverlapCheck");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	} // end isOverlapCheck(String id, int pNo)
	
	public void insertCart(int cQTY, String id, int pNo) {
		// cQTC, user, pNo
		String insertSql = "INSERT INTO cart0 values(cart0_seq.nextval, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1, cQTY);
			pstmt.setString(2, id);
			pstmt.setInt(3, pNo);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("CartDao - insertCart");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}		
	} // end insertCart(nt cQTV, String id, int pNo)
	
	public void updateCart(int cQTY, String id, int pNo) {
		// cQTC, user, pNo
		String insertSql = "UPDATE cart0 SET cQTY=cQTY + ? WHERE mid=? and pNo=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1, cQTY);
			pstmt.setString(2, id);
			pstmt.setInt(3, pNo);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("CartDao - updateCart");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}		
	} // end updateCart(nt cQTV, String id, int pNo)
	
	public ArrayList<Product> getCartList(String id){
		
		ArrayList<Product> cartList = new ArrayList<Product>();
		String getCartListSql = "SELECT c.cQTY, c.mid, p.* FROM cart0 c JOIN "
				+ "product0 p ON c.pNo = p.pNo WHERE mid=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getCartListSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product cart = new Product();
				
				cart.setpName(rs.getString("pName"));
				cart.setpPrice(rs.getInt("pPrice"));
				cart.setpNo(rs.getInt("pNo"));
				cart.setpImg(rs.getString("pImg"));
				cart.setpDetail(rs.getString("pDetail"));
				cart.setcQTY(rs.getInt("cQTY"));
				
				cartList.add(cart);
			}
		} catch (Exception e) {
			System.out.println("CartDao - getCartList()");
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return cartList;
	}
	
	// cart Delete
	public void deleteCart(String mId, int pNo) {
		String Sql = "DELETE FROM cart0 WHERE mID=? and pNo=?";
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, pNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CartDao - deleteCart()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	} // end deleteCart(String mId, int pNo)
	
}
