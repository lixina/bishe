package com.etc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etc.entity.Goodsmsg;
import com.etc.entity.Image;
import com.etc.service.GoodsmsgService;
import com.etc.service.ImageService;

@Controller
public class ImageController {
@Resource
private ImageService is;
@Resource
private GoodsmsgService gs;
@RequestMapping(value="/qqq",method = RequestMethod.GET)
public String imageList(Model model,HttpServletRequest request){
	String goodsid = request.getParameter("goodsid");
	int gsid = Integer.valueOf(goodsid).intValue();
	Goodsmsg goods = gs.getgoodsbyid(gsid);
	String goodsname = goods.getGoodsname();
	double goodsprice = goods.getGoodsprice();
	/*将商品信息放入session*/
	HttpSession session = request.getSession();
	session.setAttribute("goodsname", goodsname);
	session.setAttribute("goodsprice", goodsprice);
	session.setAttribute("goodsid", gsid);
	List<Image> list = is.getAllImage(gsid);
    model.addAttribute("imagelist", list);
	return "mygoodsmsg";
}
}