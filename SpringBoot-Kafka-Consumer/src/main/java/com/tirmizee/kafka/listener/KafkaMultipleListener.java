package com.tirmizee.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(id = "multi",groupId = "multi", topics = "${kafka.topic.topic4}")
public class KafkaMultipleListener {

	private final Logger logger = LoggerFactory.getLogger(KafKaStringConsumerImpl.class);
	
	@KafkaHandler
	public void listen(String foo) {
		 logger.info(String.format("Message recieved 1 -> %s", foo));
	}

}
