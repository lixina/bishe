package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Goodsmsg;

public  interface GoodsmsgDao{
	// ��ѯ������Ʒ
	public List<Goodsmsg> getAllGoodsmsg();
	
	// �������Ͳ�ѯ��Ʒ
	public List<Goodsmsg> getGoodsByType(String goodstype);
	
	// ������Ʒ����ģ����ѯ��Ʒ
	public List<Goodsmsg> getgoodsbyname(@Param("goodsname")String goodsname);
	
	// ����goodsid��ѯ��Ʒ��Ϣ����Ʒ��ʾҳ��
	public Goodsmsg getGoodsById(@Param("goodsid")int goodsid);
}
