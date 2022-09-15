package co.develhope.Web.Socket1.Controller;

import co.develhope.Web.Socket1.Entities.SimpleMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClient (@RequestBody SimpleMessageDTO messageDTO){
        simpMessagingTemplate.convertAndSend("/topic/messages", messageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public SimpleMessageDTO handleMessageFromWebSocket(SimpleMessageDTO message)  {
        System.out.println("Arrived message on /app/hello -" + message.toString());
        return new SimpleMessageDTO("Message from: " + message.getType() + " - " + message.getMessage());
    }

}
