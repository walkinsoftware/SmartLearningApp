package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

	Group findGroupByGroupId(long groupId);

	Group findGroupByGroupName(String groupName);

	Group findGroupByAccessLevel(long accessLevel);

	// void updateGroupByCollege(Set<Group> groups, College college);
}
