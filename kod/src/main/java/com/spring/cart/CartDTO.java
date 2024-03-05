package com.spring.cart;

public class CartDTO {
	private int cartID;
	private int cartProductCnt;
	private String memberID;
	private int productID;

	private String productName;
	private int productPrice;
	private String productImg;
	private int sumProductPrice;
	private String pg;
	private int payCk; // 결제 방식 : 바로 구매 / 선택 구매

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getCartProductCnt() {
		return cartProductCnt;
	}

	public void setCartProductCnt(int cartProductCnt) {
		this.cartProductCnt = cartProductCnt;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getSumProductPrice() {
		return sumProductPrice;
	}

	public void setSumProductPrice(int sumProductPrice) {
		this.sumProductPrice = sumProductPrice;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public int getPayCk() {
		return payCk;
	}

	public void setPayCk(int payCk) {
		this.payCk = payCk;
	}

	@Override
	public String toString() {
		return "CartDTO [cartID=" + cartID + ", cartProductCnt=" + cartProductCnt + ", memberID=" + memberID
				+ ", productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImg=" + productImg + ", sumProductPrice=" + sumProductPrice + ", pg=" + pg + ", payCk="
				+ payCk + "]";
	}

}
