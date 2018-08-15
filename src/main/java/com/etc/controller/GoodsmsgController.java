package com.etc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etc.dao.GoodsmsgDao;
import com.etc.dao.ImageDao;
import com.etc.entity.Goodsmsg;
import com.etc.entity.Image;
import com.etc.service.GoodsmsgService;
import com.etc.service.ImageService;

@Controller
public class GoodsmsgController {
	@Resource
    private GoodsmsgDao gd;
	@Resource
	private ImageDao imgd;	
	@Resource
    private GoodsmsgService gs;
	@Resource
    private ImageService is;
	// 获取所有商品信息
	@RequestMapping(value="/goodsmsg",method = RequestMethod.GET)
	public String listGoodsmsg(Model model){
		List<Goodsmsg> list = gs.getAllGoodsmsg();
		List<Goodsmsg> listmsg = new ArrayList<Goodsmsg>();
		for(Goodsmsg goodsmsg:list){
			Goodsmsg goods = goodsmsg;
			int id = goods.getId();
			int imagetype = 0;
			Image image = is.getImage(id,imagetype);
			goods.setImage(image);
			listmsg.add(goods);
		}
		model.addAttribute("goodsmsg", listmsg);
		return "showgoods";
	}
	// 根据商品类型显示
	@RequestMapping(value="/goodskindd",method = RequestMethod.GET)
	public String getGoodsByType(Model model,HttpServletRequest request){
		String gt = request.getParameter("type");
		List<Goodsmsg> gss =gs.getGoodsByType(gt);
		model.addAttribute("goodslist", gss);
		return "goodskind";
	}
	// 根据商品名称模糊查询
	@RequestMapping(value="/getgoodsbyname",method = RequestMethod.POST)
	public String getgoodsbyname(Model model,HttpServletRequest request){
		String goodsname = request.getParameter("goodsname");
		List<Goodsmsg> gss = gs.getgoodsbyname(goodsname);
		model.addAttribute("goodsmsg", gss);
		return "showgoods";
	}
}
