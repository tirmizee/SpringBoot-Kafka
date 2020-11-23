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

@Configuration
public class KafkaConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	public String kafkaBootstrapServer;

	@Bean(name = "consumerStringConfig")
	public Map<String, Object> consumerStringConfig() { 
		Map<String, Object> consumerConfig = new HashMap<>();
		consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return consumerConfig;
	}
	
	@Bean(name = "consumerStringFactory")
	public ConsumerFactory<String, String> consumerStringFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerStringConfig());
	}

	@Bean(name = "kafkaListenerContainerFactory")
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerStringFactory());
		return factory;
	}
	
}
