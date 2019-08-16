package com.ws.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ws.spring.service.FileStorageService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "File Management System", tags = "Operations to File Upload System")
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName;
		try {
			fileName = fileStorageService.storeFile(file);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadFile/")
					.path(fileName)
					.toUriString();
			return fileDownloadUri;
		} catch (Exception e) {
			e.printStackTrace();
		}

// fileName, fileDownloadUri,       file.getContentType(), file.getSize()
        return "FAILED";
    }

}
