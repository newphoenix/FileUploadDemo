package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.validation.AllowedExtension;
import com.example.demo.validation.DocumentTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
	
 @NotBlank	
 private String name;
 @NotBlank
 private String surname;
 
 @NotEmpty
 private List<@AllowedExtension(
		  enumClazz = DocumentTypes.class,
		  message ="Wrong file extension"
		 ) MultipartFile> files;

}
