package cs523.bdt.configs;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:kafka.properties")

public class KakfaTopicConfig {
    @Value("${kafka.topic}")
    private String topic;

    @Value("${kafka.topic.partitions}")
    private Integer partitions;

    @Value("${kafka.topic.replicas}")
    private Integer replicas;

    @Bean
    public NewTopic getTopic(){
        return TopicBuilder
                .name(topic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }


}
