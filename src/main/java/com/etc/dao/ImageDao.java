package com.etc.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Image;

public interface ImageDao {
	
public Image getImage(@Param("goodsid")int goodsid,@Param("imagetype")int imagetype);

public List<Image> getSomeImage(@Param("goodsid")int goodsid,@Param("imagetype")int imagetype);

public List<Image> getAllImage(@Param("goodsid")int goodsid);
}
