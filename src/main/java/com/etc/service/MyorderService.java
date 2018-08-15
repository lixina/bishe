package com.etc.service;
import java.util.Date;
import java.util.List;

import com.etc.entity.Myorder;

public interface MyorderService {
	
	public boolean addtomyorder(Date orderdate,String orderstate,String goodsname,double ordertotalprice,
            int goodscount,String username,int ordernum,double goodsprice);
	
	public List<Myorder> selectbyname(String username);
	
	// ¸ù¾ÝordernumÐÞ¸Äorder
	public boolean updateoroder(int ordernum);
}
