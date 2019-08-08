package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ws.spring.model.Topic;


@Repository
public interface TopicRepository  extends JpaRepository<Topic, String> {
	
	Topic findTopicByTopicId(long topicId);
	
	Topic findTopicByTopicName(String topicName);
	
	Topic findTopicByAccessLevel(long accessLevel);

}
