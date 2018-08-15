package com.etc.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.ImageDao;
import com.etc.entity.Image;
import com.etc.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService{
    @Resource
	private ImageDao imgd;
    
    public Image getImage(int goodsid,int imagetype){
    	// 查询商品小图片
    	return imgd.getImage(goodsid,imagetype);
    }
    
    public List<Image> getSomeImage(int goodsid, int imagetype) {
    	// 购买详情页获取图片
    	return imgd.getSomeImage(goodsid, imagetype);
    }
    
    public List<Image> getAllImage(int goodsid) {
    	// 购买详情页获取图片
    	return imgd.getAllImage(goodsid);
    }
}



