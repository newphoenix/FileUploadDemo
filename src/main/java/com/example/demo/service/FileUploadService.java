package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserForm;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileUploadService {

	public String save(UserForm userForm) {

		log.info("name : {}", userForm.getName());
		log.info("surname : {}", userForm.getSurname());
		
	    userForm.getFiles().forEach(f -> {

	        log.info("""
	             file name : {}
	             original name: {}
	             size: {}
	            """, //
	            f.getName(), //
	            f.getOriginalFilename(), //
	            f.getSize());

	      });
	    
		return "OK";
	}

}
