package com.etc.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.UsermsgDao;
import com.etc.entity.Usermsg;
import com.etc.service.UsermsgService;
@Service
public class UsermsgServiceImpl implements UsermsgService {
	@Resource
private UsermsgDao ud;
	public boolean isMatchee(String username) {
	// 判断用户名是否存在
	return ud.isMatchee(username);
}
	public boolean adduser(String username, String userphone, String userpwd,
			String useraddress) {
		// 增加用户（注册）
		boolean re = ud.adduser(username, userphone, userpwd, useraddress);
		return re;
	}
	public boolean isuser(String username, String userpwd) {
		//是否存在用户（登录）
		boolean re = ud.isuser(username, userpwd);
		return re;
	}
	public List<Usermsg> selectuserbyname(String username) {
		//根据username查询
		List<Usermsg> list = ud.selectuserbyname(username);
		return list;
	}
	public void updateuser(String username, String userphone, String useraddress) {
		//根据username修改user
		ud.updateuser(username, userphone, useraddress);
	}
}
