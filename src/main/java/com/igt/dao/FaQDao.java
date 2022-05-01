package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.FaQ;

public class FaQDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ArrayList<FaQ> getFaQList() {
		String SQL = "SELECT * FROM FaQ0";
		ArrayList<FaQ> fList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			fList = new ArrayList<FaQ>();
			while(rs.next()) {
				FaQ f = new FaQ();
				f.setfNo(rs.getInt("fNO"));
				f.setfTitle(rs.getString("fTitle"));
				f.setfContent(rs.getString("fContent"));
				f.setfRDate(rs.getTimestamp("fRDate"));
				fList.add(f);
			}
			return fList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return fList;
	}

	public void deletef(int fNo) {
		String SQL = "DELETE FROM FaQ0 WHERE fNo = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, fNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void insertFaQ(FaQ f) {
		String SQL = "INSERT INTO FaQ0 VALUES (FaQ0_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, f.getfTitle());
			pstmt.setString(2, f.getfContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
