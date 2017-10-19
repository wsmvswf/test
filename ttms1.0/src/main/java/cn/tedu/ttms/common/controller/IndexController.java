package cn.tedu.ttms.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/indexUI.do")
	public String indexUI(){
		System.out.println("indexUI");
		//返回的字符串会对应一个/WEB-INF/pages/index.jsp页面
		return "index";
	}
}
