package com.tirmizee;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootKafkaProviderApplication implements CommandLineRunner {

	public static final Logger LOG = LoggerFactory.getLogger(SpringBootKafkaProviderApplication.class);
	
	@Autowired
    private ApplicationContext appContext;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProviderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
        	LOG.info("bean -> {}", bean);
        }
		
	}

}
