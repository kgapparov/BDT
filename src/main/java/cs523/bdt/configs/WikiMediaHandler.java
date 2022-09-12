package cs523.bdt.configs;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class WikiMediaHandler implements EventHandler {

    public static final Logger log = LoggerFactory.getLogger(WikiMediaHandler.class.getSimpleName());

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final NewTopic topic;

    @Autowired
    public WikiMediaHandler(KafkaTemplate<String, String> producer, NewTopic topic) {
        this.kafkaTemplate = producer;
        this.topic = topic;
    }

    @Override
    public void onOpen() {

    }

    @Override
    public void onClosed()  {

    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
        kafkaTemplate.send(topic.name(), messageEvent.getData());
    }

    @Override
    public void onComment(String comment) throws Exception {

    }

    @Override
    public void onError(Throwable t) {
        log.error(t.getMessage());
    }
}