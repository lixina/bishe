package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Goodsmsg;

public  interface GoodsmsgDao{
	// 查询所有商品
	public List<Goodsmsg> getAllGoodsmsg();
	
	// 根据类型查询商品
	public List<Goodsmsg> getGoodsByType(String goodstype);
	
	// 根据商品名称模糊查询商品
	public List<Goodsmsg> getgoodsbyname(@Param("goodsname")String goodsname);
	
	// 根据goodsid查询商品信息（商品显示页）
	public Goodsmsg getGoodsById(@Param("goodsid")int goodsid);
}
