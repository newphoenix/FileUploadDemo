package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FileUploadResponse;
import com.example.demo.dto.UserForm;
import com.example.demo.service.FileUploadService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("files")
@AllArgsConstructor
public class FileUploadController {
	
	private FileUploadService fileUploadService;
	
	@PostMapping
	public ResponseEntity<FileUploadResponse> uploadFiles(UserForm userForm){
		
		String result = fileUploadService.save(userForm);
		return new ResponseEntity<>(new FileUploadResponse(result),HttpStatus.CREATED);
	}

}
