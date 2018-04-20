package com.etc.service;

import java.util.List;

import com.etc.entity.Usermsg;

public interface UsermsgService {
    public boolean isMatchee(String username);
    public boolean adduser(String username,String userphone ,String userpwd,String useraddress);
    public boolean isuser(String username,String userpwd);
    public List<Usermsg> selectuserbyname(String username);
    public void updateuser(String username,String userphone,String useraddress);
}
