package com.etc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.etc.entity.Goodscar;
public interface GoodscarService {
	 //���붩����Ϣ
		public boolean addtogoodscar(int goodsid,String goodsname,double goodsprice,double totalprice,String username);
	   //�����û���������ʾ������Ϣ
		public List<Goodscar> showgoodscar(String username);
		//����goodscaridɾ��goodscar
		public boolean delgoodscar(int goodscarid);
		//����goodscarid�޸�goodscount
		public boolean updategoodscar(int goodscarid,int goodscount);
		//���빺�ﳵʱ�ж�
		public boolean isexits(int goodsid,String username);
		//����goodscarid��ѯgoodscar�е�����
		public Goodscar selectgoodscar(int goodscarid);
}
