package com.etc.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Myorder;

public interface MyorderDao {
	public boolean addtomyorder(@Param("orderdate")Date orderdate,
			                    @Param("orderstate")String orderstate,
			                    @Param("goodsname")String goodsname,
			                    @Param("ordertotalprice")double ordertotalprice,
			                    @Param("goodscount")int goodscount,
			                    @Param("username")String username,
			                    @Param("ordernum")int ordernum,
			                    @Param("goodsprice")double goodsprice);
	
	// 根据username查询
	public List<Myorder> selectbyname(String username);
	
	// 根据ordernum修改order
	public boolean updateoroder(int ordernum);
}
