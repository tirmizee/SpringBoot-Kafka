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
	public void consume(String payload) {
        logger.info(String.format("Message recieved -> %s", payload));
    }
	
}
