package protos.charge.completed.v2;

public class RunProducer {
    public static void main(String[] args) {
        Producer producerThread = new Producer();
        producerThread.start();
    }
}
