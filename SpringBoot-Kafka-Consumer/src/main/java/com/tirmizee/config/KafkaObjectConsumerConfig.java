package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaObjectConsumerConfig {

	public static final String DESERIALIZER_PACKAGE_SCAN = "com.tirmizee.model";
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	@Bean(name = "objectConsumerConfig")
	public Map<String, Object> objectConsumerConfig() {
	    Map<String, Object> consumerConfig = new HashMap<>();
	    consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
//	    consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "reflectoring-group-1");
	    consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    consumerConfig.put(JsonDeserializer.TRUSTED_PACKAGES, DESERIALIZER_PACKAGE_SCAN);
	    return consumerConfig;
	}
	

	@Bean(name = "objectConsumerFactory")
	public ConsumerFactory<String, String> objectConsumerFactory() {
		return new DefaultKafkaConsumerFactory<>(objectConsumerConfig());
	}
	
	@Bean(name = "objectListenerContainerFactory")
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaObjectListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(objectConsumerFactory());
		return factory;
	}

}
