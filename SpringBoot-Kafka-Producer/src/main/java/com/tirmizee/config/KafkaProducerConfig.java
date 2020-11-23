package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	@Bean
	public Map<String, Object> producerStringConfig() {
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    return producerConfig;
	}
	
	@Bean
	public ProducerFactory<String, String> producerStringFactory() {
		return new DefaultKafkaProducerFactory<>(producerStringConfig());
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaStringTemplate(){
		return new KafkaTemplate<>(producerStringFactory());
	}

}
