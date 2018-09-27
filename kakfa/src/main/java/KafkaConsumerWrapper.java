import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.CompletableFuture.runAsync;

public class KafkaConsumerWrapper {

    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final Consumer<String, String> kafkaConsumer;
    private final List<String> topics;
    private final Duration pollTimeout;
    private final ExecutorService executorService;
    private MessageHandler messageHandler;

    public KafkaConsumerWrapper(Consumer<String, String> kafkaConsumer,
                                List<String> topics,
                                Duration pollTimeout,
                                ExecutorService executorService,
                                MessageHandler messageHandler) {
        this.kafkaConsumer = kafkaConsumer;
        this.topics = topics;
        this.pollTimeout = pollTimeout;
        this.executorService = executorService;
        this.messageHandler = messageHandler;
    }

    public void start() {
        kafkaConsumer.subscribe(topics);

        runAsync(this::pollMessageUntilStopped);
    }

    private void pollMessageUntilStopped()  {
        while (!closed.get())
            kafkaConsumer.poll(pollTimeout.toMillis())
                .forEach(message -> messageHandler.handleMessage(message.value()));
    }

    public void stop() {
        closed.set(true);
        kafkaConsumer.wakeup();
    }
}
