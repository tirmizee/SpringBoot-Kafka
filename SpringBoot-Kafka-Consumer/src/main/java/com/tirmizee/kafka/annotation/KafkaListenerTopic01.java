package com.tirmizee.kafka.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import com.tirmizee.constants.KafkaConstants;

@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@KafkaListener(topics = KafkaConstants.TOPIC_01, groupId = "reflectoring-group-1")
public @interface KafkaListenerTopic01 {
	
	@AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
	String containerFactory() default "";

}
