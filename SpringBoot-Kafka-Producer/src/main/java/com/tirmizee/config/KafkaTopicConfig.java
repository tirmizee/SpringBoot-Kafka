package com.tirmizee.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;

import lombok.Setter;

@Setter
@Configuration
@ConfigurationProperties("kafka.topic")
@PropertySource("classpath:kafka.properties")
public class KafkaTopicConfig {

	public String test;
	public String topic1;
	public String topic2;
	public String topic3;
	
	@Bean
	public NewTopic topicTest() {
		return new NewTopic(test, 4, (short) 1);
	}
	
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name(topic1).build();
	}

	@Bean
	public NewTopic topic2() {
		return TopicBuilder.name(topic2).build();
	}
	
	@Bean
	public NewTopic topic3() {
		return TopicBuilder.name(topic3).build();
	}

}
