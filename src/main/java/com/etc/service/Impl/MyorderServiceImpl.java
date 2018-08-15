package com.etc.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.MyorderDao;
import com.etc.entity.Myorder;
import com.etc.service.MyorderService;
@Service
public class MyorderServiceImpl implements MyorderService {
	
	@Resource
	private MyorderDao ms;
	
	public boolean addtomyorder(Date orderdate, String orderstate,String goodsname,double ordertotalprice,
			int goodscount,String username, int ordernum, double goodsprice) {
		// ���붩����
		Boolean re = ms.addtomyorder(orderdate, orderstate, goodsname, ordertotalprice, goodscount, username, ordernum, goodsprice);
		return re;
	}
	
	public List<Myorder> selectbyname(String username) {
		// ����username����myorder
		List<Myorder> list = ms.selectbyname(username); 
		return list;
	}
	
	public boolean updateoroder(int ordernum) {
		// ����ordernum�޸Ķ���
		boolean re = ms.updateoroder(ordernum);
		return re;
	}
}
