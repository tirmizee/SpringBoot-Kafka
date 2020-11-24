package com.tirmizee.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tirmizee.constants.KafkaConstants;

@Service
public class KafKaStringConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafKaStringConsumer.class);
	
	@KafkaListener(topics = KafkaConstants.TOPIC_TEST, groupId = KafkaConstants.GROUP_ID)
	public void consume1(String payload) {
        logger.info(String.format("Message recieved 1 -> %s", payload));
    }
	
	@KafkaListener(topics = KafkaConstants.TOPIC_TEST, groupId = "service.test-2")
	public void consume2(String payload) {
        logger.info(String.format("Message recieved 2 -> %s", payload));
    }
	
	@KafkaListener(topics = KafkaConstants.TOPIC_TEST, groupId = "service.test-3")
	public void consume3(String payload) {
        logger.info(String.format("Message recieved 3 -> %s", payload));
    }
	
	@KafkaListener(topics = KafkaConstants.TOPIC_TEST, groupId = "service.test-4")
	public void consume4(String payload) {
        logger.info(String.format("Message recieved 4 -> %s", payload));
    }
	
}
