package com.bookapp.model;

import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

	public Publisher convertToEntity(PublisherDto publisherDto){
		Publisher publisher = new Publisher();
		publisher.setPublisherId(publisherDto.getPublisherId());
		publisher.setPublisherName(publisherDto.getPublisherName());
		return publisher;
	}
	public PublisherDto convertToDto(Publisher publisher){
		PublisherDto publisherDto = new PublisherDto();
		publisherDto.setPublisherId(publisher.getPublisherId());
		publisherDto.setPublisherName(publisher.getPublisherName());
		return publisherDto;
	}
}
