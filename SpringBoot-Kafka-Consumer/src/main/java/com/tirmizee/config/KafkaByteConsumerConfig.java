package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class KafkaByteConsumerConfig {
	
	@Value("${spring.application.name}")
	public String applicationName;
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	@Bean(name = "byteConsumerConfig")
	public Map<String, Object> byteConsumerConfig() {
	    Map<String, Object> consumerConfig = new HashMap<>();
	    consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
	    consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
	    consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, applicationName);
	    return consumerConfig;
	}
	
	@Bean(name = "byteConsumerFactory")
	public ConsumerFactory<String, byte[]> byteConsumerFactory() {
		return new DefaultKafkaConsumerFactory<>(byteConsumerConfig());
	}
	
	@Bean(name = "byteListenerContainerFactory")
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, byte[]>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(byteConsumerFactory());
		return factory;
	}
	
}
