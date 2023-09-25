package com.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.Publisher;
import com.bookapp.model.PublisherDto;
import com.bookapp.model.PublisherMapper;
import com.bookapp.repository.IPublisherRepository;

@Service
public class PublisherServiceImpl implements IPublisherService{
	
	@Autowired
	private IPublisherRepository publisherRepository;
	
	@Autowired
	private PublisherMapper publisherMapper;

	@Override
	public Publisher addPublisher(PublisherDto publisherDto) {
		return publisherRepository.insert(publisherMapper.convertToEntity(publisherDto));
	}

	
}
