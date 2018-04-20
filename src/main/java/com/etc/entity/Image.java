package com.etc.entity;

public class Image {
private int id;
private String imageurl;
private int goodsid;
private int imagetype;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getImageurl() {
	return imageurl;
}
public void setImageurl(String imageurl) {
	this.imageurl = imageurl;
}
public int getGoodsid() {
	return goodsid;
}
public void setGoodsid(int goodsid) {
	this.goodsid = goodsid;
}
public int getImagetype() {
	return imagetype;
}
public void setImagetype(int imagetype) {
	this.imagetype = imagetype;
}
public Image() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Image [id=" + id + ", imageurl=" + imageurl + ", goodsid="
			+ goodsid + ", imagetype=" + imagetype + "]";
}

}
