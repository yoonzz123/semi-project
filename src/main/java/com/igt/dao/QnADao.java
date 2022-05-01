package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.QnA;
import com.igt.vo.QnA_Reply;

public class QnADao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int getQnACount() {
		String QnACountSql = "SELECT count(*) FROM QnA0";
		int count = 0;
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(QnACountSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("QnADao - getQnACount()");
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int getQnA_ReplyCount() {
		String QnACountSql = "SELECT count(*) FROM QnA_Reply0";
		int count = 0;
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(QnACountSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("QnADao - getQnACount()");
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	} // end getQnA_ReplyCount();
	
	
	public ArrayList<QnA> getQnAList(){
		
		String getQnAListSql = "SELECT q.*, QnA_Reply0.qrTitle FROM QnA0 q left outer join QnA_Reply0 on q.qNo=QnA_Reply0.qNo";
		
		ArrayList<QnA> QnAList = new ArrayList<QnA>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getQnAListSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				QnA qna = new QnA();
				qna.setqNo(rs.getInt(1));
				qna.setqTitle(rs.getString(3));
				qna.setmId(rs.getString(2));
				qna.setqRDate(rs.getTimestamp(5));
				qna.setQrTitle(rs.getString(6));
				
				QnAList.add(qna);
			}
		} catch (SQLException e) {
			System.out.println("QnADao - getQnAList()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return QnAList;
	} // end getQnAList()
	
	public QnA getQnA(int qNo) {
		
		String getQnASql = "SELECT * FROM QnA0 WHERE qNo=?";
		QnA qna = new QnA();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(getQnASql);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qna.setqNo(rs.getInt(1));
				qna.setmId(rs.getString(2));
				qna.setqTitle(rs.getString(3));
				qna.setqContent(rs.getString(4));
				qna.setqRDate(rs.getTimestamp(5));
			}			
		} catch (Exception e) {
			System.out.println("QnADao - getQnA(int qNo)");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qna;	
	} // end getQnA()
	
	public QnA_Reply getQnA_Reply(int qNo) {
		
		String QnA_ReplySql = "SELECT * FROM QnA_Reply0 WHERE qNo=?";
		QnA_Reply reply = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(QnA_ReplySql);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				reply = new QnA_Reply();
				reply.setQrContent(rs.getString(4));
			}
			
		} catch (Exception e) {
			System.out.println("QnADao - getQnA_Reply");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reply;
		
	} // end getQnA_Reply(int qNo)
	
	public void insertQnA(int count, String mid, String qTitle, String qContent) {
		
		String insertQnASql = "INSERT INTO QnA0 VALUES (?, ?, ?, ?, sysdate)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insertQnASql);
			pstmt.setInt(1, count);
			pstmt.setString(2, mid);
			pstmt.setString(3, qTitle);
			pstmt.setString(4, qContent);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("QnADao - insertQnA()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}// end insertQnA(int count, String mid, String qTitle, String qContent)
	
	public void insertQnA_Reply(int qrNo, int qNo, String qrContent) {
		
		String insertSql = "INSERT INTO QnA_Reply0 VALUES (?, ?, '답변완료', ?, sysdate)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1, qrNo);
			pstmt.setInt(2, qNo);
			pstmt.setString(3, qrContent);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("QnADao - insertQnA_Reply()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}		
	} // end insertQnA_Reply(int qrNo, int qNo, String qrContent)
	
	public QnA_Reply updateQnA_Reply(int qNo, String qrContent) {
		QnA_Reply reply = new QnA_Reply();
		String updateSql = "UPDATE QnA_Reply0 SET qrContent = ? WHERE qNo=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setString(1, qrContent);
			pstmt.setInt(2, qNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				reply.setQrContent(rs.getString(qrContent));
			}
			
		} catch(Exception e) {
			System.out.println("QnADao - updateQnA_Reply()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return reply;
	} // updateQnA_Reply(int qNo, String qrContent)
	
	
	
	
}
