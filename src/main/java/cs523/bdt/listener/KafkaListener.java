package cs523.bdt.listener;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "first_topic",
            groupId = "group_id"
    )
    void Listener (String data) {
        System.out.println("Listener received: " + data + " 🥳");
    }
}
