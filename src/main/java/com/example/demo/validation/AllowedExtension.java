package com.example.demo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE_USE})
@Constraint(validatedBy = AllowedExtensionImpl.class)
public @interface AllowedExtension {
	
	Class<? extends Enum<?>> enumClazz();
	
    String message() default "Not allowed extension";  
    
    Class<?>[] groups() default {};  
  
    Class<? extends Payload>[] payload() default {};  

}
