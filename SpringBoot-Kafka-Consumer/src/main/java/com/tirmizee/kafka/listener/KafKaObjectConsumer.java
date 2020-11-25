package com.tirmizee.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tirmizee.kafka.annotation.KafkaListenerTopic01;
import com.tirmizee.model.Payload;

@Service
public class KafKaObjectConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafKaObjectConsumer.class);
	
	@KafkaListenerTopic01(containerFactory = "objectListenerContainerFactory")
	void listenToPartitionWithOffset(Payload payload) {
		logger.info(String.format("Message recieved -> %s", payload));
		logger.info("{}", payload.getId());
		logger.info("{}", payload.getMessage());
		if (payload.getInner() != null) {
			logger.info("{}", payload.getInner().getId());
			logger.info("{}", payload.getInner().getMessage());
		}
	}
	
}
