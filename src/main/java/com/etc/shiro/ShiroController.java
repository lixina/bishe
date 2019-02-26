package com.etc.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class ShiroController {
	@RequestMapping(value="/subLogin",method = RequestMethod.POST)
	public String subLogin(User user) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getUserpwd());
		try {
			subject.login(token);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "登陆成功~~";
	}
}
