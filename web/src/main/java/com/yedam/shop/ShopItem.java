package com.yedam.shop;

public class ShopItem {
	
	private String itemCode;
	private String itemName;
	private String itemDesc;
	private int originPrice;
	private int salePrice;
	private double likeIt;
	private String image;
	
	public ShopItem(String itemCode, String itemName, String itemDesc, int originPrice, int salePrice, double likeIt,
			String image) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.originPrice = originPrice;
		this.salePrice = salePrice;
		this.likeIt = likeIt;
		this.image = image;
	}
	
	public ShopItem() {
		
	}

	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public double getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(double likeIt) {
		this.likeIt = likeIt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "ShopItem [itemCode=" + itemCode + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", originPrice="
				+ originPrice + ", salePrice=" + salePrice + ", likeIt=" + likeIt + ", image=" + image + "]";
	}
	

}
