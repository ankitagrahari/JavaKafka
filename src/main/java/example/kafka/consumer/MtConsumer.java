package example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MtConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "mt", groupId = "kafka-sandbox")
    public void listen(String message){
        synchronized (message){
            messages.add(message);
        }
    }

    public List<String> getMessages(){
        return messages;
    }
}
