package com.etc.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.GoodscarDao;
import com.etc.entity.Goodscar;
import com.etc.service.GoodscarService;
/**
 * ���ﳵ
 * @author Administrator
 *
 */
@Service
public class GoodscarServiceImpl implements GoodscarService{
	
	@Resource
	private GoodscarDao gd;
	
	public boolean addtogoodscar(int goodsid, String goodsname,double goodsprice, double totalprice, String username) {
		// ���ﳵ�����
		boolean re = gd.addtogoodscar(goodsid, goodsname, goodsprice, totalprice, username);
		return re;
	}
	
	public List<Goodscar> showgoodscar(String username) {
		// ����userid���ҹ��ﳵ�еĶ���
	List<Goodscar> list = gd.showgoodscar(username);
		return list;
	}
	
	public boolean delgoodscar(int goodscarid) {
		// ����goodscaridɾ��goodscar
		boolean re = gd.delgoodscar(goodscarid);
		return re;
	}
	
	public boolean updategoodscar(int goodscarid, int goodscount) {
		// ����goodscarid�޸�goodscount
		boolean re = gd.updategoodscar(goodscarid, goodscount);
		return re;
	}
	
	public boolean isexits(int goodsid, String username) {
		// ���빺�ﳵʱ�ж�
		boolean re = gd.isexits(goodsid, username);
		return re;
	}
	
	public Goodscar selectgoodscar(int goodscarid) {
		// ����goodscarid��ѯgoodscar�е�����
		Goodscar goodscar = gd.selectgoodscar(goodscarid);
		return goodscar;
	}
}
