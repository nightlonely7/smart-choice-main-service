package au.com.nab.smartchoice.input.kafkalistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaTestListener {

    @KafkaListener(topics = "test-topic", groupId = "myGroup")
    public void listen(String data) {
        log.info("kafka data: " + data);
    }
}
