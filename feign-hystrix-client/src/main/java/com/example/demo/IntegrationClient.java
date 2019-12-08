package com.example.demo;

import java.util.Arrays;



import java.util.List;
import java.util.Optional;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.AuthToken;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkills;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Project;
import com.example.demo.model.ProjectDescStake;
import com.example.demo.model.ProjectMember;
import com.example.demo.model.Skills;
import com.example.demo.model.Subtask;
import com.example.demo.model.Task;

import com.example.demo.service.ManagerService;
import com.example.demo.service.ProjectManagementServiceClient;
import com.example.demo.service.SubtaskService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {
	Logger log = LoggerFactory.getLogger(IntegrationClient.class);

	@Autowired
	private ProjectManagementServiceClient projectManagementServiceClient;

	@Autowired
	private SubtaskService subatskService;

	@Autowired
	private ManagerService managerService;
	
	

	// *************************SEARCHING AN
	// EMPLOYEE***********************************

	//Fallback
	public List<Employee> getAllEmployeesFallback() {
		System.out.println("=======Searching employeesFallback========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getAllEmployeesFallback")
	public List<Employee> getAllEmployees() {
		return this.projectManagementServiceClient.getAll();
	}

	// To get all employees by first name
	public List<Employee> getEmployeeFallback(String fname) {
		System.out.println("=======getEmployeeFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getEmployeeFallback")
	public List<Employee> getEmployees(String fname) {
		return this.projectManagementServiceClient.getData(fname);
	}

	// ******************************************************************

	// To fetch all Project Details
	//Fallback
	public List<Project> getProjectDetiailsFallback() {
		System.out.println("=======getProjectFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getProjectDetiailsFallback")
	public List<Project> getProjectDetiails() {
		return this.projectManagementServiceClient.getCompletedProjects();
	}

	// Fallback method
	public List<Project> findProjectByIdSQLFallback(Long theId) {
		System.out.println("=======getProjectFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "findProjectByIdSQLFallback")
	public List<Project> findProjectByIdSQL(Long theId) {
		System.out.println(theId);
		log.info("A1" + theId);
		return this.projectManagementServiceClient.findById(theId);
	}

	// Fallback method
	public List<ProjectDescStake> findProjectByIdMongoFallback(Long theId) {
		System.out.println("=======getProjectFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "findProjectByIdMongoFallback")
	public List<ProjectDescStake> findProjectByIdMongo(Long theId) {
		return this.projectManagementServiceClient.findByProjId(theId);
	}

	// Fallback method
	public List<Project> findprojectongoingFallback(Integer theYear) {
		System.out.println("Error fetching project by year");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "findprojectongoingFallback")
	public List<Project> findprojectongoing(Integer theYear) {
		return this.projectManagementServiceClient.findprojectongoing(theYear);
	}

	@HystrixCommand(fallbackMethod = "getProjectDetiailsFallback")
	public List<Project> getOngoingProjects() {
		return this.projectManagementServiceClient.getOngoingProjects();
	}

	@HystrixCommand(fallbackMethod = "findprojectongoingFallback")
	public List<Project> findprojectcompleted(Integer theYear) {
		return this.projectManagementServiceClient.findprojectcompleted(theYear);
	}

	// Fallback
	public List<Project> findlatestProjectFallback() {
		System.out.println("Error fetching latest projects");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "findlatestProjectFallback")
	public List<Project> findlatestProject() {
		return this.projectManagementServiceClient.findlatestProject();
	}

	// Fallback
	public int[] getProjectByYearFallback() {
		int a[] = new int[5];
		System.out.println("Error");
		return a;
	}

	@HystrixCommand(fallbackMethod = "getProjectByYearFallback")
	public int[] getProjectByYear() {
		return this.projectManagementServiceClient.getProjectByYear();

	}

	// Fallback
	public List<Project> getAllProjectsFallback() {
		System.out.println("======No projects======");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getAllProjectsFallback")
	public List<Project> getAllProjects() {
		return this.projectManagementServiceClient.getAllProjects();
	}

	// ******************************************************************

	// To access the project memebers
	public List<ProjectMember> getProjectMembersFallback(Long theid) {
		System.out.println("=======getProjectMembersFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getProjectMembersFallback")
	public List<ProjectMember> getAllProjectMembers(Long theid) {
		return this.projectManagementServiceClient.getAllProjectMember(theid);
	}

	// ******************************************************************

	// To fetch the subtasks

	

	//@HystrixCommand(fallbackMethod ="getAllSubtasksProjFallback" )
	public List<Subtask> getAllSubtasksProj(Long projectId, Long taskId)
	{
		log.info("Id" + projectId + "Taskid" + taskId);
		return this.projectManagementServiceClient.getAllSubtasksProj(projectId, taskId);
	}

	public List<Subtask> getAllSubtasksProjFallback(Long projectId, Long taskId)
	{
		System.out.println("=======getSubtasksFallback=========");
		return Arrays.asList();
	}

	// ******************************************************************

	// To fetch the tasks by projectId

	public List<Task> getTaskByProjectIdFallback(Long projectId) {
		System.out.println("=======getTasksFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getTaskByProjectIdFallback")
	public List<Task> getTaskByProjectId(Long projectId) {
		return this.projectManagementServiceClient.getTaskByProjectId(projectId);
	}

	// Fallback
	public List<Task> getAllTasksFallback() {
		System.out.println("=======getTasksFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getAllTasksFallback")
	public List<Task> getAllTasks() {
		return this.projectManagementServiceClient.getallTasks();
	}

	// ******************************************************************

	// SUBTASK PART VAISH-NISHA
	// Falback method
	public List<Subtask> getAllSubtaksFallback(Long empId) {
		System.out.println("=======getSubTasksFallback=========");
		System.out.println(empId);
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getAllSubtaksFallback")
	public List<Subtask> getAllSubtasks(Long empId) {
		return this.subatskService.getAllSubtasks(empId);
	}

	// Fallback
	public void updateProgressFallback(Long subtaskId, Long progressPercentage, String comment) {

		System.out.println("=======updateProgressFallback========");
	}

	@HystrixCommand(fallbackMethod = "updateProgressFallback")
	public void updateProgress(Long subtaskId, Long progressPercentage, String comment) {
		this.subatskService.updateProgress(subtaskId, progressPercentage, comment);
	}

	// **************************Manager's
	// part****************************************

	// Fallback
	public List<Employee> getManagersByAvailabilityFallback() {
		System.out.println("=======No managers available========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getManagersByAvailabilityFallback")
	public List<Employee> getManagersByAvailability() {
		return this.managerService.getManagersByAvailability();
	}

	// Fallback
	public List<Employee> getEmployeeBySkillsFallback(String skillName) {
		System.out.println("=======No employees available========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getEmployeeBySkillsFallback")
	public List<Employee> getEmployeeBySkills(String skillName) {
		return this.managerService.getEmployeeBySkills(skillName);
	}

	// Fallback
	public Project saveProjectFallback(Project project) {
		System.out.println("======Cannot save the project=====\nShowing an empty object");
		Project obj = new Project();
		return obj;
	}

	//@HystrixCommand(fallbackMethod = "saveProjectFallback")
	public Project saveProject(Project project) {
		System.out.println("inte");
		return this.managerService.saveProject(project);
	}

	// Fallback
	public Project getProjectByIdFallback(Long projectId) {
		System.out.println("======No projects======");
		Project obj = new Project();
		return obj;
	}

	@HystrixCommand(fallbackMethod = "getProjectByIdFallback")
	public Project getProjectById(Long projectId) {
		return this.managerService.getProjectById(projectId);
	}

	// Fallback
	public boolean completeProjectFallback(Project project) {
		System.out.println("======Completed Project Fallback=====");
		return false;
	}

	@HystrixCommand(fallbackMethod = "completeProjectFallback")
	public boolean completeProject(Project project) {
		return this.managerService.completeProject(project);
	}

	// Fallback
	public ProjectDescStake saveProjectDescFallback(ProjectDescStake projectDescStake) {
		System.out.println("=====Cannot save project Description======");
		ProjectDescStake obj = new ProjectDescStake();
		return obj;
	}

	@HystrixCommand(fallbackMethod = "saveProjectDescFallback")
	public ProjectDescStake saveProjectDesc(ProjectDescStake projectDescStake) {
		return this.managerService.saveProjectDesc(projectDescStake);
	}

	// Fallback
	public List<Skills> getAllSkillsFallback() {
		System.out.println("======No skills======");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getAllSkillsFallback")
	public List<Skills> getAllSkills() {
		return this.managerService.getAllSkills();

	}

	// Fallback
	public Task saveTaskFallback(Task task) {
		System.out.println("====Cannot save tasks====");
		Task obj = new Task();
		return obj;
	}

	@HystrixCommand(fallbackMethod = "saveTaskFallback")
	public Task saveTask(Task task) {
		return this.managerService.saveTask(task);
	}

	// Fallback
	public List<Task> getTaskByProjectIdManagerFallback(Long projectId) {
		System.out.println("======No tasks======");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getTaskByProjectIdManagerFallback")
	public List<Task> getTaskByProjectIdManager(Long projectId) {
		return this.managerService.getTaskByProjectId(projectId);
	}

	// Fallback
	public Subtask saveTaskFallback(Subtask stask) {
		System.out.println("====Error saving tasks=====");
		Subtask obj = new Subtask();
		return obj;
	}

	@HystrixCommand(fallbackMethod = "saveTaskFallback")
	public Subtask saveTask(Subtask stask) {
		return this.managerService.saveTask(stask);
	}

	// Fallback
	public List<Subtask> getSubTasksByTaskIdFallback(Long ltaskId) {
		System.out.println("======Error fetching subtasks======");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getSubTasksByTaskIdFallback")
	public List<Subtask> getSubTasksByTaskId(Long ltaskId) {
		return this.managerService.getSubTasksByTaskId(ltaskId);
	}
		
	
	public List<EmployeeSkills> getEmployeeSkills(Long employeeId)
	{
		return this.managerService.getEmployeeSkills(employeeId);
	}
		

	public List<Employee> getAllMembers()
	{
		return this.managerService.getAllMembers();
	}

	
	public void saveProjectMember(ProjectMember projectMember)
	{
		 this.managerService.saveProjectMember(projectMember);
	}
	

	
	public List<ProjectMember> getAll()
	{
		return this.managerService.getAll();
	}
	
	
	public List<ProjectMember> getAllMembersOfAProject(Long project)
	{
		return this.managerService.getAllMembersOfAProject(project);
	}

}
