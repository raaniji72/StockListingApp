package com.stackroute.Authentication.KafkaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
 
 
import com.stackroute.Authentication.entity.UserInfo;
import com.stackroute.Authentication.service.UserService;
import com.google.gson.Gson;
 
@Configuration
public class KafkaConsumer {
	
	@Autowired
	Gson gson;   //used for JSON serialization and deserialization
	
	@Autowired
	UserService authUserService;
 
	@KafkaListener(topics = "stockapp", groupId="group_id")  //configures a method to be a Kafka message listener
	 
	//Invoked whenever a message is received on the "stockapp" Kafka topic
	public void consume(String userMessage) {
		System.out.println("received message=" +userMessage);
		
		UserInfo userdata = gson.fromJson(userMessage, UserInfo.class); //Deserializing message 
		UserInfo result = authUserService.fetchUserDetails(userdata);
 
		System.out.println("Stored data in User Copy" + userdata.toString());

	}
}