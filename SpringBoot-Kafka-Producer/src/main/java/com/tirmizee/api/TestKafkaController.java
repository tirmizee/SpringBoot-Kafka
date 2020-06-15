package com.tirmizee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.constants.KafkaConstants;

@RestController
@RequestMapping(path = "/kafka")
public class TestKafkaController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping(path = "/publish/{message}")
	public String publish(@PathVariable String message) {
		kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message);
		return "success";
	}

}
