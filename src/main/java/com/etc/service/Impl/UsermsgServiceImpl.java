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
	// �ж��û����Ƿ����
	return ud.isMatchee(username);
}
	public boolean adduser(String username, String userphone, String userpwd,
			String useraddress) {
		// �����û���ע�ᣩ
		boolean re = ud.adduser(username, userphone, userpwd, useraddress);
		return re;
	}
	public boolean isuser(String username, String userpwd) {
		//�Ƿ�����û�����¼��
		boolean re = ud.isuser(username, userpwd);
		return re;
	}
	public List<Usermsg> selectuserbyname(String username) {
		//����username��ѯ
		List<Usermsg> list = ud.selectuserbyname(username);
		return list;
	}
	public void updateuser(String username, String userphone, String useraddress) {
		//����username�޸�user
		ud.updateuser(username, userphone, useraddress);
	}
}
