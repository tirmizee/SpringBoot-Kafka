package com.tirmizee.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;

import com.tirmizee.constants.KafkaConstants;

public interface KafKaStringConsumer {

	@KafkaListener(topics = "${kafka.topic.test}", groupId = KafkaConstants.GROUP_ID)
	void consume1(String payload);
	
	@KafkaListener(topics = "${kafka.topic.test}", groupId = "service.test-2")
	void consume2(String payload);
	
	@KafkaListener(topics = "${kafka.topic.test}", groupId = "service.test-3")
	void consume3(String payload) ;
	
	@KafkaListener(topics = "${kafka.topic.test}", groupId = "service.test-4")
	void consume4(String payload, String topic, int partition, int offset) ;
	
}
