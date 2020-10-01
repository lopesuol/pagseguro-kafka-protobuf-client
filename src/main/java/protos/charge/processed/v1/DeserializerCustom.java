package protos.charge.processed.v1;

import kafka.serializer.Adapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;

public class DeserializerCustom extends Adapter implements org.apache.kafka.common.serialization.Deserializer<ChargeProcessedProto.ChargeProcessedEvent > {
    private static final Logger LOG = LoggerFactory.getLogger(DeserializerCustom.class);

    @Override
    public ChargeProcessedProto.ChargeProcessedEvent deserialize(final String topic, byte[] data) {
        try {
            return ChargeProcessedProto.ChargeProcessedEvent.parseFrom(data);
        } catch (final InvalidProtocolBufferException e) {
            LOG.error("Received unparseable message", e);
            throw new RuntimeException("Received unparseable message " + e.getMessage(), e);
        }
    }

}