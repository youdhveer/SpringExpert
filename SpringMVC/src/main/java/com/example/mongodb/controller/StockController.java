package com.example.mongodb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.mongodb.entity.Stock;
import com.example.mongodb.service.StockService;

@Controller
public class StockController extends MultiActionController{

	@Autowired
	private StockService stockService;
	  
	@RequestMapping(value = "/stock", method = RequestMethod.GET)  
	 public String getUserList(ModelMap model) {  
		 model.addAttribute("stockList", stockService.listStocks());  
		 return "stockList"; 
	 }  

	
	@RequestMapping(value = "/stock/add", method = RequestMethod.POST) 
    public View add(@ModelAttribute Stock stock, ModelMap model) throws Exception {
		stockService.addStock(stock);
		return new RedirectView("/SpringMVC/stock");
		//return new ModelAndView("/SpringMVC/stock");
			
	}
	
	@RequestMapping(value = "/stock/delete", method = RequestMethod.POST) 
	public ModelAndView delete(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
			
		return new ModelAndView("StockDeleteView");
				
	}
	
	@RequestMapping(value = "/stock/update", method = RequestMethod.POST) 
	public ModelAndView update(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
			
		return new ModelAndView("StockUpdateView");
				
	}
	
	/*@RequestMapping(value = "/stock/list", method = RequestMethod.GET) 
	public ModelAndView list(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		List<Stock> stockList=stockService.listStocks();
		request.setAttribute("stockList", stockList);
		return new ModelAndView("stockList");
					
	}*/
}
