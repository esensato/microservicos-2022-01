package websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensagemController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages") // direciona para os inscritos no tópico
	public Mensagem getMensagens(Mensagem dto) throws InterruptedException{
		Thread.sleep(5000);
		dto.setMensagem("Para a fila: " + dto.getMensagem());
		return dto;
	}
}
