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
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaObjectProducerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	@Bean(name = "producerJsonConfig")
	public Map<String, Object> producerJsonConfig() {
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    return producerConfig;
	}
	
	@Bean(name = "producerJsonFactory")
	public ProducerFactory<String, Object> producerJsonFactory() {
		return new DefaultKafkaProducerFactory<>(producerJsonConfig());
	}
	
	@Bean(name = "kafkaJsonTemplate")
	public KafkaTemplate<String, Object> kafkaJsonTemplate() {
		return new KafkaTemplate<>(producerJsonFactory());
	}
	
}
