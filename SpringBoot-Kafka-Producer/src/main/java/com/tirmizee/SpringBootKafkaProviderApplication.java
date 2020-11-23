package com.tirmizee;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootKafkaProviderApplication {

	public static final Logger LOG = LoggerFactory.getLogger(SpringBootKafkaProviderApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProviderApplication.class, args);
	}
		
	@Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {
        	String[] beans = appContext.getBeanDefinitionNames();
            Arrays.sort(beans);
            for (String bean : beans) {
            	LOG.info("bean -> {}", bean);
            }
        };
    }
	
}
