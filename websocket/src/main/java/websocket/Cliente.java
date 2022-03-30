package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class Cliente {

	public static void main(String[] args) {

		WebSocketClient webSocketClient = new StandardWebSocketClient();
		List<Transport> t = new ArrayList<Transport>();
		t.add(new WebSocketTransport(webSocketClient));
		SockJsClient sockJsClient = new SockJsClient(t);
		WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());

		StompSession session;
		try {
		    session = stompClient
		            .connect(
		                "http://localhost:8081/mensagem", 
		                 new StompSessionHandlerAdapter() {})
		            .get();
		    
		    Mensagem m = new Mensagem();
		    m.setMensagem("Java cliente");
		    session.send("/topic/messages", m);
		    
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}

	}

}
