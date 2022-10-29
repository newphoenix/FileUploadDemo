package com.example.demo.validation;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class AllowedExtensionImpl  implements ConstraintValidator<AllowedExtension, MultipartFile> {

	private List<String> allowedValues;
	
	@Override
	public void initialize(AllowedExtension constraintAnnotation) {

		allowedValues = Stream.of(constraintAnnotation.enumClazz().getEnumConstants())//
				.map(e -> e.toString().toLowerCase())//
				.toList();
	}
	
	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {

		String fileName = value.getOriginalFilename();
		return allowedValues.contains(fileName.substring(fileName.lastIndexOf(".") + 1));
	}

}
