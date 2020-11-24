package com.tirmizee.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tirmizee.constants.KafkaConstants;
import com.tirmizee.model.Payload;

@Service
public class KafKaObjectConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafKaObjectConsumer.class);
	
	@KafkaListener(
		groupId = "reflectoring-group-1", 
		topics = KafkaConstants.TOPIC_01,
		containerFactory = "objectListenerContainerFactory")
	void listenToPartitionWithOffset(Payload payload) {
		logger.info(String.format("Message recieved -> %s", payload));
		logger.info("{}", payload.getId());
		logger.info("{}", payload.getMessage());
	}
	
}
