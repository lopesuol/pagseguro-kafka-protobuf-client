package protos.charge.processed.v1;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.common.serialization.IntegerDeserializer;

public class Consummer extends ShutdownableThread {
    private final KafkaConsumer<Integer, ChargeProcessedProto.ChargeProcessedEvent> consumer;
    private final String topic;

    public Consummer(String topic) {
        super("KafkaConsumerExample", false);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.199.90.108:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "OrderConsumer");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");

        consumer = new KafkaConsumer<>(props, new IntegerDeserializer(), new DeserializerCustom());
        this.topic = topic;
    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<Integer, ChargeProcessedProto.ChargeProcessedEvent> records = consumer.poll(1000);
        for (ConsumerRecord<Integer, ChargeProcessedProto.ChargeProcessedEvent> record : records) {
            System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
        }
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }
}