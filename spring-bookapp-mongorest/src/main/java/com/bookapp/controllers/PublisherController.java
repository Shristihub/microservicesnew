package com.bookapp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Publisher;
import com.bookapp.model.PublisherDto;
import com.bookapp.service.IPublisherService;

@RestController
@RequestMapping("/publisher-api/v1")
public class PublisherController {

	private IPublisherService publisherService;
		
	public PublisherController(IPublisherService publisherService) {
		super();
		this.publisherService = publisherService;
	}

	@PostMapping("/publishers")
	public Publisher addPublisher(@RequestBody PublisherDto publisherDto) {
		return publisherService.addPublisher(publisherDto);
	}
}
