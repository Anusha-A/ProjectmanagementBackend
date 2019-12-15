package com.example.demo.controller;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.demo.SpringIbmProjectApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringIbmProjectApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeControllerTest {
	
	@Autowired
	private Environment env;
	private MockMvc mockMvc;
	Logger log = LoggerFactory.getLogger(ProjectControllerTest.class);
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        log.info("context loaded sucessfully... Listening on port: "+env.getProperty("server.port"));
	}
	
	@Test
	public void verifyAllEmployeeList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/search").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(16))).andDo(print());
	}
	
	@Test
	public void verifyAllEmployeeBySearch() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/search/Anusha").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	

}
