package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
class FileUploadDemoApplicationTests {

	
	private static final String URL = "/files";
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHappyPath() throws Exception {
		
		Path testFile = Paths.get("forRunningTests"+File.separator+"aster.jpg");  
		Resource file=  new FileSystemResource(testFile.toFile());
		
	    Path testFile2 = Paths.get("forRunningTests"+File.separator+"lilium.jpg");   
	    Resource file2 =  new FileSystemResource(testFile2.toFile());
		
	    MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
	    form.add("name", "Jason");
	    form.add("surname", "Reef");
	    
	    MockMultipartFile multipartFile1 = new MockMultipartFile("files",file.getFilename(),null,file.getInputStream());
	    MockMultipartFile multipartFile2 = new MockMultipartFile("files",file2.getFilename(),null,file2.getInputStream());

	    mockMvc.perform(multipart(HttpMethod.POST, URL)
	            .file(multipartFile1)
	            .file(multipartFile2)
	            .params(form))
	            .andExpect(status().isCreated())
	            .andExpect(jsonPath("$.result", is("OK")));
	    
	}

}
