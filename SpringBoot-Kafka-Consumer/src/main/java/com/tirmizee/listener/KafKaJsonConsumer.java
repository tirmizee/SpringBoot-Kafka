package com.tirmizee.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tirmizee.constants.KafkaConstants;
import com.tirmizee.model.Payload;

@Service
public class KafKaJsonConsumer {

private final Logger logger = LoggerFactory.getLogger(KafKaObjectConsumer.class);
	
	@KafkaListener(
		groupId = "reflectoring-group-2", 
		topics = KafkaConstants.TOPIC_02,
		containerFactory = "jsonListenerContainerFactory")
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
