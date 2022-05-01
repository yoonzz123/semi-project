package com.igt.vo;

import java.sql.Timestamp;

public class Member {
	private String mId;
	private String mPw;
	private String mName;
	private int mPost;
	private String mAdd;
	private String mAdd2;
	private String mPhone;
	private String mEmail;
	private Timestamp mRDate;
	
	public Member() {}
	public Member(String mId, String mPw, String mName, int mPost, 
			String mAdd, String mAdd2, String mPhone, String mEmail, Timestamp mRDate) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mPost = mPost;
		this.mAdd = mAdd;
		this.mAdd2 = mAdd2;
		this.mPhone = mPhone;
		this.mEmail = mEmail;
		this.mRDate = mRDate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmPost() {
		return mPost;
	}
	public void setmPost(int mPost) {
		this.mPost = mPost;
	}
	public String getmAdd() {
		return mAdd;
	}
	public void setmAdd(String mAdd) {
		this.mAdd = mAdd;
	}
	public String getmAdd2() {
		return mAdd2;
	}
	public void setmAdd2(String mAdd2) {
		this.mAdd2 = mAdd2;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public Timestamp getmRDate() {
		return mRDate;
	}
	public void setmRDate(Timestamp mRDate) {
		this.mRDate = mRDate;
	}
	
	
}
