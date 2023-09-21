package com.bookapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements IBookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	private static final String topic = "MyTopic";
			
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public BookServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	
	public void showBooks() {
		logger.info(topic +"in service");
//		List<String> books = List.of("Java","Angular", "Spring");
		kafkaTemplate.send(topic, "T1", "Great Day");
		
	}

}
