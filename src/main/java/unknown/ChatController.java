package unknown;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Data
@Log4j
@Controller
public class ChatController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public HelloMessage hello(HelloMessage message) throws Exception {
        Thread.sleep(100);
        log.info(message.toString());
        return message;
    }
    
    @MessageMapping("/search")
    @SendToUser
    public String search(@Payload String xxx){
        
        return "Test";
    }
}
