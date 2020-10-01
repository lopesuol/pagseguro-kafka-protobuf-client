package protos.charge.processed.v1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.common.serialization.StringSerializer;

public class Producer extends Thread {
    private final KafkaProducer<Integer, ChargeProcessedProto.ChargeProcessedEvent> producer;
    private final String topic = "charge_processed";
    private final String kafkaHost = "127.0.0.1:9092";

    public Producer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaHost);
        props.put("client.id", UUID.randomUUID().toString());
        producer = new KafkaProducer(props, new StringSerializer(), new SerializerCustom());
    }

    public void run() {
        String message = "a6daddb9-68e3-4e04-ae27-731e992ee125";

        ChargeProcessedProto.ChargeProcessedEvent event = ChargeProcessedProto.ChargeProcessedEvent.newBuilder()
                .setId(message)
                .build();

        try {
            ProducerRecord producerRecord = new ProducerRecord(topic, event);

            producer.send(producerRecord).get();
            System.out.println("Sent message: (" + message + ", " + event.toString() + ")");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}