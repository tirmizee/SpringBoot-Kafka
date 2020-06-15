package com.tirmizee;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import com.tirmizee.constants.KafkaConstants;

@SpringBootApplication
public class SpringBootKafkaProviderApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProviderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		KafkaTemplate<String, String> kafkaTemplate = applicationContext.getBean(KafkaTemplate.class);
		TaskExecutor  executor = new ConcurrentTaskExecutor(
				Executors.newFixedThreadPool(20));
		
		
		for (int i = 0; i < 500000; i++) {
			executor.execute(() ->{
				kafkaTemplate.send(KafkaConstants.TOPIC_NAME, "hello");
			});
			
		}
		
		System.out.println("finish");
		
	}

}
