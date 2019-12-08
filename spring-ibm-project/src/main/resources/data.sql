
insert into employee(availability, designation,email,first_name,last_name,middle_name,password,skills,user_type) 
values(true, 'Employee' , 'john@gmail.com', 'John', 'Doe' , 'David' ,'test123', 'Full stack', 'Regular');

insert into employee(availability, designation,email,first_name,last_name,middle_name,password,skills,user_type) 
values(true, 'Employee' , 'Adam@gmail.com', 'Adam', 'A' , 'Joe' ,'test123', 'Full stack', 'Regular');

insert into employee(availability, designation,email,first_name,last_name,middle_name,password,skills,user_type) 
values(true, 'Employee' , 'Rahul@gmail.com', 'Rahul', 'Dravid' , 'A' ,'test123', 'Full stack', 'Regular');


INSERT INTO project(project_desc, end_date, is_completed, project_name, stakeholders, start_date) VALUES('Project 1', '2019-9-9', FALSE, 'Name 1', 's1', '2019-1-1');

INSERT INTO project(project_desc, end_date, is_completed, project_name, stakeholders, start_date) VALUES('Project 2', '2019-9-9', FALSE, 'Name 2', 's1', '2019-1-1');

INSERT INTO project(project_desc, end_date, is_completed, project_name, stakeholders, start_date) VALUES('Project 3', '2019-9-9', FALSE, 'Name 3', 's1', '2019-1-1');

INSERT INTO project(project_desc, end_date, is_completed, project_name, stakeholders, start_date) VALUES('Project 4', '2019-9-9', FALSE, 'Name 4', 's1', '2019-1-1');


INSERT INTO task( description, due_date, progress, start_date, subtask_count, task_description, task_title, project_id)VALUES( 'task1', '2019-9-9', 50, '2019-1-1', 10, 'task1', 'do task1', 1);
INSERT INTO task( description, due_date, progress, start_date, subtask_count, task_description, task_title, project_id)VALUES( 'task2', '2019-9-9', 50, '2019-1-1', 10, 'task2', 'do task2',  2);
INSERT INTO task( description, due_date, progress, start_date, subtask_count, task_description, task_title, project_id)VALUES( 'task2', '2019-9-9', 50, '2019-1-1', 10, 'task3', 'do task3', 3);

INSERT INTO subtask(due_date, progress_percentage, start_date, sub_task_description, sub_task_title, employee_id, task_id) VALUES('2019-9-9', 10, '2019-1-1', 'do subtask1', 'subtask 1', 1, 1 );
INSERT INTO subtask(due_date, progress_percentage, start_date, sub_task_description, sub_task_title, employee_id, task_id) VALUES('2019-9-9', 10, '2019-1-1', 'do subtask2', 'subtask 2', 2, 1 );
INSERT INTO subtask(due_date, progress_percentage, start_date, sub_task_description, sub_task_title, employee_id, task_id) VALUES('2019-9-9', 10, '2019-1-1', 'do subtask1', 'subtask 3', 3, 1 );


INSERT INTO `project_member`(team_member_id, project_id) VALUES(1,1);
INSERT INTO `project_member`(team_member_id, project_id) VALUES(2,3);
INSERT INTO `project_member`(team_member_id, project_id) VALUES(3,2);
