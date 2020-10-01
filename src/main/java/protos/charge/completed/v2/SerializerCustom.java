package protos.charge.completed.v2;

import kafka.serializer.Adapter;

public class SerializerCustom extends Adapter
        implements org.apache.kafka.common.serialization.Serializer<ChargeCompletedProto.ChargeCompletedEvent> {
    @Override
    public byte[] serialize(final String topic, final ChargeCompletedProto.ChargeCompletedEvent data) {
        return data.toByteArray();
    }
}