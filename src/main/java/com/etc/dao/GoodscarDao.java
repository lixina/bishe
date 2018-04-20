package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Goodscar;

public interface GoodscarDao {
	// ���붩����Ϣ
	public boolean addtogoodscar(@Param("goodsid") int goodsid,
			@Param("goodsname") String goodsname,
			@Param("goodsprice") double goodsprice,
			@Param("totalprice") double totalprice, @Param("username") String username);

	// �����û���������ʾ������Ϣ
	public List<Goodscar> showgoodscar(@Param("username") String username);
	//����goodscaridɾ��
	public boolean delgoodscar(int goodscarid);
	//����goodscarid�޸�goodscount
	public boolean updategoodscar(@Param("goodscarid")int goodscarid,@Param("goodscount")int goodscount);
	//���빺�ﳵǰ�ж��Ƿ��Ѿ����ڸ���Ʒ
	public boolean isexits(@Param("goodsid")int goodsid,@Param("username")String username); 
	//����goodscarid��ѯgoodscar�е�����
	public Goodscar selectgoodscar(int goodscarid);
}
