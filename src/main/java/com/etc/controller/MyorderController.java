package com.etc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.etc.entity.Goodscar;
import com.etc.entity.Myorder;
import com.etc.entity.Usermsg;
import com.etc.service.GoodscarService;
import com.etc.service.MyorderService;
import com.etc.service.UsermsgService;
/**
 * ����
 * @author Administrator
 *
 */
@Controller
public class MyorderController {
	
	@Resource
	private GoodscarService gs;
	@Resource
	private MyorderService ms;
	@Resource
	private UsermsgService us;
	
	@Transactional
	@RequestMapping(value="/showorder",method=RequestMethod.GET)
public void showorder(Model model ,HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws IOException{
	
	// ����goodscarid��ѯgoodscar�е�����
	String goodscarid =	httpRequest.getParameter("goodscarid");
	int carid = Integer.valueOf(goodscarid);
	Goodscar goodscar = gs.selectgoodscar(carid);
	
	// �������ֶδ���myorder����
	int goodscount = goodscar.getGoodscount();
	String goodsname = goodscar.getGoodsname();
	double ordertotalprice = goodscar.getTotalprice();
	double goodsprice = goodscar.getGoodsprice();
	Date orderdate = new Date();    
	// Data mydate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	String orderstate = "������";
	String username = httpRequest.getParameter("username");
	double myordernum = (Math.random()*9+1)*100000;
	int ordernum =(int)myordernum;
	
	// ����username��ѯmyorder��
	List<Myorder> orderlist = ms.selectbyname(username);
	
	// ����username��ѯusers��
	List<Usermsg> userlist = us.selectuserbyname(username);
	model.addAttribute("orderlist", orderlist);
	model.addAttribute("userlist", userlist);
	
	// ��ó�ʼ����AlipayClient  ֧�����ӿڲ���
	AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
			"2016091100485469",
			"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDSDl3oWRn/ecE3BlDNFDI6F8vsv+RMSj8W3pRTZHlf87p5tsRkT9DJzohM6Ti2Ae61OIswAwtHyPnP0OgODkFRWq75V4yS28v7rQtXo64TKTiXZ1s8hPdAdkbTe1PcCMQ409VyeXy85697+xdjtigKvE2RdX4paqQsgvWjOVsxDVF7toM5bymJs9YZvHyU6XV12YsHwZ09+bsc0fyvmX18o9TaCtHkSoSuTW8Sh9MGWzRT4rz5WFOmcDPlsQ2b03J12xdUk5Uv43D/ujuFLehodMlBptPi9vhKAs3ZAHEvuMAvKfuY1gpnqOZwXX2lZUcVEvUrsh+r9zb4Yj7ObgvzAgMBAAECggEASweIsYKKD7/8rNvbprUND8UKOSF9uWZXzKJqVrMvy38yX2FSGwaLbFoSQ26WrCRakG6HAPpFYDnASWO0T7j1ycpbb4K/GoHaBaaUw5QajIuPxDzN0PspmePlfoqxtImJFUdNGZudW5hiDSXt/9bDzLnf9xIBo2eNBr0sYkYNdaJHMryMe9SQoMmHbnvcUVm1orN5ZX+m7xMD9fTy0+2Cu/r3goGUBjpkXKxGUmk2xvR2RQMiYaK7QB/JzWm4/nCRCX7dOIkj4k/DmQMNlj6j5g068oFCpLSq01cmHncBIwFP8+CcsG/fCy7d83DgyDf95gLvt/GGEQqV0p7uenXN4QKBgQD3eOhhQQUL1t9FuKFudyU0sB8KK2hVBoqtzOh0+7bEzJSG9GEsPWHM5//0Hmzne5TxkS88vIIjKUOgBlJKSTB4CSb1b3K2FB4JC9bVba/VZFRsxguFJ6qxTikfgwVaTUi6sLeBU72kdgeyTfBpFekhY7w9fNebeaAdxZm9G6k5IwKBgQDZS2PVLINOta7SUrMnmw9GHZY9F0KhBQI0ucX6yH8Iap6i+UflR5CUFwDMH6sN1d5+D6RnrZA47BNIlk/rHfOzyd5Cxm1dLyzk4znGgssupMvThhHzQK42xs+onBFszB+Q505T+4isKcEJakyTgQ1MjFVPSiRB6yPVBXTS0/TW8QKBgEf9o1RPbuFf07nbmRKilG88YPs7X3GEoqkmt+T4KNYdUYPk6bPN83qBbyMcCsBYYh7YBm7bw9vosCSIUj4MBo6U0wGJN0yik448JHYYH5OrSSgPgOBuhqhnvWzOV6tKWkL9D5UOwFdsgparN6nKVvSAqA0XGT3AZwTiK/QobNUTAoGAIc//au6QSDExUP0Zb7JLQCfedwclkRTMcRPvYMTOL6sXoFiV/XGTZ9fkgd7zqSV8h7U7af6yEIl7vrHVIcr5XyKseUuTPQrYO424MdGseEegh/u201lfQprROXV/qKRizRORNrRPYirlJOfrnpBYV28G3120IqXKX52Hvj7JPKECgYEAmQpOhbaUUoCJ1iP+WNqH0/nemS/5YjIuxuouh7PmfWqkTUfBoVFV/91TRWD/I63JFFHkDwJhbHh3t2q7bFInRQNyRMl25yFsqsI7yn2E1Ayh4WnClm8Eay6a9xCRzqtWbX/DPg3HTg8oVQoQTNP1abzLITrSfft9ycl6kuAQIq8=",
			"json",
			"utf-8",
			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB");
	    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//����API��Ӧ��request
	    alipayRequest.setReturnUrl("http://localhost:8090/showorders?username="+username);
	    alipayRequest.setNotifyUrl("http://localhost:8090/main.jsp");//�ڹ������������û�����֪ͨ��ַ
	    alipayRequest.setBizContent("{" +
	    		  "    \"out_trade_no\":\""+myordernum+"\"," +
	    	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	    	        "    \"total_amount\":"+goodsprice+"," +
	    	        "    \"subject\":\""+goodsname+"\"," +
	    	        "    \"body\":\""+goodsname+"\"," +
	    	        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
	    	        "    \"extend_params\":{" +
	    	        "    \"sys_service_provider_id\":\"2088511833207846\"" +
	    	        "    }"+
	        "  }");// ���ҵ�����
	   String form="";
	    try {
	    	form = alipayClient.pageExecute(alipayRequest).getBody(); // ����SDK���ɱ�
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }
	    httpResponse.setContentType("text/html;charset=" + "utf-8");
	    httpResponse.getWriter().write(form);// ֱ�ӽ������ı�html�����ҳ��
	    httpResponse.getWriter().flush();
	    httpResponse.getWriter().close();
	    ms.addtomyorder(orderdate, orderstate, goodsname, ordertotalprice, goodscount, username, ordernum, goodsprice);
}
	
	@RequestMapping(value="/showorders",method=RequestMethod.GET)
	public String showorders(Model model ,HttpServletRequest request){
		
		String username = request.getParameter("username");
		// ����username��ѯmyorder��
		List<Myorder> orderlist = ms.selectbyname(username);
		// ����username��ѯusers��
		List<Usermsg> userlist = us.selectuserbyname(username);
		model.addAttribute("orderlist", orderlist);
		model.addAttribute("userlist", userlist);
		return "showorder";
	}
	
	@RequestMapping(value="/goodssure",method=RequestMethod.GET)
	@ResponseBody
	public List<Myorder> goodssure(Model model ,HttpServletRequest request){
		
		// ���ݶ������޸�orderstate
		String ordernumber = request.getParameter("ordernum");
		int ordernum = Integer.valueOf(ordernumber);
		ms.updateoroder(ordernum);
		
		// ����username��ѯmyorder��
		String username = request.getParameter("username");
		List<Myorder> orderlist = ms.selectbyname(username);
		return orderlist;
	}
}
