package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.Review;

public class ReviewDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void writeReview(Review r) {
		String rWriteSql = "INSERT INTO review0 VALUES (review0_seq.nextval, ?,?,?,?,SYSDATE, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(rWriteSql);
			pstmt.setString(1, r.getmId());
			pstmt.setInt(2, r.getpNo());
			pstmt.setString(3, r.getrTitle());
			pstmt.setString(4, r.getrContent());
			pstmt.setString(5, r.getrImg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public ArrayList<Review> rList(Integer pNo) {
		String rListSql = "SELECT * FROM review0 WHERE pNo = ?";
		ArrayList<Review> rList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(rListSql);
			pstmt.setInt(1, pNo);
			rs = pstmt.executeQuery();
			
			rList = new ArrayList<Review>();
			while(rs.next()) {
				Review r = new Review();
				r.setrNo(rs.getInt("rNo"));
				r.setmId(rs.getString("mId"));
				r.setpNo(rs.getInt("pNo"));
				r.setrTitle(rs.getString("rTitle"));
				r.setrContent(rs.getString("rContent"));
				r.setrRDate(rs.getTimestamp("rRDate"));
				r.setrImg(rs.getString("rImg"));
				rList.add(r);
			}
			return rList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return rList;
	}
	
	public void deleteReview(int rNo) {
		String SQL = "DELETE FROM review0 WHERE rNo = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, rNo);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
	}

	public void updateReview(Review r) {
		String SQL = "UPDATE review0 "
				+ "SET rTitle = ?, rContent = ?, rImg = ? "
				+ "WHERE rNo = ?";			
		String NoFileSQL = "UPDATE review0 "
				+ "SET rTitle = ?, rContent = ? "
				+ "WHERE rNo = ?";
		
		try {
			conn = DBManager.getConnection();
			
			if(r.getrImg() == null) {
				pstmt = conn.prepareStatement(NoFileSQL);
				pstmt.setString(1, r.getrTitle());
				pstmt.setString(2, r.getrContent());
				pstmt.setInt(3, r.getrNo());
				pstmt.executeUpdate();
			} else {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, r.getrTitle());
				pstmt.setString(2, r.getrContent());
				pstmt.setString(3, r.getrImg());
				pstmt.setInt(4, r.getrNo());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
}
