package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Module;


@Repository
public interface ModuleRepository  extends JpaRepository<Module, String>{
	
Module findModuletByModuleId(long moduleId);
	
Module findModuleByModuleName(String moduleName);
	
Module findModuleByAccessLevel(long accessLevel);

}
