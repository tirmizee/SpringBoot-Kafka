package com.tirmizee.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafKaStringConsumerImpl implements KafKaStringConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafKaStringConsumerImpl.class);
	
	@Override
	public void consume1(String payload) {
        logger.info(String.format("Message recieved 1 -> %s", payload));
    }
	
	@Override
	public void consume2(String payload) {
        logger.info(String.format("Message recieved 2 -> %s", payload));
    }
	
	@Override
	public void consume3(String payload) {
        logger.info(String.format("Message recieved 3 -> %s", payload));
    }
	
	@Override
	public void consume4(String payload, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        logger.info(String.format("Message recieved 4 -> %s topic -> %s", payload, topic));
    }
	
}
