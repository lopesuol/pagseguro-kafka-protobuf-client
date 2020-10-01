package protos.charge.completed.v2.fakes.pix;

import protos.charge.completed.v2.ChargeCompletedProto;

public class PixFake {
    public static ChargeCompletedProto.ChargeCompletedEvent createMessagePixPaymentMethod() {
        return ChargeCompletedProto.ChargeCompletedEvent.newBuilder()
                .addPayment(createPaymentPix())
                .build();
    }

    private static ChargeCompletedProto.Payment createPaymentPix() {
        return ChargeCompletedProto.Payment.newBuilder()
                .setPaymentMethodType(ChargeCompletedProto.PaymentMethodType.PIX)
                .setPixPayment(createPix())
                .build();
    }

    private static ChargeCompletedProto.PixPayment createPix() {
        return ChargeCompletedProto.PixPayment.newBuilder()
                .setStatus(ChargeCompletedProto.PixPaymentStatus.PAID_PIX)
                .setTxId("Id fake")
                .setPixId("Id pix fake")
                .setChargeId("Id charge fake")
                .setMerchantId("Id merchant fake")
                .setCustomerId("Id customer fake")
                .setType(ChargeCompletedProto.QRCodeType.DYNAMIC)
                .setAmount(createPixPaymentAmount())
                .setPayer(createPixPayer())
                .build();
    }

    private static ChargeCompletedProto.PixPaymentAmount createPixPaymentAmount() {
        return ChargeCompletedProto.PixPaymentAmount.newBuilder()
                .setValue(1000010)
                .setCurrency("currency fake")
                .build();
    }

    private static ChargeCompletedProto.PixPayer createPixPayer() {
        return ChargeCompletedProto.PixPayer.newBuilder()
                .setDictKey("dic key fake")
                .setDictKeyType("dict key type fake")
                .setDocument("document fake")
                .setDocumentType("document type fake")
                .setName("name fake")
                .setPersonType("person type fake")
                .setAccount(createPixPayerAccount())
                .setBank(createPixPayerBank())
                .build();
    }

    private static ChargeCompletedProto.PixPayerBank createPixPayerBank() {
        return ChargeCompletedProto.PixPayerBank.newBuilder()
                .setCode("code fake")
                .setIspb("ispb fake")
                .setName("name fake")
                .build();
    }

    private static ChargeCompletedProto.PixPayerAccount createPixPayerAccount() {
        return ChargeCompletedProto.PixPayerAccount.newBuilder()
                .setNumber("number fake")
                .setType("type fake")
                .setBranch("branch fake")
                .build();
    }

}
