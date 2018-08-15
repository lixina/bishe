package com.etc.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.GoodsmsgDao;
import com.etc.dao.ImageDao;
import com.etc.entity.Goodsmsg;
import com.etc.entity.Image;
import com.etc.service.GoodsmsgService;

@Service
public class GoodsmsgServiceImpl implements GoodsmsgService{
	@Resource
    private GoodsmsgDao gd;
	@Resource
	private ImageDao imgd;
	
	public List<Goodsmsg> getAllGoodsmsg() {
		// 获取所有商品信息
		return gd.getAllGoodsmsg();
	}
	
	public List<Goodsmsg> getGoodsByType(String goodstype) {
		// 根据商品类型获取商品信息
		List<Goodsmsg> list = gd.getGoodsByType(goodstype);// 没有图片
		List<Goodsmsg> listmsg = new ArrayList<Goodsmsg>();
		for(Goodsmsg goodsmsg:list){
			Goodsmsg goods = goodsmsg;
			int id = goods.getId();
		    int imagetype = 0;
			Image image = imgd.getImage(id,imagetype);
			goods.setImage(image);
			listmsg.add(goods);
		}
		return listmsg;
	}
	
	public List<Goodsmsg> getgoodsbyname(String goodsname) {
		// 根据商品名称模糊查询
		List<Goodsmsg> list = gd.getgoodsbyname(goodsname);
		List<Goodsmsg> listmsg = new ArrayList<Goodsmsg>();
		for(Goodsmsg goodsmsg:list){
			Goodsmsg goods = goodsmsg;
			int id = goods.getId();
		    int imagetype = 0;
			Image image = imgd.getImage(id,imagetype);
			goods.setImage(image);
			listmsg.add(goods);
		}
		return listmsg;
	}
	
	public Goodsmsg getgoodsbyid(int goodsid) {
		// 根据goodsid查询商品信息（商品显示页）
		return gd.getGoodsById(goodsid);
	}
}
