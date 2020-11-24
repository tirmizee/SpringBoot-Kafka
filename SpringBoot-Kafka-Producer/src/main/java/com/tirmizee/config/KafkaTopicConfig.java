package com.tirmizee.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic topicTest() {
		return new NewTopic("test", 4, (short) 1);
	}
	
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("topic-1").build();
	}

	@Bean
	public NewTopic topic2() {
		return TopicBuilder.name("topic-2").build();
	}
	
	@Bean
	public NewTopic topic3() {
		return TopicBuilder.name("topic-3").build();
	}

}
