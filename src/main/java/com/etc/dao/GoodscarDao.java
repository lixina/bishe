package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Goodscar;

public interface GoodscarDao {
	// 插入订单信息
	public boolean addtogoodscar(@Param("goodsid") int goodsid,
			@Param("goodsname") String goodsname,
			@Param("goodsprice") double goodsprice,
			@Param("totalprice") double totalprice, @Param("username") String username);

	// 根据用户名查找显示订单信息
	public List<Goodscar> showgoodscar(@Param("username") String username);
	//根据goodscarid删除
	public boolean delgoodscar(int goodscarid);
	//根据goodscarid修改goodscount
	public boolean updategoodscar(@Param("goodscarid")int goodscarid,@Param("goodscount")int goodscount);
	//加入购物车前判断是否已经存在该商品
	public boolean isexits(@Param("goodsid")int goodsid,@Param("username")String username); 
	//根据goodscarid查询goodscar中的内容
	public Goodscar selectgoodscar(int goodscarid);
}
