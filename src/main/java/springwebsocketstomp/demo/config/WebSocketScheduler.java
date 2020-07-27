package springwebsocketstomp.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@EnableScheduling
@Configuration
public class WebSocketScheduler {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() {
        template.convertAndSend("/topic/user", new Date().toString());
    }
}
