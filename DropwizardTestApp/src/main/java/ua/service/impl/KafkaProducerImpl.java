package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ua.service.KafkaProducer;

@Service
public class KafkaProducerImpl implements KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void send(String massage) {
		kafkaTemplate.send("Test", massage);
	}
}
