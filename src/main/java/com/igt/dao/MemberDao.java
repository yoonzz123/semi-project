package com.igt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igt.vo.Member;


public class MemberDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	// 비밀번호 검색
		public Member passMember(String mName, String mId) {
			String passSelect = "SELECT * FROM member0 WHERE mname=? and "
					+ "mid=?"; 
			Member member= null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(passSelect);
				pstmt.setString(1, mName);
				pstmt.setString(2, mId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new Member();
					member.setmId(rs.getString(1));
					member.setmPw(rs.getString(2));
					member.setmName(rs.getString(3));			
					
				}
			}catch(SQLException e) {
				
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				}catch(SQLException e) {}
			
			}
			
			
			
			return member;
		} //end  비밀번호 검색
		
		
		
		//아이디 검색
		public Member getMember(String mName) {
			String select = "SELECT * FROM member0 WHERE mname=?";
			Member member = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(select);
				pstmt.setString(1, mName);
				rs = pstmt.executeQuery();
			
				
				
				if(rs.next()) {
					member = new Member();
					member.setmId(rs.getString(1));
					member.setmPw(rs.getString(2));
					member.setmName(rs.getString(3));			
					
				}
				
				
			}catch(SQLException e) {
				System.out.println("MemberDao - getMember() : SQLException");
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				}catch(SQLException e) {}
			
			}
			return member;
			
		}// end 아이디 검색
		
	
	// Id 중복 검사
	public boolean isIdCheck(String mId) {
		
		String idCheckSql = "SELECT * FROM member0 WHERE mId=?";
		boolean result = false;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(idCheckSql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
					
		} catch (SQLException e) {
			System.out.println("MemberDao - isIdCheck()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}	
	
	// Login
	public int loginMember(String id, String pass) {
		
		String loginSql = "SELECT * FROM Member0 WHERE mId=?";
		int loginCheck = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("mPw"))){
					loginCheck = 1;
				} else {
					loginCheck = 0;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("MemberDao - loginMember");
			e.printStackTrace();	
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
				
		return loginCheck;
		
	}
	public void joinMember(Member member) {
		// id, Pw, 
		String joinSql = "INSERT INTO member0 VALUES (?,?,?,?,?,?,?,?, sysdate)";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(joinSql);
			pstmt.setString(1, member.getmId());
			pstmt.setString(2, member.getmPw());
			pstmt.setString(3, member.getmName());
			pstmt.setInt(4, member.getmPost());
			pstmt.setString(5, member.getmAdd());
			pstmt.setString(6, member.getmAdd2());
			pstmt.setString(7, member.getmPhone());
			pstmt.setString(8, member.getmEmail());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("MemberDao - joinMember()");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	} // end joinMember()
	
	//아이디 이름 회원체크
	   public boolean idCheck(String mName,String mId) {
	         
	         String idCheckSql ="SELECT * FROM member0 WHERE mname=? and "
	               + "mid=?";
	         boolean result = false;
	         
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(idCheckSql);
	            pstmt.setString(1, mName);
	            pstmt.setString(2, mId);
	            
	            rs = pstmt.executeQuery();
	            
	         if(rs.next()) {
	            result = true;
	         }
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt,rs);
	      }
	         return result;
	   }
	   
	   // 아이디 회원체크
	   public boolean idCheck(String mName) {
	      
	      String idCheckSql ="SELECT * FROM member0 WHERE mname=?";
	      boolean result = false;
	      
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(idCheckSql);
	         pstmt.setString(1, mName);
	         
	         rs = pstmt.executeQuery();
	         
	      if(rs.next()) {
	         result = true;
	      }
	   }catch(Exception e) {
	      e.printStackTrace();
	   } finally {
	      DBManager.close(conn, pstmt,rs);
	   }
	      return result;
	} // 아이디 회원체크 끝

   //관리자용 회원정보리스트 가져오기
	public ArrayList<Member> getmList() {
		String SQL = "SELECT * FROM member0";
		ArrayList<Member> mList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			mList = new ArrayList<Member>(); 
			while(rs.next()) {
				Member m = new Member();
				m.setmId(rs.getString("mId"));
				m.setmPw(rs.getString("mPw"));
				m.setmName(rs.getString("mName"));
				m.setmPost(rs.getInt("mPost"));
				m.setmAdd(rs.getString("mAdd"));
				m.setmAdd2(rs.getString("mAdd2"));
				m.setmPhone(rs.getString("mPhone"));
				m.setmEmail(rs.getString("mEmail"));
				m.setmRDate(rs.getTimestamp("mRDate"));
				mList.add(m);
			}
			return mList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return mList;
	}


	//관리자용 회원삭제
	public void deleteMember(String mId) {
		String SQL = "DELETE FROM member0 WHERE mId = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, mId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	//수정폼 가기 전에 아이디 비번 체크
		public boolean memberCheckPass(String mId, String mPw) {
			String SQL = "SELECT mPw FROM member0 WHERE mId = ?";
			boolean result = false;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, mId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(mPw.equals(rs.getString("mPw"))) {
						result = true;
					}
				}
				return result;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return result;
		}


	// 수정하기 메서드
		public void updateMember(Member member0) {
			String SQL= "update member0 SET " 
					+ "mpw=?,"
					+ "mname=?,"
					+ "mpost= ?,"
					+ "madd =?,"
					+ "madd2 =?,"
					+ "mphone=?,"
					+ "mEmail=? "
					+ "WHERE mid=?" ;
	       
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, member0.getmPw());
				pstmt.setString(2, member0.getmName());
				pstmt.setInt(3, member0.getmPost());
				pstmt.setString(4, member0.getmAdd());
				pstmt.setString(5, member0.getmAdd2());
				pstmt.setString(6, member0.getmPhone());
				pstmt.setString(7, member0.getmEmail());
				pstmt.setString(8, member0.getmId());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		//폼에뿌릴 아이디 정보 가져오기
		public Member getMemberInfo(String mId) {
			String select = "SELECT * FROM member0 WHERE mId=?";
			Member member = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(select);
				pstmt.setString(1, mId);
				rs = pstmt.executeQuery();
			
				
				
				if(rs.next()) {
					member = new Member();
					member.setmId(rs.getString("mid"));
					member.setmPw(rs.getString("mpw"));
					member.setmName(rs.getString("mname"));			
					member.setmPost(rs.getInt("mpost"));			
					member.setmAdd(rs.getString("madd"));			
					member.setmAdd2(rs.getString("madd2"));			
					member.setmPhone(rs.getString("mphone"));			
					member.setmEmail(rs.getString("memail"));
					member.setmRDate(rs.getTimestamp("mrdate"));
					
					
				}
				return member;
				
			}catch(SQLException e) {
				System.out.println("MemberDao - getMember() : SQLException");
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				}catch(SQLException e) {}
			
			}
			return member;
			
		}
		
	}
	
	
	

