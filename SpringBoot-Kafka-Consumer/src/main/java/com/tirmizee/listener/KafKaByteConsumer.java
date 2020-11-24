package com.tirmizee.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaByteConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafKaByteConsumer.class);
	
	@KafkaListener(
		groupId = "reflectoring-group-2", 
		topics = "topic-3",
		containerFactory = "byteListenerContainerFactory")
	void listenToPartitionWithOffset(byte[] payload) {
		logger.info(String.format("Message recieved -> %s", new String(payload)));
	}
	
}
