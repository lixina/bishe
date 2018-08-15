package com.etc.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.Usermsg;
import com.etc.service.UsermsgService;
@Controller
public class UsermsgController {
	@Resource
	private UsermsgService us;
	
	@RequestMapping(value="/isuser",method = RequestMethod.GET)
	@ResponseBody
	public String isUser(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");		
		String username = request.getParameter("username");
		String msg = "";
		if (username != "") {
			boolean flag =us.isMatchee(username);					
			if (flag == true) {
				msg = "exists";
	
			} else {
				msg = "available";
			}
		} else {
			msg = "Can't be empty";
		}
		return msg;
	}
	
	@RequestMapping(value="/ispassword",method = RequestMethod.GET)
	@ResponseBody
	public String isPassword(HttpServletRequest request){
		String msg1 = "";
		String reg = "^\\w{6,16}$";
		if (request.getParameter("password") != "") {
			String password = request.getParameter("password");
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(password);
			boolean rs = matcher.matches();
			if (rs) {
				msg1 = "available";
			} else {
				msg1 = "Non conformity";
			}
		} else {
			    msg1 = "Can't be empty";
		}
		return msg1;
	}
	
	@RequestMapping(value="/ispasswordrepeat",method = RequestMethod.GET)
	@ResponseBody
	public String isPasswordrepeat(HttpServletRequest request){
		String msg2 = "";
		if (request.getParameter("passwordrepeat") != "") {
			String pwdrepeat = request.getParameter("passwordrepeat");
			String password = request.getParameter("password");					
			if (password.equals(pwdrepeat)) {
				msg2 = "success";
	
			} else {
				msg2 = "pwd disaccord";
			}
		} else {
			msg2 = "Can't be empty";
		}
		return msg2;
	}
	
	@RequestMapping(value="/isaddress",method = RequestMethod.GET)
	@ResponseBody
	public String isaddress(HttpServletRequest request){
		String msg3 = "";
		if (request.getParameter("address") != "") {
			String address = request.getParameter("address");
			int len = address.length();
			if(len < 12){
				msg3 = "Not enough";
				}else{
				msg3 = "available";	
				}				
			}else {
				msg3 = "Can't be empty";
			}
			
		return msg3;
	}
	
	@RequestMapping(value="/isuserphone",method = RequestMethod.GET)
	@ResponseBody
	public String isuserphone(HttpServletRequest request){
		String msg4 = "";
		String reg = "^((13[0-9])|(15[0-9]|[5-9])|(18[0-3]|[6-9]))\\d{8}$";
		if (request.getParameter("userPhone") != "") {
			String userPhone = request.getParameter("userphone");					
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(userPhone);
			boolean rs = matcher.matches();
			if (rs==true) {
				msg4 = "available";
			} else if(rs==false){
				msg4 = "format error";
			}
		} else {
			msg4 = "Can't be empty";
		}
		return msg4;
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String isregister(Model model,HttpServletRequest request){
	    	String username = request.getParameter("username");
	        String userpwd = request.getParameter("password");
	        String useraddress = request.getParameter("address");
	        String userphone = request.getParameter("userphone");
	        
	        Usermsg usermsg = new Usermsg();
	        usermsg.setUseradress(useraddress);
	        usermsg.setUsername(username);
	        usermsg.setUserphone(userphone);
	        usermsg.setUserpwd(userpwd);
	        model.addAttribute("usermsg",usermsg);
	        boolean result = us.adduser(username, userphone, userpwd, useraddress);
	        if(result == true){
	        return "login";
	        }else{
	        	return "register";
	        }
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String isuser(HttpServletRequest request){
		String username = request.getParameter("username");
	    String userpwd = request.getParameter("userpwd");
	    HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("userpwd", userpwd);
	    boolean result = us.isuser(username, userpwd);
	    if(result == true){
	    	return "main";
	    }else{
	    	return "login";
	    }
	}
	
	@RequestMapping(value="/backmain",method = RequestMethod.GET)
	public String backmain(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("username");//清空session信息  
		request.getSession().removeAttribute("userpwd");
		request.getSession().invalidate();//清除 session 中的所有信息  
		// 退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取  
		Cookie[] cookie=request.getCookies();  
		for(Cookie c:cookie){  
		    if("autoLogin".equals(c.getName())){  
		        c.setMaxAge(0);  
		        response.addCookie(c);  
		    }  
		}  
		return "main";
	}
	
	@RequestMapping(value="/saveusermsg",method = RequestMethod.GET)
	public void saveusermsg(HttpServletRequest request , HttpServletResponse response) throws IOException{
		// 修改usermsg
		String username = request.getParameter("username");
		String userphone = request.getParameter("userphone");
		String useraddress = request.getParameter("useraddress");
		us.updateuser(username, userphone, useraddress);
		PrintWriter out = response.getWriter();
		out.write("1111");
	}
}
