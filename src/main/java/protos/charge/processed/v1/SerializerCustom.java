package protos.charge.processed.v1;

import kafka.serializer.Adapter;

public class SerializerCustom extends Adapter implements
        org.apache.kafka.common.serialization.Serializer<ChargeProcessedProto.ChargeProcessedEvent> {
    @Override
    public byte[] serialize(final String topic, final ChargeProcessedProto.ChargeProcessedEvent data) {
        return data.toByteArray();
    }
}