package protos.charge.completed.v2.fakes.boleto;

import protos.charge.completed.v2.ChargeCompletedProto;

public class BoletoFake {
    public static ChargeCompletedProto.ChargeCompletedEvent createMessageBoletoPaymentMethod() {
        return ChargeCompletedProto.ChargeCompletedEvent.newBuilder()
                .addPayment(createPaymentBoleto())
                .build();
    }

    private static ChargeCompletedProto.Payment createPaymentBoleto() {
        return ChargeCompletedProto.Payment.newBuilder()
                .setPaymentMethodType(ChargeCompletedProto.PaymentMethodType.BOLETO)
                .setBoletoPayment(createBoleto())
                .build();
    }

    private static ChargeCompletedProto.BoletoPayment createBoleto() {
        return ChargeCompletedProto.BoletoPayment.newBuilder()
                .setBoletoId("Id boleto")
                .setDueDate(125000)
                .setDaysUntilExpiration(1)
                .setNotificationUrl("url fake")
                .setTemplate("template fake")
                .setCreatedAt(100000)
                .setStatus(ChargeCompletedProto.BoletoPaymentStatus.PAID)
                .setGatewayResponse(createGatewayResponse())
                .setCost(1321321)
                .setPaymentCode("payment code fake")
                .build();
    }

    private static ChargeCompletedProto.BoletoGatewayResponse createGatewayResponse() {
        return ChargeCompletedProto.BoletoGatewayResponse.newBuilder()
                .setBankReferenceCode("bank reference code fake")
                .setGatewayReferenceCode("gateway reference code fake")
                .setBankName("bank name fake")
                .setEstablishment("establishment fake")
                .build();
    }
}
