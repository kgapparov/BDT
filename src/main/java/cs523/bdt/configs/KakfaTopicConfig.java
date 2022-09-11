package cs523.bdt.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@PropertySource("kafka.properties")
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
