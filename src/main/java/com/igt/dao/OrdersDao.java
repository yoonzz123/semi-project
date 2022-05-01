package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.Member;
import com.igt.vo.Orders;
import com.igt.vo.Orders_detail;
import com.igt.vo.Product;

public class OrdersDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Orders getOrders(String mId) {
		
		String oedersGetsql = "select * from orders0 where mid=?";
		Orders orders= null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(oedersGetsql);
			pstmt.setString(1, mId);
			rs =pstmt.executeQuery();
		
		if(rs.next()) {
			orders = new Orders();
			
			orders.setoNo(rs.getInt("oNo"));
			orders.setmId(rs.getString("mid"));
			orders.setoRdate(rs.getTimestamp("oRdate"));
			orders.setoName(rs.getString("oName"));
			orders.setoPhone(rs.getString("oPhone"));
			orders.setoAdd(rs.getString("oPost"));
			orders.setoPrice(rs.getInt("oPrice"));
			orders.setoState(rs.getInt("ostate"));
			orders.setoPay(rs.getInt("oPay"));		
		}
			
			System.out.println(orders);
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return null;
	}
	
	// 고객 정보전달
	public Member getMember(String mId) {
		String SQL = "SELECT * FROM member0 WHERE mId = ?";
		Member member = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setmId(rs.getString("mId"));
				member.setmPw(rs.getString("mPw"));
				member.setmName(rs.getString("mName"));
				member.setmPost(rs.getInt("mPost"));
				member.setmAdd(rs.getString("mAdd"));
				member.setmAdd2(rs.getString("mAdd2"));
				member.setmPhone(rs.getString("mPhone"));
				member.setmEmail(rs.getString("mEmail"));
				member.setmRDate(rs.getTimestamp("mRDate"));
			}
			return member;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return member;
	}

	//주문 입력하고 주문번호 받아옴
	public void insertOrder(Orders orders) {
		String SQL = "INSERT INTO orders0 VALUES (orders0_seq.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?, ?, ?, 0, ?)";
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, orders.getmId());
			pstmt.setString(2, orders.getoName());
			pstmt.setString(3, orders.getoPhone());
			pstmt.setString(4, orders.getoAdd());
			pstmt.setString(5, orders.getoAdd2());
			pstmt.setInt(6, orders.getoPost());
			pstmt.setInt(7, orders.getoPrice());
			pstmt.setInt(8, orders.getoPay());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	//상세주문 입력
	public void insertOrdersDetail(Orders_detail orders_detail) {
		String SQL = "INSERT INTO orders_detail0 VALUES (orders_detail0_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, orders_detail.getpNo());
			pstmt.setInt(2, orders_detail.getoNo());
			pstmt.setInt(3, orders_detail.getOdQTY());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	//오더번호 가져오기
	public int getoNo() {
		String SQL = "SELECT orders0_seq.CURRVAL FROM DUAL";
		int oNo = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				oNo = rs.getInt(1);
			}
			
			return oNo;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return oNo;
	}

	public ArrayList<Orders> getOrderList(String mId) {
		String SQL = "SELECT * FROM orders0 WHERE mId = ?";
		ArrayList<Orders> oList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			oList = new ArrayList<Orders>();
			while(rs.next()) {
				Orders o = new Orders();
				o.setoNo(rs.getInt("oNo"));
				o.setmId(rs.getString("mId"));
				o.setoRdate(rs.getTimestamp("oRdate"));
				o.setoName(rs.getString("oName"));
				o.setoPhone(rs.getString("oPhone"));
				o.setoAdd(rs.getString("oAdd"));
				o.setoAdd2(rs.getString("oAdd2"));
				o.setoPost(rs.getInt("oPost"));
				o.setoPrice(rs.getInt("oPrice"));
				o.setoState(rs.getInt("oState"));
				o.setoPay(rs.getInt("oPay"));
				oList.add(o);
			}
			return oList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return oList;
	}

	//오더별 오더 상세 가져오기
public ArrayList<Orders> getOdList(){
		
		String sql = "SELECT * FROM Orders0";
		ArrayList<Orders> odList = new ArrayList<Orders>();
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Orders o = new Orders();
				
				o.setoNo(rs.getInt("oNo"));
				o.setmId(rs.getString("mId"));
				o.setoRdate(rs.getTimestamp("oRdate"));
				o.setoName(rs.getString("oName"));
				o.setoPhone(rs.getString("oPhone"));
				o.setoAdd(rs.getString("oAdd"));
				o.setoAdd2(rs.getString("oAdd2"));
				o.setoPost(rs.getInt("oPost"));
				o.setoPrice(rs.getInt("oPrice"));
				o.setoState(rs.getInt("oState"));
				o.setoPay(rs.getInt("oPay"));
				
				odList.add(o);
			}
			
		} catch (SQLException e) {
			System.out.println("OrdersDao - getOdList");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return odList;
	}
	
	public ArrayList<Product> getOdProductList(){
		
		String getListSql = "SELECT * FROM orders_detail0 od left JOIN product0 p ON od.pNo = p.pNo";
		ArrayList<Product> pList = new ArrayList<Product>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getListSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setpNo(rs.getInt("pNo"));
				p.setpName(rs.getString("pName"));
				p.setpType(rs.getString("ptype"));
				p.setpPrice(rs.getInt("pPrice"));
				p.setcQTY(rs.getInt("odQTY"));
				p.setpImg(rs.getString("pImg"));
				
				pList.add(p);
			}
		} catch(SQLException e) {
			System.out.println("OrdersDao - getOdProductList()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pList;
	}
	
	public void updateStatus(int oNo, int oStatus) {
		
		String updateSql = "UPDATE Orders0 SET ostate=? WHERE oNo=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setInt(1, oStatus);
			pstmt.setInt(2, oNo);
			pstmt.executeUpdate();
		} catch (Exception e){
			System.out.println("OrdersDao - updateStatus");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}
	
	public int getStatus(int oNo) {
		String getStaSql = "SELECT oStatus FROM Orders0 WHERE oNo=?";
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getStaSql);
			pstmt.setInt(1, oNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("OrdersDao - getStatus()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
}
