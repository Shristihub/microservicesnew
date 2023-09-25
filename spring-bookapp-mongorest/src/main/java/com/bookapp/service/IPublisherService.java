package com.bookapp.service;

import com.bookapp.model.Publisher;
import com.bookapp.model.PublisherDto;

public interface IPublisherService {
	Publisher addPublisher(PublisherDto publisherDto);
}