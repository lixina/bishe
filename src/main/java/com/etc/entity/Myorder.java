package com.etc.entity;

import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;
	public class Myorder {
		private int id ;
		private Date orderdate;
		private String orderstate;
		private String goodsname;
		private Double ordertotalprice;
		private int goodscount;
		private String username;
		private int ordernum;
		private double goodsprice;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getOrderdate() {
			return orderdate;
		}
		public void setOrderdate(Date orderdate) {
			this.orderdate = orderdate;
		}
		public String getOrderstate() {
			return orderstate;
		}
		public void setOrderstate(String orderstate) {
			this.orderstate = orderstate;
		}
		public String getGoodsname() {
			return goodsname;
		}
		public void setGoodsname(String goodsname) {
			this.goodsname = goodsname;
		}
		public Double getOrdertotalprice() {
			return ordertotalprice;
		}
		public void setOrdertotalprice(Double ordertotalprice) {
			this.ordertotalprice = ordertotalprice;
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
		public int getOrdernum() {
			return ordernum;
		}
		public void setOrdernum(int ordernum) {
			this.ordernum = ordernum;
		}
		public double getGoodsprice() {
			return goodsprice;
		}
		public void setGoodsprice(double goodsprice) {
			this.goodsprice = goodsprice;
		}
	public Myorder() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Myorder [id=" + id + ", orderdate=" + orderdate
				+ ", orderstate=" + orderstate + ", goodsname=" + goodsname
				+ ", ordertotalprice=" + ordertotalprice + ", goodscount="
				+ goodscount + ", username=" + username + ", ordernum="
				+ ordernum + ", goodsprice=" + goodsprice + "]";
	}

		}

