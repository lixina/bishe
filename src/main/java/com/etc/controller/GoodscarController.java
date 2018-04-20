package com.etc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etc.entity.Goodscar;
import com.etc.entity.Goodsmsg;
import com.etc.service.GoodscarService;
import com.etc.service.GoodsmsgService;

@Controller
public class GoodscarController {
	@Resource
	private GoodscarService gs;
	@Resource
	private GoodsmsgService gms;
	@RequestMapping(value="/showgoodscar" ,method = RequestMethod.GET)
public String showgoodscar(Model model,HttpServletRequest request){
	String username = request.getParameter("username");	
	List<Goodscar> list = gs.showgoodscar(username);
	model.addAttribute("list", list);
	HttpSession session = request.getSession();
	session.setAttribute("list", list);
	return "shoppingcart";
}
	//���빺�ﳵ
	@RequestMapping(value="/getgoodsmsgbyid",method = RequestMethod.GET)
	public String getGoodsmsgbyId(Model model ,HttpServletRequest request){
		String goodsid = request.getParameter("goodsid");
		String username = request.getParameter("username");
		int gsid = Integer.valueOf(goodsid).intValue();
		Goodsmsg goods = gms.getgoodsbyid(gsid);
		String goodsname = goods.getGoodsname();
		double goodsprice = goods.getGoodsprice();
		/*����Ʒ��Ϣ������� �ٲ�ѯ��ʾ����*/
		double totalprice = goodsprice;
		boolean result = gs.addtogoodscar(gsid, goodsname, goodsprice, totalprice, username);
		List<Goodscar> list = gs.showgoodscar(username);
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		model.addAttribute("list", list);
		if(result == true){
			return "shoppingcart";
		}else{
			return "shoppingcart";
		}
	}
	//����
	@RequestMapping(value="/minuschange",method = RequestMethod.GET)
	public String minuschange(Model model ,HttpServletRequest request){
		String goodscount = request.getParameter("goodscount");
		int count = Integer.valueOf(goodscount).intValue();
		String goodscarid = request.getParameter("goodscarid");
		String username = request.getParameter("username");
		if(count == 1){
			//ִ��ɾ����������goodscarid
			int carid = Integer.valueOf(goodscarid).intValue();
			boolean result = gs.delgoodscar(carid);
			//��ѯ����
			List<Goodscar> list = gs.showgoodscar(username);
			model.addAttribute("list", list);
			return "shoppingcart";
		}else{
			return "shoppingcart";
		}
	}
	@RequestMapping(value="/minuschange1",method = RequestMethod.GET)
	public String minuschange1(Model model ,HttpServletRequest request){
		String goodscount = request.getParameter("goodscount");
		int count = Integer.valueOf(goodscount).intValue();
		int count1 = count-1;
		String goodscarid = request.getParameter("goodscarid");
		String username = request.getParameter("username");
		//����goodscarid�޸�
		int carid = Integer.valueOf(goodscarid).intValue();
		boolean result = gs.updategoodscar(carid, count1);
		//��ѯ���ݿ�
		List<Goodscar> list = gs.showgoodscar(username);
		model.addAttribute("list", list);
		return "shoppingcart";
	}
	//�Ӻ�
	@RequestMapping(value="/pluschange",method = RequestMethod.GET)
	public String pluschange(Model model ,HttpServletRequest request){
		String goodscount = request.getParameter("goodscount");
		int count = Integer.valueOf(goodscount).intValue();
		int count1 = count+1;
		String goodscarid = request.getParameter("goodscarid");
		String username = request.getParameter("username");
		//����goodscarid�޸�
		int carid = Integer.valueOf(goodscarid).intValue();
		boolean result = gs.updategoodscar(carid, count1);
		//��ѯ���ݿ�
		List<Goodscar> list = gs.showgoodscar(username);
		model.addAttribute("list", list);
		return "shoppingcart";
	}
	//ɾ����ť
	@RequestMapping(value="/delbtn",method = RequestMethod.GET)
	public String delbtn(Model model ,HttpServletRequest request){
		String goodscarid = request.getParameter("goodscarid");
		String username = request.getParameter("username");
		//����goodscarid�޸�
		int carid = Integer.valueOf(goodscarid).intValue();
		boolean result = gs.delgoodscar(carid);
		//��ѯ���ݿ�
		List<Goodscar> list = gs.showgoodscar(username);
		model.addAttribute("list", list);
		return "shoppingcart";
	}
}
