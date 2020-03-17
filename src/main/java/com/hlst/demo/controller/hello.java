package com.hlst.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class hello {

	@RequestMapping("/")
	public String hellow() {
		System.out.println("调转到helloword页面");
		return "helloword";
	}
	
	@RequestMapping("/demo1")
	@ResponseBody
	public void demo1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.getWriter().print("<h1>hello httpservletresponse DEMO1<h1>");
	}
	
	@RequestMapping("/demo2")
	@ResponseBody
	public String demo2() {
		return "<h1>hello httpservletresponse DEMO2<h1>";
	}
	
	@RequestMapping("/demo3")
	public void demo3(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.sendRedirect("/MyProject/templates/helloword.html");
	}
	
	/*
	 * @RequestMapping("demo4") public ModelAndView demo4() { ModelAndView
	 * modelAndView = new ModelAndView();
	 * modelAndView.addObject("helloword---------");
	 * modelAndView.setViewName("helloword"); return modelAndView; }
	 */
	
	
	
}
