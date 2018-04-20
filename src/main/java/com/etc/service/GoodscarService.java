package com.etc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.etc.entity.Goodscar;
public interface GoodscarService {
	 //插入订单信息
		public boolean addtogoodscar(int goodsid,String goodsname,double goodsprice,double totalprice,String username);
	   //根据用户名查找显示订单信息
		public List<Goodscar> showgoodscar(String username);
		//根据goodscarid删除goodscar
		public boolean delgoodscar(int goodscarid);
		//根据goodscarid修改goodscount
		public boolean updategoodscar(int goodscarid,int goodscount);
		//加入购物车时判断
		public boolean isexits(int goodsid,String username);
		//根据goodscarid查询goodscar中的内容
		public Goodscar selectgoodscar(int goodscarid);
}
