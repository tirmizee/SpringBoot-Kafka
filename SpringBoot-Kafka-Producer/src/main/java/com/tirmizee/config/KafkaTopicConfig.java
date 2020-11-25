package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.Setter;

@Setter
@Configuration
@ConfigurationProperties("kafka.topic")
@PropertySource("classpath:kafka.properties")
public class KafkaTopicConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	public String test;
	public String topic1;
	public String topic2;
	public String topic3;
	public String topic4;
	
	@Bean
	public KafkaAdmin admin() {
		Map<String, Object> config = new HashMap<>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		return new KafkaAdmin(config);
	}
	
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
	
	@Bean
	public NewTopic topic4() {
		return TopicBuilder.name(topic4).build();
	}

//	@Bean
//	public NewTopic topic1() {
//	    return TopicBuilder.name("thing1")
//	            .partitions(10)
//	            .replicas(3)
//	            .compact()
//	            .build();
//	}
	
}
