package example.kafka.controller;

import example.kafka.consumer.MtConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> kafkaTemplate;
    private MtConsumer mtConsumer;

    public KafkaController(KafkaTemplate<String, String> template, MtConsumer mtConsumer){
        this.kafkaTemplate = template;
        this.mtConsumer = mtConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message){
        kafkaTemplate.send("mt", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages(){
        return mtConsumer.getMessages();
    }

}
