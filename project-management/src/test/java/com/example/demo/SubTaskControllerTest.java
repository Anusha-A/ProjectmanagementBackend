package com.example.demo;


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

import com.example.demo.ProjectManagementApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  ProjectManagementApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubTaskControllerTest {
	
	@Autowired
	private Environment env;
	private MockMvc mockMvc;
	Logger log = LoggerFactory.getLogger(SubTaskControllerTest.class);
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        log.info("context loaded sucessfully... Listening on port: "+env.getProperty("server.port"));
	}
	
	@Test
	public void verifySubtaskList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getsubtasks/15").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	
	@Test
	public void verifySubtaskUpdate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/updateProgress/1/100/second commit")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"subtaskId\":\"1\",\"progressPercentage\":\"100\",\"comment\":\"second commit\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print());
	}

}
