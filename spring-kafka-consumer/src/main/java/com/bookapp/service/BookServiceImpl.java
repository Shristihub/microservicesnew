package com.bookapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements IBookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	private static final String topic = "MyTopic";
	private String mymessage;
	
	// pass the list of topics to be listened to
	@KafkaListener(topics = {topic})
	public void consumeMessage(String message) {
		logger.info(String.format("#### -> Consumed message -> %s", message));
		mymessage= message;
	}

	@Override
	public String getMessage() {
		return mymessage;
	}

}
