package com.etc.entity;

public class Goodscar {
   private int goodscarid;
   private int goodsid;
   private int goodscount;
   private String username;
   private String goodsname;
   private double totalprice;
   private double goodsprice;

   public int getGoodscarid() {
	return goodscarid;
}

public void setGoodscarid(int goodscarid) {
	this.goodscarid = goodscarid;
}

public int getGoodsid() {
	return goodsid;
}

public void setGoodsid(int goodsid) {
	this.goodsid = goodsid;
}

public int getGoodscount() {
	return goodscount;
}

public void setGoodscount(int goodscount) {
	this.goodscount = goodscount;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getGoodsname() {
	return goodsname;
}

public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}

public double getTotalprice() {
	return totalprice;
}

public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}

public double getGoodsprice() {
	return goodsprice;
}

public void setGoodsprice(double goodsprice) {
	this.goodsprice = goodsprice;
}
public Goodscar() {
}
@Override
public String toString() {
	return "Goodscar [goodscarid=" + goodscarid + ", goodsid=" + goodsid
			+ ", goodscount=" + goodscount + ", username=" + username
			+ ", goodsname=" + goodsname + ", totalprice=" + totalprice
			+ ", goodsprice=" + goodsprice + "]";
}

}
