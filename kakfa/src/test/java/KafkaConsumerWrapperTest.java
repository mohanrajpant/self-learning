import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.MockConsumer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.mock;


public class KafkaConsumerWrapperTest {

    private static final String TOPIC = "topic";
    private static final Duration pollTimeout = Duration.ofMillis(10);
    private final ExecutorService executorService  = Executors.newFixedThreadPool(2);
    private MessageHandler mockMessageHandler = mock(MessageHandler.class);
    private MockConsumer<String, String> mockConsumer = new MockConsumer<>(OffsetResetStrategy.NONE);
    private KafkaConsumerWrapper underTest = new KafkaConsumerWrapper(mockConsumer,
        Collections.singletonList(TOPIC),
        pollTimeout,
        executorService,
        mockMessageHandler);

    @Test
    public void pollUntilStopped() throws Exception {
        underTest.start();
        publishRecord(pollTimeout.multipliedBy(10));


    }

    private void publishRecord(Duration duration) {
        ConsumerRecord<String, String> record = consumerRecordFor("val");

        mockConsumer.addRecord(record);
    }

    private ConsumerRecord<String, String> consumerRecordFor(String value) {

        return new ConsumerRecord<>(TOPIC, 0, 0, null, value);
    }
}