package cs523.bdt.configs;

import com.launchdarkly.eventsource.EventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.URI;

@Configuration
@PropertySource("classpath:kafka.properties")
public class WikiEventSource {

    private final WikiMediaHandler wikiMediaHandler;

    @Value("${kafka.stream.source.url}")
    private String url;

    @Autowired
    public WikiEventSource(WikiMediaHandler wikiMediaHandler) {
        this.wikiMediaHandler = wikiMediaHandler;
    }

    @Bean
    public EventSource eventSource() {
        return new EventSource.Builder(wikiMediaHandler, URI.create(url)).build();
    }
}
