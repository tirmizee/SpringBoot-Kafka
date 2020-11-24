package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaByteProducerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	public String kafkaBootstrapServer;
	
	@Bean(name = "producerByteConfig")
	public Map<String, Object> producerByteConfig() {
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
	    return producerConfig;
	}
	
	@Bean(name = "producerByteFactory")
	public ProducerFactory<String, byte[]> producerByteFactory() {
		return new DefaultKafkaProducerFactory<>(producerByteConfig());
	}
	
	@Bean(name = "kafkaByteTemplate")
	public KafkaTemplate<String, byte[]> kafkaByteTemplate() {
		return new KafkaTemplate<>(producerByteFactory());
	}
	
}
