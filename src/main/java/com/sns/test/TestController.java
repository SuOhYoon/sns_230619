package com.sns.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.post.mapper.PostMapper;

@Controller
public class TestController {
	
	@Autowired
	private PostMapper mapper;
	// 1. String + response body -> html
	@ResponseBody
	@GetMapping("/test1")
	public String test1() {
		return "hello world";
	}
	
	// 2. map + response body -> json
	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2(){
		Map<String, Object> map = new HashMap<>();
		map.put("a", 100);
		map.put("b", map);
		return map;
	}
	// 3. jsp
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	// 4. DB 연동 response body -> json
	@ResponseBody
	@GetMapping("/test4")
	public List<Map<String, Object>> test4(){
		return mapper.selectPostList();
	}
}
