package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.Usermsg;

public interface UsermsgDao {
	public boolean isMatchee(String USERNAME);
	public boolean adduser(@Param("username")String username,@Param("userphone")String userphone ,@Param("userpwd")String userpwd,@Param("useraddress")String useraddress);
    public boolean isuser(@Param("username")String username,@Param("userpwd")String userpwd);
    public List<Usermsg> selectuserbyname(String username);
    public boolean updateuser(@Param("username")String name,@Param("userphone")String userphone,@Param("useraddress")String useraddress);
}
