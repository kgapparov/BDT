package cs523.bdt;

import com.launchdarkly.eventsource.EventSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BdtApplication {

    public static void main(String[] args) {

        SpringApplication.run(BdtApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EventSource eventSource) {
        return args -> {
            eventSource.start();
        };
    }
}
