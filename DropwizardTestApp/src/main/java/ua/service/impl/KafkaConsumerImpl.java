package ua.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ua.service.KafkaConsumer;

@Service
public class KafkaConsumerImpl implements KafkaConsumer{

	@Override
	@KafkaListener(topics="Test")
	public void receive(String message) {
		System.out.println(message);
	}
}
