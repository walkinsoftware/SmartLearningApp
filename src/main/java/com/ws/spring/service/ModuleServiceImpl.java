package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Module;
import com.ws.spring.repository.ModuleRepository;

@Service
public class ModuleServiceImpl {
	
	@Autowired
	ModuleRepository moduleRepository;

	public Module createModule(Module module) {
		return moduleRepository.save(module);
	}

	public Module updateModule(Module module) {
		return moduleRepository.save(module);
	}

	public Module queryModuleByModuleId(long moduleId) {
		return moduleRepository.findModuletByModuleId(moduleId);
	}
	public Module queryModuleByModuleName(String moduleName) {
		return moduleRepository.findModuleByModuleName(moduleName);
	}

	public Module queryModuleByAccessLevel(long accessLevel) {
		return moduleRepository.findModuleByAccessLevel(accessLevel);
	}

	public List<Module> queryAllModules() {
		return moduleRepository.findAll();
	}


}
