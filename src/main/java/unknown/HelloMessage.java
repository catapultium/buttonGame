package unknown;

import lombok.Data;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

@Data
public class HelloMessage {
    @MessageMapping("hello")
    @SendTo("/chat/hello")
    public HelloMessage hello(HelloMessage message) throws Exception {
        
        Thread.sleep(100);
        return message;
    }
    
    public HelloMessage bye (HelloMessage message) throws Exception {
        return null;
    }
    
}
