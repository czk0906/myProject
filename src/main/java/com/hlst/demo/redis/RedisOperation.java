package com.hlst.demo.redis;

import java.time.Duration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redisOperation")
public class RedisOperation {
	
	@Autowired
    private RedisTemplate<String,Object> redisTemplate;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		System.out.println("################Add");
		System.out.println("key:"+request.getParameter("key"));
		System.out.println("value:"+request.getParameter("value"));
		System.out.println("time:"+request.getParameter("time"));
		
		  redisTemplate.opsForValue().set(request.getParameter("key"),
		  request.getParameter("value"),
		  Duration.ofSeconds(Long.parseLong((String)request.getParameter("time"))));
		 
		//redisTemplate.opsForValue().set("111", "111");
		return "success";
	}

}
