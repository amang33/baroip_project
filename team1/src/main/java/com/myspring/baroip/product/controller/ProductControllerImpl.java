package com.myspring.baroip.product.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.baroip.product.service.ProductService;
import com.myspring.baroip.product.vo.ProductVO;

@Controller("productController")
@RequestMapping(value = "/product")
public class ProductControllerImpl implements ProductController {
	
	@Autowired
	private ProductService productService;

	// ��ǰ���� ������ ��ü mapping
	@Override
	@RequestMapping(value = "/*", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView product(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);

		return mav;
	}
	
	@Override
	@RequestMapping(value = "/product_01", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView productTest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);
		mav.addObject("pageInfo", "set_farm");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/productDetail", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView productDetail(@RequestParam("product_id") String product_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
				
		Map<String, Object> productInfo = productService.productDetail(product_id);
		
		
		ProductVO product = (ProductVO)productInfo.get("productVO");
		// 
		String pageInfo = product.getProduct_main_category();
		
		mav.addObject("productInfo", productInfo);
		return mav;
	}


	

//	// ��ǰ ���
//	@RequestMapping(value= "/product_01.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView product_01(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		// HttpSession session;
//		ModelAndView mav = new ModelAndView();
//		String viewName = (String)request.getAttribute("viewName");
//		mav.setViewName(viewName);
//		return mav;
//	}
//	
//	
//	// ��ǰ ��
//	@RequestMapping(value= "/product_02.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView product_02(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		// HttpSession session;
//		ModelAndView mav = new ModelAndView();
//		String viewName = (String)request.getAttribute("viewName");
//		mav.setViewName(viewName);
//		return mav;
//	}
//	
//	// ��ǰ ��_�����ı�
//	@RequestMapping(value= "/product_03.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView product_03(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		// HttpSession session;
//		ModelAndView mav = new ModelAndView();
//		String viewName = (String)request.getAttribute("viewName");
//		mav.setViewName(viewName);
//		return mav;
//	}
//	// ��ǰ ��_��۾ȳ�
//	@RequestMapping(value= "/product_04.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView product_04(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		// HttpSession session;
//		ModelAndView mav = new ModelAndView();
//		String viewName = (String)request.getAttribute("viewName");
//		mav.setViewName(viewName);
//		return mav;
//	}
//	// ��ǰ ��_��ǰ ����
//	@RequestMapping(value= "/product_05.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView product_05(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		// HttpSession session;
//		ModelAndView mav = new ModelAndView();
//		String viewName = (String)request.getAttribute("viewName");
//		mav.setViewName(viewName);
//		return mav;
//	}
//	// ��ǰ ���� �ۼ�
//	@RequestMapping(value= "/product_06.do" ,method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView product_06(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		// HttpSession session;
//		ModelAndView mav = new ModelAndView();
//		String viewName = (String)request.getAttribute("viewName");
//		mav.setViewName(viewName);
//		return mav;
//	}

}