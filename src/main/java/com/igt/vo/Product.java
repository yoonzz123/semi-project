package com.igt.vo;

import java.sql.Timestamp;

public class Product {
	
	private int pNo;
	private String pName;
	private String pType;
	private int pPrice;
	private String pImg;
	private String pDetail;
	private Timestamp pRdate;
	private int cQTY;
	
	public Product() {}
	public Product(int pNo, String pName, String pType, int pPrice, 
			String pImg, String pDetail, String pRdate, int cQTY) {
		this.pNo = pNo;
		this.pName = pName;
		this.pType = pType;
		this.pPrice = pPrice;
		this.pImg = pImg;
		this.pDetail = pDetail;
		this.cQTY = cQTY;
	}
	
	public Timestamp getpRdate() {
		return pRdate;
	}
	public void setpRdate(Timestamp pRdate) {
		this.pRdate = pRdate;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getpDetail() {
		return pDetail;
	}
	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}
	public int getcQTY() {
		return cQTY;
	}
	public void setcQTY(int cQTY) {
		this.cQTY = cQTY;
	}
}
