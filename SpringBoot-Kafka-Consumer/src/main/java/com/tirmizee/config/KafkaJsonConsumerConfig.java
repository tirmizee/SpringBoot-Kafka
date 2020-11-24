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

import com.tirmizee.model.Payload;

@Configuration
public class KafkaJsonConsumerConfig {

	@Value("${spring.kafka.consumer.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	@Bean(name = "jsonConsumerConfig")
	public Map<String, Object> jsonConsumerConfig() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		return config;
	}
	
	@Bean(name = "jsonConsumerFactory")
	public ConsumerFactory<String, Payload> jsonConsumerFactory() {
		StringDeserializer stringDeserializer = new StringDeserializer();
		JsonDeserializer<Payload> jsonDeserializer = new JsonDeserializer<>(Payload.class);
		return new DefaultKafkaConsumerFactory<>(jsonConsumerConfig(), stringDeserializer, jsonDeserializer);
	}
	
	@Bean(name = "jsonListenerContainerFactory")
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Payload>> kafkaObjectListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Payload> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(jsonConsumerFactory());
		return factory;
	}
	
}
