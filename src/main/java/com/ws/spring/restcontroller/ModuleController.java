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

import com.ws.spring.model.Module;
import com.ws.spring.service.ModuleServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/module")
@Api(value = "Module Management System", tags = "Operations pertaining to Module in Module Management System")
public class ModuleController {
	
	@Autowired
	ModuleServiceImpl moduleService;

	@PostMapping("/v1/createModule")
	ResponseEntity<String> createModule(@RequestBody Module module) {
		Module moduleCreated = moduleService.createModule(module);
		return ResponseEntity.created(URI.create("/module/v1/queryModuleById/" + moduleCreated.getModuleId())).body("");
	}

	@PostMapping("/v1/updateModule")
	ResponseEntity<String> updateModule(@RequestBody Module module) {
		Module moduleCreated = moduleService.updateModule(module);
		return ResponseEntity.created(URI.create("/module/v1/queryModuleById/" + moduleCreated.getModuleId())).body("");
	}

	@GetMapping("/v1/queryModuleById/{id}")
	ResponseEntity<Module> queryModuleByModuleId(@PathVariable long moduleId) {
		Module module = moduleService.queryModuleByModuleId(moduleId);
		return ResponseEntity.ok().body(module);
	}

	@GetMapping("/v1/queryModuleByModuleName")
	ResponseEntity<Module> queryModuleByModuleName(@RequestParam("moduleName") String moduleName) {
		Module module = moduleService.queryModuleByModuleName(moduleName);
		return ResponseEntity.ok().body(module);
	}

	@GetMapping("/v1/queryModuleByAccessLevel")
	ResponseEntity<Module> queryModuleByAccessLevel(@RequestParam("accessLevel") long accessLevel) {
		Module module = moduleService.queryModuleByAccessLevel(accessLevel);
		return ResponseEntity.ok().body(module);
	}

	@GetMapping("/v1/queryAllModules")
	ResponseEntity<List<Module>> queryAllModules() {
		List<Module> modules = moduleService.queryAllModules();
		return ResponseEntity.ok().body(modules);
	}


}
