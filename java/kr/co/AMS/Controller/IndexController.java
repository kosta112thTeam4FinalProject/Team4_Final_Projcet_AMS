package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//UI_테스트를 위한 controller

@Controller
public class IndexController {
	
	//1.메인 화면 실행
	@RequestMapping("index.ams")
	public String index()
	{
		System.out.println("main화면 실행");
		
		return "home.index";
	}
	
	
	
	

}
