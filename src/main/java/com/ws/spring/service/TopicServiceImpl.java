package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Topic;
import com.ws.spring.repository.TopicRepository;

@Service
public class TopicServiceImpl {
	
	@Autowired
	TopicRepository topicRepository;

	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public Topic updateTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public Topic queryTopicByTopicId(long topicId) {
		return topicRepository.findTopicByTopicId(topicId);
	}
	public Topic queryTopicByTopicName(String topicName) {
		return topicRepository.findTopicByTopicName(topicName);
	}

	public Topic queryTopicByAccessLevel(long accessLevel) {
		return topicRepository.findTopicByAccessLevel(accessLevel);
	}

	public List<Topic> queryAllTopics() {
		return topicRepository.findAll();
	}


}
