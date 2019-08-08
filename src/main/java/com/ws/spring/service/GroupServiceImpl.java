package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Group;
import com.ws.spring.repository.GroupRepository;

@Service
public class GroupServiceImpl {
	

	@Autowired
	GroupRepository groupRepository;

	public Group createGroup(Group group) {
		return groupRepository.save(group);
	}

	public Group updateGroup(Group group) {
		return groupRepository.save(group);
	}

	public Group queryGroupByGroupId(long groupId) {
		return groupRepository.findGroupByGroupId(groupId);
	}
	public Group queryGroupByGroupName(String groupName) {
		return groupRepository.findGroupByGroupName(groupName);
	}

	public Group queryGroupByAccessLevel(long accessLevel) {
		return groupRepository.findGroupByAccessLevel(accessLevel);
	}

	public List<Group> queryAllGroups() {
		return groupRepository.findAll();
	}


}
