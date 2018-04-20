package com.etc.entity;

public class Goodsmsg {
 private int id;
 private String goodsname;
 private int goodscount;
 private double goodsprice;
 private String goodstype;
 private Image Image;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGoodsname() {
	return goodsname;
}
public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}
public int getGoodscount() {
	return goodscount;
}
public void setGoodscount(int goodscount) {
	this.goodscount = goodscount;
}
public double getGoodsprice() {
	return goodsprice;
}
public void setGoodsprice(double goodsprice) {
	this.goodsprice = goodsprice;
}
public String getGoodstype() {
	return goodstype;
}
public void setGoodstype(String goodstype) {
	this.goodstype = goodstype;
}
public Image getImage() {
	return Image;
}
public void setImage(Image image) {
	Image = image;
}
public Goodsmsg() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Goodsmsg [id=" + id + ", goodsname=" + goodsname + ", goodscount="
			+ goodscount + ", goodsprice=" + goodsprice + ", goodstype="
			+ goodstype + ", Image=" + Image + "]";
}

}