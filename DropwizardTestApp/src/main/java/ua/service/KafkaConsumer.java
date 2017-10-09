package ua.service;

public interface KafkaConsumer {

	void receive(String message);
}
