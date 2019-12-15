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
public class ProjectControllerTest {
	
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
	public void verifyAllProjectList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getProjects").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}
	
	@Test
	public void verifyProjectById() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/api/getProjects/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].projectId").exists())
		.andExpect(jsonPath("$[0].name").exists())
		.andExpect(jsonPath("$[0].startDate").exists())
		.andExpect(jsonPath("$[0].endDate").exists())
		.andExpect(jsonPath("$[0].githubLink").exists())
		.andExpect(jsonPath("$[0].budget").exists())
		.andExpect(jsonPath("$[0].completed").exists())
		.andExpect(jsonPath("$[0].managerId").exists())
		.andExpect(jsonPath("$[0].projectId").value(1))
		.andExpect(jsonPath("$[0].name").value("Gym management System"))
		.andExpect(jsonPath("$[0].startDate").value("2016-09-24T00:00:00.000+0000"))
		.andExpect(jsonPath("$[0].endDate").value("2018-04-20T00:00:00.000+0000"))
		.andExpect(jsonPath("$[0].githubLink").value("https://github.com/sonalikarkera/FSD-Maven"))
		.andExpect(jsonPath("$[0].budget").value(20000))
		.andExpect(jsonPath("$[0].completed").value(true))
		.andExpect(jsonPath("$[0].managerId.employeeId").value(2))
		.andDo(print());
	}
	
	@Test
	public void verifyAllCompletedProjectList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getProjects/completed").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}
	
	@Test
	public void verifyAllOngoingProjectList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getProjects/ongoing").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}
	
	@Test
	public void verifyAllOngoingProjectByYear() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/OngoingByYear/2017").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}
	
	@Test
	public void verifyAllCompletedProjectByYear() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/CompletedByYear/2017").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	
	@Test
	public void verifyAllLatestProject() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getLatest").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}
	
	@Test
	public void verifyAllMongoProjectById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getProjects/mongodb/2").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}
	
	@Test
	public void verifyAllProjectYear() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getByYear").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5))).andDo(print());
	}
	
	


}
