package protos.charge.completed.v1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.common.serialization.StringSerializer;
import protos.charge.completed.v1.fakes.boleto.BoletoFake;

public class Producer extends Thread {
    private final KafkaProducer<Integer, ChargeCompletedProto.ChargeCompletedEvent> producer;
    private final String topic = "charge_completed";
    private final String kafkaHost = "127.0.0.1:9092";

    public Producer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaHost);
        props.put("client.id", UUID.randomUUID().toString());
        producer = new KafkaProducer(props, new StringSerializer(), new SerializerCustom());
    }

    public void run() {
        producer(BoletoFake.createMessageBoletoPaymentMethod());
    }

    private void producer(ChargeCompletedProto.ChargeCompletedEvent event ) {
        try {
            ProducerRecord producerRecord = new ProducerRecord(topic, event);
            producer.send(producerRecord).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}