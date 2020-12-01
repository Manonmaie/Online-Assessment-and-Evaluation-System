DROP DATABASE oaes_assessment_db;
-- CREATE DATABASE oaes_assessment_db;
CREATE DATABASE oaes_assessment_db DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
USE oaes_assessment_db;

--
-- Database: `oaes_assessment_db`
--

-- --------------------------------------------------------
-- Table structure for table as_user
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_user(
  user_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_name varchar(255) UNIQUE NOT NULL,
  password varchar(255) NOT NULL,
  status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
  PRIMARY KEY(user_id)
);

-- --------------------------------------------------------
-- Data Entry for table `as_user`
-- --------------------------------------------------------
INSERT INTO as_user VALUES(0,"S1","abc","ACTIVE");
INSERT INTO as_user VALUES(0,"S2","xyz","ACTIVE");
INSERT INTO as_user VALUES(0,"person3@gmail.com","a","ACTIVE");
INSERT INTO as_user VALUES(0,"person4@gmail.com","a","ACTIVE");
INSERT INTO as_user VALUES(0,"person5@gmail.com","a","ACTIVE");

-- --------------------------------------------------------
-- Table structure for table as_role_master
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_role_master(
  role_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  role_name varchar(255) UNIQUE NOT NULL,
  module_name ENUM('AU', 'AS', 'EVAL', 'EA'),
  PRIMARY KEY(role_id)
);

-- --------------------------------------------------------
-- Data Entry for table `as_role_master`
-- --------------------------------------------------------
INSERT INTO as_role_master VALUES(0,"Examinee","AS");
INSERT INTO as_role_master VALUES(0,"Center Admin","AS");
INSERT INTO as_role_master VALUES(0,"Invizilator","AS");

-- --------------------------------------------------------
-- Table structure for table as_user_role
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_user_role(
  user_role_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_id int(10) unsigned,
  role_id int(10) unsigned,
  PRIMARY KEY(user_role_id)
);

ALTER TABLE as_user_role
  ADD CONSTRAINT `fk_as_user_role_user_id` FOREIGN KEY (user_id) REFERENCES as_user(user_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_as_user_role_role_id` FOREIGN KEY (role_id) REFERENCES as_role_master(role_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_user_role`
-- --------------------------------------------------------
INSERT INTO as_user_role VALUES(0,1,1);
INSERT INTO as_user_role VALUES(0,2,1);
INSERT INTO as_user_role VALUES(0,3,2);
INSERT INTO as_user_role VALUES(0,4,2);
INSERT INTO as_user_role VALUES(0,5,3);

-- --------------------------------------------------------
-- Table structure for table as_action_master
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_action_master(
  action_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  action_name varchar(255) UNIQUE NOT NULL,
  module_name ENUM('AU', 'AS', 'EVAL', 'EA'),
  PRIMARY KEY(action_id)
);

-- --------------------------------------------------------
-- Table structure for table as_role_action
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_role_action(
  role_action_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  role_id int(10) unsigned,
  action_id int(10) unsigned,
  PRIMARY KEY(role_action_id)
);

ALTER TABLE as_role_action
  ADD CONSTRAINT `fk_as_role_action_role_id` FOREIGN KEY (role_id) REFERENCES as_role_master(role_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_as_role_action_action_id` FOREIGN KEY (action_id) REFERENCES as_action_master(action_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_course_master`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_course_master (
  course_master_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  course_code varchar(255) CHARACTER SET utf8 COLLATE utf8_bin UNIQUE NOT NULL,
  course_name varchar(255) NOT NULL,
  PRIMARY KEY (course_master_id)
);

-- --------------------------------------------------------
-- Data Entry for table `as_course_master`
-- --------------------------------------------------------
INSERT INTO as_course_master VALUES(0,"MAT_Course","Mathematices");
INSERT INTO as_course_master VALUES(0,"PHY_Course","Physics");
INSERT INTO as_course_master VALUES(0,"CHEM_Course","Chemistry");

-- --------------------------------------------------------
-- Table structure for table as_examdrive
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_examdrive(
  examdrive_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  examdrive_code varchar(255) CHARACTER SET utf8 COLLATE utf8_bin UNIQUE NOT NULL,
  examdrive_name varchar(255) NOT NULL,
  status ENUM('NOT_STARTED','IN_PROGRESS','COMPLETED') DEFAULT 'NOT_STARTED',
  course_master_id int(10) unsigned,
  PRIMARY KEY (examdrive_id)
);

ALTER TABLE as_examdrive
  ADD CONSTRAINT `fk_as_examdrive_course_master_id` FOREIGN KEY (course_master_id) REFERENCES as_course_master(course_master_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table as_examdrive
-- --------------------------------------------------------
INSERT INTO as_examdrive VALUES(0,"Mid_Mat","Midsemester_Maths","IN_PROGRESS",1);
INSERT INTO as_examdrive VALUES(0,"Mid_Phy","Midsemester_Physics","IN_PROGRESS",2);
INSERT INTO as_examdrive VALUES(0,"Mid_Chem","Midsemester_Chemistry","IN_PROGRESS",3);

-- --------------------------------------------------------
-- Table structure for table as_examinee
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_examinee(
  examinee_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  examinee_code varchar(255) CHARACTER SET utf8 COLLATE utf8_bin UNIQUE NOT NULL,
  examinee_name varchar(255) NOT NULL,
  examinee_password varchar(255) NOT NULL,
  examinee_branch varchar(255),
  examinee_email varchar(255),
  examinee_college varchar(255),
  PRIMARY KEY(examinee_id)
);

-- --------------------------------------------------------
-- Data Entry for table as_examinee
-- --------------------------------------------------------
INSERT INTO as_examinee VALUES(0,"S1","ABC","abc","CSE","ABC@iiitb.org",'IIITB');
INSERT INTO as_examinee VALUES(0,"S2","XYZ","xyz",NULL,NULL,NULL);
INSERT INTO as_examinee VALUES(0,"S3","PQR","pqr","CSE","PQR@iiitb.org",'IITB');
INSERT INTO as_examinee VALUES(0,"S4","UVW","uvw",NULL,NULL,NULL);

-- --------------------------------------------------------
-- Table structure for table as_center
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_center(
  center_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  center_code varchar(255) CHARACTER SET utf8 COLLATE utf8_bin UNIQUE NOT NULL,
  center_name varchar(255) NOT NULL,
  center_capacity int(10) unsigned,
  PRIMARY KEY(center_id)
);

-- --------------------------------------------------------
-- Data Entry for table `as_center`
-- --------------------------------------------------------
INSERT INTO as_center VALUES(0,"CENTER_1","IIIT-Bangalore",1000);

-- --------------------------------------------------------
-- Table structure for table `as_batch`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_batch(
  batch_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  batch_code varchar(255) CHARACTER SET utf8 COLLATE utf8_bin UNIQUE NOT NULL,
  batch_start_time datetime NOT NULL,
  batch_end_time datetime NOT NULL,
  qp_status ENUM('PENDING','RECEIVED','ERROR_SENDING','SENT') DEFAULT 'PENDING',
  center_id int(10) unsigned,
  examdrive_id int(10) unsigned,
  qp_id int(10) unsigned,
  PRIMARY KEY (batch_id)
);

-- --------------------------------------------------------
-- Table structure for table `as_question_paper`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_question_paper(
  qp_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- qp_code varchar(255) UNIQUE NOT NULL,
  batch_id int(10) unsigned,
  maximum_marks float(24) NOT NULL DEFAULT 100,
  duration int(10) NOT NULL DEFAULT 180,
  PRIMARY KEY(qp_id)
);

ALTER TABLE as_question_paper
  ADD CONSTRAINT `fk_as_question_paper_batch_id` FOREIGN KEY (batch_id) REFERENCES as_batch(batch_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Alter Entry for table `as_batch`
-- --------------------------------------------------------
ALTER TABLE as_batch
  ADD CONSTRAINT `fk_as_batch_center_id` FOREIGN KEY (center_id) REFERENCES as_center(center_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_as_batch_examdrive_id` FOREIGN KEY (examdrive_id) REFERENCES as_examdrive(examdrive_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_as_batch_qp_id` FOREIGN KEY (qp_id) REFERENCES as_question_paper(qp_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_batch`
-- --------------------------------------------------------
INSERT INTO as_batch VALUES(0,"Mrng1","2020-12-01 07:00:00","2020-12-01 23:00:00","SENT",1,1,NULL);
INSERT INTO as_batch VALUES(0,"AfterNoon1","2020-09-28 14:00:00","2020-09-28 23:59:59","RECEIVED",1,2,NULL);
INSERT INTO as_batch VALUES(0,"Mrng2","2020-01-01 09:00:00","2020-01-01 12:00:00","SENT",1,3,NULL);
-- INSERT INTO as_batch VALUES(0,"Mrng3","2020-01-01 09:00:00","2020-01-01 12:00:00","SENT",1,3,NULL);
-- INSERT INTO as_batch VALUES(0,"Mrng4","2020-01-01 09:00:00","2020-01-01 12:00:00","SENT",1,3,NULL);

-- --------------------------------------------------------
-- Data Entry for table `as_question_paper`
-- --------------------------------------------------------
INSERT INTO as_question_paper VALUES(0,1,100,180);
-- INSERT INTO as_question_paper VALUES(0,"MAT_Paper_2",1,100,180);
INSERT INTO as_question_paper VALUES(0,2,50,120);
INSERT INTO as_question_paper VALUES(0,3,25,60);

-- --------------------------------------------------------
-- Update Data for table `as_batch`
-- --------------------------------------------------------
UPDATE as_batch SET qp_id = 1 WHERE batch_id = 1;
UPDATE as_batch SET qp_id = 2 WHERE batch_id = 2;
UPDATE as_batch SET qp_id = 3 WHERE batch_id = 3;

-- --------------------------------------------------------
-- Table structure for table `as_examinee_batch`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_examinee_batch (
  examinee_batch_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  examinee_batch_start_time datetime,
  examinee_batch_end_time datetime,
  examinee_batch_status ENUM('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED'),
  batch_id int(10) unsigned NOT NULL,
  examinee_id int(10) unsigned NOT NULL,
  -- PRIMARY KEY (examinee_id, batch_id)
  PRIMARY KEY (examinee_batch_id)
);

ALTER TABLE as_examinee_batch
  ADD CONSTRAINT `fk_as_examinee_batch_batch_id` FOREIGN KEY (batch_id) REFERENCES as_batch(batch_id) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_as_examinee_batch_examinee_id` FOREIGN KEY (examinee_id) REFERENCES as_examinee(examinee_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Data Entry for table as_examinee_batch
-- --------------------------------------------------------
INSERT INTO as_examinee_batch VALUES(0,null,null,"NOT_STARTED",1,1);
INSERT INTO as_examinee_batch VALUES(0,null,null,"NOT_STARTED",1,2);
INSERT INTO as_examinee_batch VALUES(0,null,null,"NOT_STARTED",1,3);
INSERT INTO as_examinee_batch VALUES(0,"2020-11-11 07:00:00","2020-11-11 23:00:00","COMPLETED",2,1);
INSERT INTO as_examinee_batch VALUES(0,"2020-11-11 07:00:00","2020-11-11 23:00:00","COMPLETED",2,2);
INSERT INTO as_examinee_batch VALUES(0,null,null,"NOT_STARTED",2,4);

-- --------------------------------------------------------
-- Table structure for table `as_invigilator`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_invigilator (
  invigilator_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  invigilator_code varchar(255) UNIQUE NOT NULL,
  invigilator_name varchar(255) NOT NULL,
  invigilator_email varchar(255) UNIQUE NOT NULL,
  invigilator_password varchar(255) NOT NULL,
  batch_id int(10) unsigned,
  user_status ENUM('ACTIVE', 'NOT_ACTIVE'),
  PRIMARY KEY (invigilator_id)
);

ALTER TABLE as_invigilator
  ADD CONSTRAINT `fk_as_invigilator_batch_id` FOREIGN KEY (batch_id) REFERENCES as_batch(batch_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_instruction`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_instruction(
  instruction_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  instruction_code varchar(255) UNIQUE NOT NULL,
  qp_id int(10) unsigned,
  instruction_text varchar(255) NOT NULL,
  PRIMARY KEY(instruction_id)
);

ALTER TABLE as_instruction
  ADD CONSTRAINT `fk_as_instruction_qp_id` FOREIGN KEY (qp_id) REFERENCES as_question_paper(qp_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_instruction`
-- --------------------------------------------------------
INSERT INTO as_instruction VALUES(0,"Mat_Ins_1",1,"Exam duration is 3 hrs");
INSERT INTO as_instruction VALUES(0,"Mat_Ins_2",1,"It has two sections");
INSERT INTO as_instruction VALUES(0,"Mat_Ins_3",1,"Each section contributes to 50% of the total marks");
INSERT INTO as_instruction VALUES(0,"Phy_Ins_1",2,"Exam duration is 2 hrs");
INSERT INTO as_instruction VALUES(0,"Phy_Ins_2",2,"It has only one section");
INSERT INTO as_instruction VALUES(0,"Chem_Ins_1",3,"Exam duration is 1 hr");
INSERT INTO as_instruction VALUES(0,"Chem_Ins_2",3,"It has only one section with no negative marking");

-- --------------------------------------------------------
-- Table structure for table `as_itemtype_master`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_itemtype_master (
  itemtype_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  itemtype_code varchar(255) UNIQUE NOT NULL,
  itemtype_name varchar(255) NOT NULL,
  itemtype_category ENUM('AUTO','MANUAL') DEFAULT 'MANUAL',
  PRIMARY KEY (itemtype_id)
);

-- --------------------------------------------------------
-- Table structure for table `as_qp_item`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_qp_item (
  qp_item_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- item_code varchar(255) UNIQUE NOT NULL,
  -- item_text varchar(511) NOT NULL,
  item_text text(1024) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER','UNDERSTAND','APPLY','ANALYZE','EVALUATE','CREATE'),
  qp_id int(10) unsigned,
  PRIMARY KEY (qp_item_id)
);

ALTER TABLE as_qp_item
  ADD constraint `fk_as_qp_item_qp_id` FOREIGN KEY (qp_id) REFERENCES as_question_paper(qp_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_qp_item`
-- --------------------------------------------------------
INSERT INTO as_qp_item VALUES(0,'<figure class="image"><img src="data:image/jpeg;base64,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"></figure> What is a database?',2,"McqSingleCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"What is a  PK?",1,"McqSingleCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"What is a FK?",2,"McqMultiCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"UK and PK are same.",1,"True/False","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Uk with no null values is Pk.",2,"True/False","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"What is a database?",2,"McqSingleCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"What is a  PK?",1,"McqSingleCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"What is a FK?",2,"McqMultiCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"UK and PK are same.",1,"True/False","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Uk with no null values is Pk.",2,"True/False","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"What is a database?",2,"McqSingleCorrect","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"What is a  PK?",1,"McqSingleCorrect","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"What is a FK?",2,"McqMultiCorrect","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"UK and PK are same.",1,"True/False","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"Uk with no null values is Pk.",2,"True/False","UNDERSTAND",2);

-- --------------------------------------------------------
-- Table structure for table `as_item_mcq_options`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_item_mcq_options(
  item_mcq_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- item_mcq_options_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  mcq_option_text varchar(255) NOT NULL,
  PRIMARY KEY(item_mcq_id)
);

ALTER TABLE as_item_mcq_options
  ADD constraint `as_item_mcq_options_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_item_mcq_options`
-- --------------------------------------------------------
INSERT INTO as_item_mcq_options VALUES(0,1,"Collection of related data");
INSERT INTO as_item_mcq_options VALUES(0,1,"Collection of data");
INSERT INTO as_item_mcq_options VALUES(0,1,"Collection of words");
INSERT INTO as_item_mcq_options VALUES(0,1,"Collection of people");
INSERT INTO as_item_mcq_options VALUES(0,2,"Primary Key");
INSERT INTO as_item_mcq_options VALUES(0,2,"Personal Key");
INSERT INTO as_item_mcq_options VALUES(0,2,"Person Key");
INSERT INTO as_item_mcq_options VALUES(0,2,"Primary Keyword");
INSERT INTO as_item_mcq_options VALUES(0,3,"Foreign Key");
INSERT INTO as_item_mcq_options VALUES(0,3,"Foreign Keyword");
INSERT INTO as_item_mcq_options VALUES(0,3,"Fashion Key");
INSERT INTO as_item_mcq_options VALUES(0,3,"Forward Key");
INSERT INTO as_item_mcq_options VALUES(0,6,"Collection of related data");
INSERT INTO as_item_mcq_options VALUES(0,6,"Collection of data");
INSERT INTO as_item_mcq_options VALUES(0,6,"Collection of words");
INSERT INTO as_item_mcq_options VALUES(0,6,"Collection of people");
INSERT INTO as_item_mcq_options VALUES(0,7,"Primary Key");
INSERT INTO as_item_mcq_options VALUES(0,7,"Personal Key");
INSERT INTO as_item_mcq_options VALUES(0,7,"Person Key");
INSERT INTO as_item_mcq_options VALUES(0,7,"Primary Keyword");
INSERT INTO as_item_mcq_options VALUES(0,8,"Foreign Key");
INSERT INTO as_item_mcq_options VALUES(0,8,"Foreign Keyword");
INSERT INTO as_item_mcq_options VALUES(0,8,"Fashion Key");
INSERT INTO as_item_mcq_options VALUES(0,8,"Forward Key");

-- --------------------------------------------------------
-- Table structure for table `as_item_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_item_true_false(
  item_true_false_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- item_true_false_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  PRIMARY KEY(item_true_false_id)
);

ALTER TABLE as_item_true_false
  ADD constraint `as_item_true_false_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_item_true_false`
-- --------------------------------------------------------
INSERT INTO as_item_true_false VALUES(0,4);
INSERT INTO as_item_true_false VALUES(0,5);
INSERT INTO as_item_true_false VALUES(0,9);
INSERT INTO as_item_true_false VALUES(0,10);

-- --------------------------------------------------------
-- Table structure for table `as_attempt`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_attempt (
  attempt_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- attempt_code varchar(255) UNIQUE NOT NULL,
  attempt_number int(10) unsigned NOT NULL,
  attempt_start_time timestamp NOT NULL,
  attempt_end_time timestamp,
  attempt_status ENUM('IN_PROGRESS','COMPLETED','ABANDONED'),
  -- examinee_batch_id int(10) unsigned,
  batch_id int(10) unsigned,
  examinee_id int(10) unsigned,
  PRIMARY KEY (attempt_id)
);

ALTER TABLE as_attempt
  ADD constraint `fk_as_attempt_batch_id` FOREIGN KEY (batch_id) REFERENCES as_examinee_batch(batch_id) ON DELETE SET NULL,
  ADD constraint `fk_as_attempt_examinee_id` FOREIGN KEY (examinee_id) REFERENCES as_examinee_batch(examinee_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_attempt`
-- --------------------------------------------------------
-- INSERT INTO as_attempt VALUES(0,1,"2020-09-27 14:00:00",null,"IN_PROGRESS",1,1);
-- INSERT INTO as_attempt VALUES(0,2,"2020-09-27 14:00:00",null,"ABANDONED",1,1);
-- INSERT INTO as_attempt VALUES(0,3,"2020-09-27 14:00:00",null,"IN_PROGRESS",1,1);
-- INSERT INTO as_attempt VALUES(0,4,"2020-09-27 14:00:00","2020-09-27 17:00:00","IN_PROGRESS",1,1);
-- INSERT INTO as_attempt VALUES(0,1,"2020-09-27 14:00:00",null,"IN_PROGRESS",1,2);
-- INSERT INTO as_attempt VALUES(0,2,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,2);
-- INSERT INTO as_attempt VALUES(0,3,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,2);
-- INSERT INTO as_attempt VALUES(0,1,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",2,2);
-- INSERT INTO as_attempt VALUES(0,3,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",2,2);
-- INSERT INTO as_attempt VALUES(0,2,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",2,2);

-- --------------------------------------------------------
-- Table structure for table `as_response`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_response (
  response_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- response_code varchar(255) UNIQUE NOT NULL,
  response_text varchar(511) NOT NULL,
  qp_item_id int(10) unsigned,
  attempt_id int(10) unsigned,
  PRIMARY KEY (response_id)
);

ALTER TABLE as_response
  ADD constraint `fk_as_response_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL,
  ADD constraint `fk_as_response_attempt_id` FOREIGN KEY (attempt_id) REFERENCES as_attempt(attempt_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_response`
-- --------------------------------------------------------
-- -- INSERT INTO as_response VALUES(0,"Answer 1",1,1);
-- -- INSERT INTO as_response VALUES(0,"Answer 2",1,1;
-- INSERT INTO as_response VALUES(0,"Post Key",2,1);
-- INSERT INTO as_response VALUES(0,"Post Key",3,1);
-- -- INSERT INTO as_response VALUES(0,"Key",2,1);
-- -- INSERT INTO as_response VALUES(0,"PK",3,1);
-- -- INSERT INTO as_response VALUES(0,"Primary Key",3,1);
-- INSERT INTO as_response VALUES(0,"Answer 1",11,2);
-- INSERT INTO as_response VALUES(0,"Answer 2",12,2);
-- INSERT INTO as_response VALUES(0,"Post Key",13,1);

-- --------------------------------------------------------
-- Table structure for table `as_response_mcq`
-- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS as_response_mcq (
--   response_mcq_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   -- response_mcq_code varchar(255) UNIQUE NOT NULL,
--   response_text varchar(511) NOT NULL,
--   response_id int(10) unsigned,
--   PRIMARY KEY (response_mcq_id)
-- );

-- ALTER TABLE as_response_mcq
--   ADD constraint `fk_as_response_mcq_response_id` FOREIGN KEY (response_id) REFERENCES as_response(response_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_response_mcq`
-- --------------------------------------------------------
-- INSERT INTO as_response_mcq VALUES(0,"Collection of related data",1);

-- --------------------------------------------------------
-- Table structure for table `as_response_true_false`
-- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS as_response_true_false (
--   response_true_false_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   -- response_true_false_code varchar(255) UNIQUE NOT NULL,
--   response_text varchar(511) NOT NULL,
--   response_id int(10) unsigned,
--   PRIMARY KEY (response_true_false_id)
-- );

-- ALTER TABLE as_response_true_false
--   ADD constraint `fk_as_response_true_false_response_id` FOREIGN KEY (response_id) REFERENCES as_response(response_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table in_epack_header
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS out_epack_header(
  epack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack_desc varchar(255),
  created_on datetime,
  created_by varchar(255),
  epack_status ENUM('CREATED', 'SENT'),
  epack_sent_on datetime,
  epack_path varchar(255),
  center_id int(10) unsigned NOT NULL,
  PRIMARY KEY(epack_header_id)
);

CREATE TABLE IF NOT EXISTS epack1(
  epack1_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  -- qp_code varchar(255) NOT NULL,
  maximum_marks float(24) NOT NULL,
  instruction_id int(10) unsigned UNIQUE,
  instruction_code varchar(255) UNIQUE,
  instruction_text varchar(255),
  duration int(10) NOT NULL,
  batch_id int(10) unsigned NOT NULL,
  batch_code varchar(255) NOT NULL,
  batch_start_time datetime NOT NULL,
  batch_end_time datetime NOT NULL,
  center_id int(10) unsigned NOT NULL,
  center_code varchar(255) NOT NULL,
  center_name varchar(255) NOT NULL,
  examdrive_id int(10) unsigned NOT NULL,
  examdrive_code varchar(255) NOT NULL,
  examdrive_name varchar(255) NOT NULL,
  course_master_id int(10) unsigned NOT NULL,
  course_code varchar(255) NOT NULL,
  course_name varchar(255) NOT NULL,
  PRIMARY KEY(epack1_id)
);

ALTER TABLE epack1
  ADD CONSTRAINT `fk_epack1_epack_header_id` FOREIGN KEY (epack_header_id) REFERENCES out_epack_header(epack_header_id) ON DELETE CASCADE;

  CREATE TABLE IF NOT EXISTS epack2(
  epack2_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack1_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned UNIQUE NOT NULL,
  item_text varchar(511) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
  PRIMARY KEY(epack2_id)
);

ALTER TABLE epack2
  ADD CONSTRAINT `fk_epack2_epack1_id` FOREIGN KEY (epack1_id) REFERENCES epack1(epack1_id) ON DELETE CASCADE;

  CREATE TABLE IF NOT EXISTS epack3(
  epack3_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack2_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  item_option_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  PRIMARY KEY(epack3_id)
);

ALTER TABLE epack3
  ADD CONSTRAINT `fk_epack3_epack2_id` FOREIGN KEY (epack2_id) REFERENCES epack2(epack2_id) ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS epack4(
  epack4_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack1_id int(10) unsigned NOT NULL,
  batch_id int(10) unsigned NOT NULL,
  -- qp_id int(10) unsigned NOT NULL,
  examinee_batch_id int(10) unsigned NOT NULL,
  examinee_id int(10) unsigned NOT NULL,
  examinee_code varchar(255) NOT NULL,
  examinee_name varchar(255) NOT NULL,
  examinee_password varchar(255) NOT NULL,
  examinee_branch varchar(255),
  examinee_email varchar(255),
  examinee_college varchar(255),
  PRIMARY KEY(epack4_id)
);

ALTER TABLE epack4
  ADD CONSTRAINT `fk_epack4_epack1_id` FOREIGN KEY (epack1_id) REFERENCES epack1(epack1_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table epack1
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS epack1(
--   epack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   epack_header_id int(10) unsigned NOT NULL,
--   qp_id int(10) unsigned UNIQUE NOT NULL,
--   qp_code varchar(255) UNIQUE NOT NULL,
--   maximum_marks float(24) NOT NULL,
--   instruction_id int(10) unsigned UNIQUE NOT NULL,
--   instruction_code varchar(255) UNIQUE NOT NULL,
--   instruction_text varchar(255) NOT NULL,
--   duration int(10) NOT NULL,
--   batch_id int(10) unsigned UNIQUE NOT NULL,
--   batch_code varchar(255) UNIQUE NOT NULL,
--   batch_start_time datetime NOT NULL,
--   batch_end_time datetime NOT NULL,
--   center_id int(10) unsigned NOT NULL,
--   center_code varchar(255) NOT NULL,
--   center_name varchar(255) NOT NULL,
--   examdrive_id int(10) unsigned NOT NULL,
--   examdrive_code varchar(255) NOT NULL,
--   examdrive_name varchar(255) NOT NULL,
--   course_master_id int(10) unsigned NOT NULL,
--   course_code varchar(255) NOT NULL,
--   course_name varchar(255) NOT NULL,
--   PRIMARY KEY(epack_id)
-- );

-- ALTER TABLE epack1
--   ADD CONSTRAINT `fk_epack1_epack_header_id` FOREIGN KEY (epack_header_id) REFERENCES in_epack_header(epack_header_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_epack1_centre_id` FOREIGN KEY (centre_id) REFERENCES in_epack_header(centre_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table epack2
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS epack2(
--   epack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   qp_id int(10) unsigned NOT NULL,
--   item_id int(10) unsigned UNIQUE NOT NULL,
--   item_text varchar(255) NOT NULL,
--   item_marks float(24) unsigned NOT NULL,
--   item_type varchar(255) NOT NULL,
--   cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
--   PRIMARY KEY(epack_id)
-- );

-- ALTER TABLE epack2
--   ADD CONSTRAINT `fk_epack2_qp_id` FOREIGN KEY (qp_id) REFERENCES epack1(qp_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table epack3
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS epack3(
--   epack_id int(10) unsigned NOT NULL,
--   item_id int(10) unsigned NOT NULL,
--   option_text varchar(255) NOT NULL,
--   PRIMARY KEY(epack_id)
-- );

-- ALTER TABLE epack3
--   ADD CONSTRAINT `fk_epack3_epack_id` FOREIGN KEY (epack_id) REFERENCES epack2(epack_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_epack3_item_id` FOREIGN KEY (item_id) REFERENCES epack2(item_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table epack4
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS epack4(
--   epack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   qp_id int(10) unsigned NOT NULL,
--   batch_id int(10) unsigned NOT NULL,
--   examinee_batch_id int(10) unsigned NOT NULL,
--   examinee_id int(10) unsigned NOT NULL,
--   examinee_code varchar(255) NOT NULL,
--   examinee_name varchar(255) NOT NULL,
--   examinee_password varchar(255) NOT NULL,
--   examinee_branch varchar(255),
--   examinee_email varchar(255),
--   examinee_college varchar(255),
--   PRIMARY KEY(epack_id)
-- );

-- ALTER TABLE epack4
--   ADD CONSTRAINT `fk_epack4_qp_id` FOREIGN KEY (qp_id) REFERENCES epack1(qp_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_epack4_batch_id` FOREIGN KEY (batch_id) REFERENCES epack1(batch_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table out_rpack_header
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS out_rpack_header(
  rpack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  rpack_desc varchar(255),
  created_on datetime,
  created_by varchar(255),
  rpack_status ENUM('CREATED', 'SENT'),
  rpack_sent_on datetime,
  rpack_path varchar(255),
  PRIMARY KEY(rpack_header_id)
);

-- --------------------------------------------------------
-- Data Entry for table `out_rpack_header`
-- --------------------------------------------------------
-- INSERT INTO out_rpack_header VALUES(0,"It is R-Pack 1","2020-11-10 07:00:00","Center Admin","CREATED",null,null);
-- INSERT INTO out_rpack_header VALUES(0,"It is R-Pack 2","2020-11-11 07:00:00","Center Admin","SENT","2020-11-18 07:00:00",null);

-- --------------------------------------------------------
-- Table structure for table rpack1
-- SELECT q.qp_id, q.maximum_marks, q.duration, q.batch_id FROM as_question_paper q
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack1(
  rpack1_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  rpack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  -- qp_code varchar(255) UNIQUE NOT NULL,
  maximum_marks float(24) NOT NULL,
  duration int(10) NOT NULL,
  batch_id int(10) unsigned NOT NULL,
  PRIMARY KEY(rpack1_id)
);

ALTER TABLE rpack1
  ADD CONSTRAINT `fk_rpack1_rpack_header_id` FOREIGN KEY (rpack_header_id) REFERENCES out_rpack_header(rpack_header_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table rpack2
-- SELECT i.qp_id, i.qp_item_id, i.item_text, i.item_marks, i.item_type, i.cognitive_level FROM as_qp_item i WHERE i.qp_id = :qp_id
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack2(
  rpack2_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  rpack1_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  -- item_text varchar(255) NOT NULL,
  item_text text(1024) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
  PRIMARY KEY(rpack2_id)
);

ALTER TABLE rpack2
  ADD CONSTRAINT `fk_rpack2_rpack1_id` FOREIGN KEY (rpack1_id) REFERENCES rpack1(rpack1_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table rpack3
-- SELECT o.qp_item_id, o.item_mcq_id, o.mcq_option_text FROM as_item_mcq_options o WHERE o.qp_item_id = :qp_item_id
-- SELECT o.qp_item_id, o.item_true_false_id FROM as_item_true_false o WHERE o.qp_item_id = :qp_item_id
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack3(
  rpack3_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  rpack2_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  item_option_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  PRIMARY KEY(rpack3_id)
);

ALTER TABLE rpack3
  ADD CONSTRAINT `fk_rpack3_rpack2_id` FOREIGN KEY (rpack2_id) REFERENCES rpack2(rpack2_id) ON DELETE CASCADE;
  -- ADD CONSTRAINT `fk_rpack3_item_id` FOREIGN KEY (item_id) REFERENCES rpack2(item_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table rpack4
-- SELECT q.qp_id, q.batch_id, eb.examinee_batch_id, eb.examinee_id, i.qp_item_id, r.response_id, r.response_text FROM as_qp_item i INNER JOIN as_question_paper q ON 
-- i.qp_id = q.qp_id INNER JOIN as_batch b ON q.batch_id = b.batch_id INNER JOIN as_examinee_batch eb ON b.batch_id = eb.batch_id INNER JOIN as_response r ON i.qp_item_id 
-- = r.qp_item_id WHERE i.qp_item_id = :qp_item_id
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack4(
  rpack4_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  rpack2_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  batch_id int(10) unsigned NOT NULL,
  examinee_batch_id int(10) unsigned NOT NULL,
  examinee_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  response_id int(10) unsigned NOT NULL,
  response_text varchar(511) NOT NULL,
  PRIMARY KEY(rpack4_id)
);

ALTER TABLE rpack4
  ADD CONSTRAINT `fk_rpack4_rpack2_id` FOREIGN KEY (rpack2_id) REFERENCES rpack2(rpack2_id) ON DELETE CASCADE;
--   ADD CONSTRAINT `fk_rpack4_batch_id` FOREIGN KEY (batch_id) REFERENCES rpack1(batch_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_rpack4_item_id` FOREIGN KEY (item_id) REFERENCES rpack2(item_id) ON DELETE CASCADE;

-- INSERT INTO rpack4 VALUES(0, 17, 1, 1, 1, 1, 4, 10, "True");