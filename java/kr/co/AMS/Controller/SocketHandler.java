package kr.co.AMS.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler {
	
	// 콘솔창에 찍는 로거
	private final Logger logger = LogManager.getLogger(getClass());
	// private Set<WebSocketSession> sessionSet = new
	// HashSet<WebSocketSession>();
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	public SocketHandler() {
		// TextWebSocketHandler 생성
		super();
		this.logger.info("create SocketHandler instance!");
	}

	@Override
	// 연결이 끊어졌을때 리스트에서 remove를 통해 해당 session을 지운다
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);

		// sessionSet.remove(session);
		sessionList.remove(session);
		this.logger.info("remove session!");
	}

	@Override
	// 연결이 되었을때 리스트에 해당 sessiond을 입력한다
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);

		// sessionSet.add(session);
		sessionList.add(session);

		this.logger.info("add session!");
	}

	@Override
	// 소켓을 통해 입력이 들어올때마다 실행
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);

		// 입력이 들어온 해당 세션의 message를 다른 사람에게 보내준다
		for (WebSocketSession sess : sessionList) {
			//System.out.println("겟아이디" + sess.getId());
		//	System.out.println("겟아이디" + session.getId());

			// if문을 통해 들어온 세션이 본인 세션과 다를때만 message를 보내준다
			if (!sess.getId().equals(session.getId())) {
				sess.sendMessage(new TextMessage((CharSequence) message.getPayload()));
			}

		}

		// sendMessage((String)message.getPayload());

		this.logger.info("receive message:" + message.getPayload());
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		this.logger.error("web socket error!", exception);
	}

	@Override
	public boolean supportsPartialMessages() {
		this.logger.info("call method!");

		return super.supportsPartialMessages();
	}
	

}