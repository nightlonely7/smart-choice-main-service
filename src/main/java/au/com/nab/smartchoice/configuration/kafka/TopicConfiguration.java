package au.com.nab.smartchoice.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    public static final String LOG_TOPIC = "log";

    @Bean
    public NewTopic logTopic() {
        return TopicBuilder.name(LOG_TOPIC).build();
    }

}
