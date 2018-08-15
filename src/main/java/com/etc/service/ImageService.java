package com.etc.service;
import java.util.List;

import com.etc.entity.Image;

public interface ImageService {
    
	public Image getImage(int goodsid,int imagetype);
    
    public List<Image> getSomeImage(int goodsid,int imagetype);
    
    public List<Image> getAllImage(int goodsid);
}

