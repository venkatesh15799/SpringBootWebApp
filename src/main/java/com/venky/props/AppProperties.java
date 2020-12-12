package com.venky.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
/*
 * App Properties,its used to take avoiding hard coding in 
 * ContactController java class we need take prefix for phonebook,
 * key for messages, key,value as pair in application.yml file
 * @EnableConfigurationProperties is used to read directly yml file
 * by passing prefix
 * @Configuration by declaring this our class as SpringBean Class
 */
@Data
@ConfigurationProperties(prefix = "phonebook")
@EnableConfigurationProperties
@Configuration
public class AppProperties {
	private Map<String,String> messages=new HashMap<>();

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	
}
