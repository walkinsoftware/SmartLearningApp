package com.ws.spring.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.spring.model.Topic;
import com.ws.spring.service.TopicServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/topic")
@Api(value = "Topic Management System", tags = "Operations pertaining to Topic in Topic Management System")

public class TopicController {
	
	@Autowired
	TopicServiceImpl topicService;

	@PostMapping("/v1/createTopic")
	ResponseEntity<String> createTopic(@RequestBody Topic topic) {
		Topic topicCreated = topicService.createTopic(topic);
		return ResponseEntity.created(URI.create("/topic/v1/querytopicById/" + topicCreated.getTopicId())).body("");
	}

	@PostMapping("/v1/updateTopic")
	ResponseEntity<String> updateTopic(@RequestBody Topic topic) {
		Topic topicCreated = topicService.updateTopic(topic);
		return ResponseEntity.created(URI.create("/topic/v1/queryTopicById/" + topicCreated.getTopicId())).body("");
	}

	@GetMapping("/v1/queryTopicById/{id}")
	ResponseEntity<Topic> queryTopicByTopicId(@PathVariable long topicId) {
		Topic topic =topicService.queryTopicByTopicId(topicId);
		return ResponseEntity.ok().body(topic);
	}

	@GetMapping("/v1/queryTopicByTopicName")
	ResponseEntity<Topic> queryTopicByTopicName(@RequestParam("topicName") String topicName) {
		Topic topic = topicService.queryTopicByTopicName(topicName);
		return ResponseEntity.ok().body(topic);
	}

	@GetMapping("/v1/queryTopicByAccessLevel")
	ResponseEntity<Topic> queryStudentByAccessLevel(@RequestParam("accessLevel") long accessLevel) {
		Topic topic = topicService.queryTopicByAccessLevel(accessLevel);
		return ResponseEntity.ok().body(topic);
	}

	@GetMapping("/v1/queryAllTopics")
	ResponseEntity<List<Topic>> queryAllTopics() {
		List<Topic> topics = topicService.queryAllTopics();
		return ResponseEntity.ok().body(topics);
	}


}
