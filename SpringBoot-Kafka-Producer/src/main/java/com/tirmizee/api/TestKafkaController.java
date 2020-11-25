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
import com.tirmizee.model.Payload.Inner;

@RestController
@RequestMapping(path = "/kafka")
public class TestKafkaController {
	
	public static final Logger LOG = LoggerFactory.getLogger(TestKafkaController.class);
	
	@Autowired
	@Qualifier("kafkaStringTemplate")
	private KafkaTemplate<String, String> kafkaStringTemplate;
	
	@Autowired
	@Qualifier("kafkaJsonTemplate")
	private KafkaTemplate<String, Object> kafkaJsonTemplate;
	
	@Autowired
	@Qualifier("kafkaByteTemplate")
	private KafkaTemplate<String, byte[]> kafkaByteTemplate;
	
	@GetMapping(path = "/publish/{message}")
	public String publish(@PathVariable String message) throws InterruptedException, ExecutionException {
		Payload payload = new Payload();
		payload.setId(123L);
		payload.setMessage(message);
		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaStringTemplate.send(KafkaConstants.TOPIC_NAME, message);
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
	
	@GetMapping(path = "/publish/object/{message}")
	public String publishObject(@PathVariable String message) throws InterruptedException, ExecutionException {
		Payload payload = new Payload();
		payload.setId(123L);
		payload.setMessage(message);
		Inner inner = payload.new Inner();
		inner.setId(555L);
		inner.setMessage("sssss");
		payload.setInner(inner);
		ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaJsonTemplate.send("topic-1", payload);
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
	
	@GetMapping(path = "/publish/json/{message}")
	public String publishJson(@PathVariable String message) throws InterruptedException, ExecutionException {
		Payload payload = new Payload();
		payload.setId(123L);
		payload.setMessage(message);
		Inner inner = payload.new Inner();
		inner.setId(555L);
		inner.setMessage("sssss");
		payload.setInner(inner);
		ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaJsonTemplate.send("topic-2", payload);
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
	
	@GetMapping(path = "/publish/byte")
	public String publishByte() throws InterruptedException, ExecutionException {
		ListenableFuture<SendResult<String, byte[]>> listenableFuture = kafkaByteTemplate.send("topic-3", new byte[] {89,90});
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
	
	@GetMapping(path = "/publish/multi")
	public String publishMulti() throws InterruptedException, ExecutionException {
		ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaJsonTemplate.send("topic-4", 333);
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
