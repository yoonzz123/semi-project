package com.igt.dao;

import java.sql.*;
import java.util.ArrayList;

import com.igt.vo.Notice;


public class NoticeDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public ArrayList<Notice> getNoticeList(){
		
		String Noticesql = "select * from notice0 order by nNo desc ";
		ArrayList<Notice> getNoticeList = null;
		
		try {
			
			conn =DBManager.getConnection();
			pstmt = conn.prepareStatement(Noticesql);
			rs = pstmt.executeQuery();
			
			getNoticeList = new ArrayList<Notice>();
			
			while(rs.next()) {
				Notice nList = new Notice();
				
				nList.setnNo(rs.getInt("nNo"));
				nList.setnTitle(rs.getString("nTitle"));
				nList.setnContent(rs.getString("nContent"));
				nList.setnRdate(rs.getTimestamp("nRdate"));
				
				getNoticeList.add(nList);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("getNoticeList");
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return getNoticeList;
	} //end getNoticeList
	
	public void insertNotice(String nTitle, String nContent) {
		String insertSql = "INSERT INTO notice0(nNo,nTitle,nContent,nRdate) values "
				+ "(notice0_seq.nextval,?,?,sysdate)";
		
		
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(insertSql);
			
			pstmt.setString(1, nTitle);
			pstmt.setString(2, nContent);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("NoticeInsert");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
	}
	

	public Notice getNotice(int nNo) {
		String noticeGetSql = "SELECT * FROM notice0 where nNo=?";
		
		Notice notice = null;
		
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(noticeGetSql);
		pstmt.setInt(1, nNo);
		rs = pstmt.executeQuery();
	
		if(rs.next()) {
			notice = new Notice();
			notice.setnNo(rs.getInt("nNo"));
			notice.setnContent(rs.getString("nContent"));
			notice.setnTitle(rs.getString("nTitle"));
			notice.setnRdate(rs.getTimestamp("nRdate"));

		}			
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn, pstmt, rs);
	}
	
	return notice;
	}

	public void deleteNotice(int nNo) {
		String noticeDelete ="DELETE FROM notice0 WHERE nNo=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(noticeDelete);
			pstmt.setInt(1, nNo);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
			
		}
	}// end delete

}
