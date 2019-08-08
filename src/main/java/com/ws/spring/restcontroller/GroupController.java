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

import com.ws.spring.model.Group;
import com.ws.spring.service.GroupServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/group")
@Api(value = "Group Management System", tags = "Operations pertaining to Group in Group Management System")
public class GroupController {
	
	@Autowired
	GroupServiceImpl groupService;

	@PostMapping("/v1/createGroup")
	ResponseEntity<String> createGroup(@RequestBody Group group) {
		Group groupCreated = groupService.createGroup(group);
		return ResponseEntity.created(URI.create("/group/v1/queryGroupById/" + groupCreated.getGroupId())).body("");
	}

	@PostMapping("/v1/updateGroup")
	ResponseEntity<String> updateGroup(@RequestBody Group group) {
		Group groupCreated = groupService.updateGroup(group);
		return ResponseEntity.created(URI.create("/group/v1/queryGroupById/" + groupCreated.getGroupId())).body("");
	}

	@GetMapping("/v1/queryGroupById/{id}")
	ResponseEntity<Group> queryGroupByGroupId(@PathVariable long groupId) {
		Group group = groupService.queryGroupByGroupId(groupId);
		return ResponseEntity.ok().body(group);
	}


	@GetMapping("/v1/queryGroupByGroupName")
	ResponseEntity<Group> queryGroupByGroupName(@RequestParam("groupName") String groupName) {
		Group group = groupService.queryGroupByGroupName(groupName);
		return ResponseEntity.ok().body(group);
	}
	
	@GetMapping("/v1/queryGroupByAccesslevel")
	ResponseEntity<Group> queryGroupByAccesslevel(@RequestParam("accessLevel")long accessLevel) {
		Group group = groupService.queryGroupByAccessLevel(accessLevel);
		return ResponseEntity.ok().body(group);
	}

	@GetMapping("/v1/queryAllSGroups")
	ResponseEntity<List<Group>> queryAllGroups() {
		List<Group> groups = groupService.queryAllGroups();
		return ResponseEntity.ok().body(groups);
	}


}
