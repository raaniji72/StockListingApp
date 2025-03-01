package com.stackroute.UserProfile.KafkaProducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducer {
 
	
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("stockapp").build();
	}
}
   