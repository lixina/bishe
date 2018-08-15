package com.etc.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.GoodscarDao;
import com.etc.entity.Goodscar;
import com.etc.service.GoodscarService;
/**
 * 购物车
 * @author Administrator
 *
 */
@Service
public class GoodscarServiceImpl implements GoodscarService{
	
	@Resource
	private GoodscarDao gd;
	
	public boolean addtogoodscar(int goodsid, String goodsname,double goodsprice, double totalprice, String username) {
		// 向购物车中添加
		boolean re = gd.addtogoodscar(goodsid, goodsname, goodsprice, totalprice, username);
		return re;
	}
	
	public List<Goodscar> showgoodscar(String username) {
		// 根据userid查找购物车中的东西
	List<Goodscar> list = gd.showgoodscar(username);
		return list;
	}
	
	public boolean delgoodscar(int goodscarid) {
		// 根据goodscarid删除goodscar
		boolean re = gd.delgoodscar(goodscarid);
		return re;
	}
	
	public boolean updategoodscar(int goodscarid, int goodscount) {
		// 根据goodscarid修改goodscount
		boolean re = gd.updategoodscar(goodscarid, goodscount);
		return re;
	}
	
	public boolean isexits(int goodsid, String username) {
		// 加入购物车时判断
		boolean re = gd.isexits(goodsid, username);
		return re;
	}
	
	public Goodscar selectgoodscar(int goodscarid) {
		// 根据goodscarid查询goodscar中的内容
		Goodscar goodscar = gd.selectgoodscar(goodscarid);
		return goodscar;
	}
}
