package com.tirmizee.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tirmizee.constants.KafkaConstants;

@Service
public class KafKaConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafKaConsumer.class);
	
	@KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID)
	public void consume(String message) {
        logger.info(String.format("Message recieved -> %s", message));
    }
	
}
