package com.etc.service;

import java.util.List;

import com.etc.entity.Goodsmsg;

public interface GoodsmsgService {
    public List<Goodsmsg> getAllGoodsmsg();
    
    public List<Goodsmsg> getGoodsByType(String goodstype);
    
    public List<Goodsmsg> getgoodsbyname(String goodsname);
    
    public Goodsmsg getgoodsbyid(int goodsid);
}
