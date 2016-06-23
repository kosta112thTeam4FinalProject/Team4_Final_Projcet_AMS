package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocketController {

	@RequestMapping("web_socket.ams")
	public String WebSocketView(){
		
		System.out.println("온라인 반상회");
		return "Residents.websocket.web_socket";
	}
}
