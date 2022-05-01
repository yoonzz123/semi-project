package com.igt.vo;

import java.sql.Timestamp;

public class Orders {
	
	private int oNo;
	private String mId;
	private Timestamp oRdate;
	private String oName;
	private String oPhone;
	private String oAdd;
	private String oAdd2;
	private int oPost;
	private int oPrice;
	private int oState;
	private int oPay;
	
	public int getoNo() {
		return oNo;
	}
	public void setoNo(int oNo) {
		this.oNo = oNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public Timestamp getoRdate() {
		return oRdate;
	}
	public void setoRdate(Timestamp oRdate) {
		this.oRdate = oRdate;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getoPhone() {
		return oPhone;
	}
	public void setoPhone(String oPhone) {
		this.oPhone = oPhone;
	}
	public String getoAdd() {
		return oAdd;
	}
	public void setoAdd(String oAdd) {
		this.oAdd = oAdd;
	}
	public String getoAdd2() {
		return oAdd2;
	}
	public void setoAdd2(String oAdd2) {
		this.oAdd2 = oAdd2;
	}
	public int getoPost() {
		return oPost;
	}
	public void setoPost(int oPost) {
		this.oPost = oPost;
	}
	public int getoPrice() {
		return oPrice;
	}
	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}
	public int getoState() {
		return oState;
	}
	public void setoState(int oState) {
		this.oState = oState;
	}
	public int getoPay() {
		return oPay;
	}
	public void setoPay(int oPay) {
		this.oPay = oPay;
	}
	
}
