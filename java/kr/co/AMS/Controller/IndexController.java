package kr.co.AMS.Controller;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//UI_테스트를 위한 controller

@Controller
public class IndexController {
	
	@Autowired
	private SqlSession SqlSession;
	//1.메인 화면 실행
	@RequestMapping("index.ams")
	public String index() throws ClassNotFoundException, SQLException
	{
		System.out.println("main화면 실행");

		
		return "home.index";
	}
	
	
	
	

}
