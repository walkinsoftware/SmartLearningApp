package com.ws.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

	Group findGroupByGroupId(long groupId);

	Group findGroupByGroupName(String groupName);

	Group findGroupByAccessLevel(long accessLevel);

	@Query("SELECT g FROM Group g WHERE g.college is null")
	List<Group> queryUnassociatedGroups();

	// void updateGroupByCollege(Set<Group> groups, College college);
}
