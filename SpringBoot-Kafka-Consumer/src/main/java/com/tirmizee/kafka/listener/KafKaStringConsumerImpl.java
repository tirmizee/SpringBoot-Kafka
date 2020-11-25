package com.tirmizee.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
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
	public void consume4(@Payload String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.OFFSET) int offset) {
        logger.info(String.format("Message recieved 4 -> %s topic -> %s partition -> %s offset -> %s", message, topic, partition, offset));
    }
	
}
