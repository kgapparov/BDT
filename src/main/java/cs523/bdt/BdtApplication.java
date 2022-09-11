package cs523.bdt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class BdtApplication {

    public static void main(String[] args) {

        SpringApplication.run(BdtApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for (int i= 0; i < 100; i++) {
                kafkaTemplate.send("first_topic", "Hello kafka" + i);
            }
        };
    }

}