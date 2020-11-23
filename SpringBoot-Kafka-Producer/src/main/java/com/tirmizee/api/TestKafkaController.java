package com.tirmizee.api;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.constants.KafkaConstants;
import com.tirmizee.model.Payload;

@RestController
@RequestMapping(path = "/kafka")
public class TestKafkaController {
	
	public static final Logger LOG = LoggerFactory.getLogger(TestKafkaController.class);
	
	@Autowired
	@Qualifier("kafkaStringTemplate")
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	@Qualifier("kafkaStringTemplate")
	private KafkaTemplate<String, String> kafkaJsonTemplate;
	
	@GetMapping(path = "/publish/{message}")
	public String publish(@PathVariable String message) throws InterruptedException, ExecutionException {
		Payload payload = new Payload();
		payload.setId(123L);
		payload.setMessage(message);
		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message);
		listenableFuture.addCallback(
			result -> {
				LOG.info("RecordMetadata partition -> {}", result.getRecordMetadata().partition());
				LOG.info("RecordMetadata checksum -> {}", result.getRecordMetadata().checksum());
				LOG.info("RecordMetadata offset -> {}", result.getRecordMetadata().offset());
				LOG.info("ProducerRecord key -> {}", result.getProducerRecord().key());
				LOG.info("ProducerRecord topic -> {}", result.getProducerRecord().topic());
			},
			ex -> {
				
			}
		);
		System.out.println("success");
		return "success";
	}
	
	@GetMapping(path = "/publish/string/{message}")
	public String publishString(@PathVariable String message) throws InterruptedException, ExecutionException {
		Payload payload = new Payload();
		payload.setId(123L);
		payload.setMessage(message);
		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaJsonTemplate.send(KafkaConstants.TOPIC_NAME, message);
		listenableFuture.addCallback(
			result -> {
				LOG.info("RecordMetadata partition -> {}", result.getRecordMetadata().partition());
				LOG.info("RecordMetadata checksum -> {}", result.getRecordMetadata().checksum());
				LOG.info("RecordMetadata offset -> {}", result.getRecordMetadata().offset());
				LOG.info("ProducerRecord key -> {}", result.getProducerRecord().key());
				LOG.info("ProducerRecord topic -> {}", result.getProducerRecord().topic());
			},
			ex -> {
				
			}
		);
		System.out.println("success");
		return "success";
	}
	
}
