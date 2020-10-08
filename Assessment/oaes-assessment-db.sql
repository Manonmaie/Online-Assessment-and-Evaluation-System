DROP DATABASE oaes_assessment_db;
CREATE DATABASE oaes_assessment_db;
USE oaes_assessment_db;

--
-- Database: `oaes_assessment_db`
--

-- --------------------------------------------------------
-- Table structure for table `as_course_master`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_course_master (
  course_master_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  course_code varchar(255) UNIQUE NOT NULL,
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
  examdrive_code varchar(255) UNIQUE NOT NULL,
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
  examinee_code varchar(255) UNIQUE NOT NULL,
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
  center_code varchar(255) UNIQUE NOT NULL,
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
  batch_code varchar(255) UNIQUE NOT NULL,
  batch_start_time datetime NOT NULL,
  batch_end_time datetime NOT NULL,
  qp_status ENUM('PENDING','RECEIVED','ERROR_SENDING') DEFAULT 'PENDING',
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
  qp_code varchar(255) UNIQUE NOT NULL,
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
INSERT INTO as_batch VALUES(0,"Mrng1","2020-10-08 07:00:00","2020-10-08 23:00:00","RECEIVED",1,1,NULL);
INSERT INTO as_batch VALUES(0,"AfterNoon1","2020-09-28 14:00:00","2020-09-28 23:59:59","RECEIVED",1,2,NULL);
INSERT INTO as_batch VALUES(0,"Mrng2","2020-01-01 09:00:00","2020-01-01 12:00:00","RECEIVED",1,3,NULL);

-- --------------------------------------------------------
-- Data Entry for table `as_question_paper`
-- --------------------------------------------------------
INSERT INTO as_question_paper VALUES(0,"MAT_1",1,100,180);
-- INSERT INTO as_question_paper VALUES(0,"MAT_Paper_2",1,100,180);
INSERT INTO as_question_paper VALUES(0,"PHY_1",2,50,120);
INSERT INTO as_question_paper VALUES(0,"CHEM_1",3,25,60);

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
INSERT INTO as_examinee_batch VALUES(0,null,null,"NOT_STARTED",2,1);
INSERT INTO as_examinee_batch VALUES(0,null,null,"NOT_STARTED",2,2);
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
  item_code varchar(255) UNIQUE NOT NULL,
  item_text varchar(511) NOT NULL,
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
INSERT INTO as_qp_item VALUES(0,"Item1_qp1","What is a database?",2,"McqSingleCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Item2_qp1","What is a  PK?",1,"McqMultiCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Item3_qp1","What is a FK?",2,"McqMultiCorrect","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Item4_qp1","UK and PK are same.",1,"True/False","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Item5_qp1","Uk with no null values is Pk.",2,"True/False","UNDERSTAND",1);
INSERT INTO as_qp_item VALUES(0,"Item1_qp2","What is a database?",2,"McqSingleCorrect","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"Item2_qp2","What is a  PK?",1,"McqSingleCorrect","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"Item3_qp2","What is a FK?",2,"McqMultiCorrect","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"Item4_qp2","UK and PK are same.",1,"True/False","UNDERSTAND",2);
INSERT INTO as_qp_item VALUES(0,"Item5_qp2","Uk with no null values is Pk.",2,"True/False","UNDERSTAND",2);

-- --------------------------------------------------------
-- Table structure for table `as_item_mcq_options`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_item_mcq_options(
  item_mcq_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_mcq_options_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  mcq_option_text varchar(255) NOT NULL,
  PRIMARY KEY(item_mcq_id)
);

ALTER TABLE as_item_mcq_options
  ADD constraint `as_item_mcq_options_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_item_mcq_options`
-- --------------------------------------------------------
INSERT INTO as_item_mcq_options VALUES(0,"Mcq1_item1_qp1",1,"Collection of related data");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq2_item1_qp1",1,"Collection of data");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq3_item1_qp1",1,"Collection of words");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq4_item1_qp1",1,"Collection of people");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq1_item2_qp1",2,"Primary Key");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq2_item2_qp1",2,"Personal Key");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq3_item2_qp1",2,"Person Key");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq4_item2_qp1",2,"Primary Keyword");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq1_item3_qp1",3,"Foreign Key");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq2_item3_qp1",3,"Foreign Keyword");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq3_item3_qp1",3,"Fashion Key");
INSERT INTO as_item_mcq_options VALUES(0,"Mcq4_item3_qp1",3,"Forward Key");

-- --------------------------------------------------------
-- Table structure for table `as_item_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_item_true_false(
  item_true_false_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_true_false_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  PRIMARY KEY(item_true_false_id)
);

ALTER TABLE as_item_true_false
  ADD constraint `as_item_true_false_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_item_true_false`
-- --------------------------------------------------------
INSERT INTO as_item_true_false VALUES(0,"True_False_item4_qp1",4);
INSERT INTO as_item_true_false VALUES(0,"True_False_item5_qp1",5);

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
-- INSERT INTO as_attempt VALUES(0,1,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,1);
-- INSERT INTO as_attempt VALUES(0,2,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,1);
-- INSERT INTO as_attempt VALUES(0,3,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,1);
-- INSERT INTO as_attempt VALUES(0,4,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,1);
-- INSERT INTO as_attempt VALUES(0,1,"2020-09-27 14:00:00","2020-09-27 17:00:00","COMPLETED",1,2);
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
-- INSERT INTO as_response VALUES(0,"Primary Key",1,1);
-- INSERT INTO as_response VALUES(0,"Primary Key",1,2);
-- INSERT INTO as_response VALUES(0,"Post Key",2,4);
-- INSERT INTO as_response VALUES(0,"Post Key",3,4);
-- INSERT INTO as_response VALUES(0,"Key",2,4);
-- INSERT INTO as_response VALUES(0,"PK",3,5);
-- INSERT INTO as_response VALUES(0,"Primary Key",3,6);

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
CREATE TABLE IF NOT EXISTS in_epack_header(
  epack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack_desc varchar(255),
  created_on timestamp,
  created_by varchar(255),
  epack_status ENUM('CREATED', 'SENT'),
  epack_sent_on timestamp,
  epack_path varchar(255),
  PRIMARY KEY(epack_header_id)
);

-- --------------------------------------------------------
-- Table structure for table epack1
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS epack1(
  epack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned UNIQUE NOT NULL,
  qp_code varchar(255) UNIQUE NOT NULL,
  maximum_marks float(24) NOT NULL,
  instruction_id int(10) unsigned UNIQUE NOT NULL,
  instruction_code varchar(255) UNIQUE NOT NULL,
  instruction_text varchar(255) NOT NULL,
  duration int(10) NOT NULL,
  batch_id int(10) unsigned UNIQUE NOT NULL,
  batch_code varchar(255) UNIQUE NOT NULL,
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
  PRIMARY KEY(epack_header_id)
);

ALTER TABLE epack1
  ADD CONSTRAINT `fk_epack1_epack_header_id` FOREIGN KEY (epack_header_id) REFERENCES in_epack_header(epack_header_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table epack2
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS epack2(
  epack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qp_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned UNIQUE NOT NULL,
  item_text varchar(255) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
  PRIMARY KEY(epack_id)
);

ALTER TABLE epack2
  ADD CONSTRAINT `fk_epack2_qp_id` FOREIGN KEY (qp_id) REFERENCES epack1(qp_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table epack3
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS epack3(
  epack_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  PRIMARY KEY(epack_id)
);

ALTER TABLE epack3
  ADD CONSTRAINT `fk_epack3_epack_id` FOREIGN KEY (epack_id) REFERENCES epack2(epack_id) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_epack3_item_id` FOREIGN KEY (item_id) REFERENCES epack2(item_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table epack4
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS epack4(
  epack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qp_id int(10) unsigned NOT NULL,
  batch_id int(10) unsigned NOT NULL,
  examinee_batch_id int(10) unsigned NOT NULL,
  examinee_id int(10) unsigned NOT NULL,
  examinee_code varchar(255) NOT NULL,
  examinee_name varchar(255) NOT NULL,
  examinee_password varchar(255) NOT NULL,
  examinee_branch varchar(255),
  examinee_email varchar(255),
  examinee_college varchar(255),
  PRIMARY KEY(epack_id)
);

ALTER TABLE epack4
  ADD CONSTRAINT `fk_epack4_qp_id` FOREIGN KEY (qp_id) REFERENCES epack1(qp_id) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_epack4_batch_id` FOREIGN KEY (batch_id) REFERENCES epack1(batch_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table out_rpack_header
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS out_rpack_header(
  rpack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  rpack_desc varchar(255),
  created_on timestamp,
  created_by varchar(255),
  rpack_status ENUM('CREATED', 'SENT'),
  rpack_sent_on timestamp,
  rpack_path varchar(255),
  PRIMARY KEY(rpack_header_id)
);

-- --------------------------------------------------------
-- Table structure for table rpack1
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack1(
  rpack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned UNIQUE NOT NULL,
  qp_code varchar(255) UNIQUE NOT NULL,
  maximum_marks float(24) NOT NULL,
  duration int(10) NOT NULL,
  batch_id int(10) unsigned UNIQUE NOT NULL,
  PRIMARY KEY(rpack_header_id)
);

ALTER TABLE rpack1
  ADD CONSTRAINT `fk_rpack1_rpack_header_id` FOREIGN KEY (rpack_header_id) REFERENCES out_rpack_header(rpack_header_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table rpack2
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack2(
  rpack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qp_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned UNIQUE NOT NULL,
  item_text varchar(255) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
  PRIMARY KEY(rpack_id)
);

ALTER TABLE rpack2
  ADD CONSTRAINT `fk_rpack2_qp_id` FOREIGN KEY (qp_id) REFERENCES rpack1(qp_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table epack3
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack3(
  rpack_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  PRIMARY KEY(rpack_id)
);

ALTER TABLE rpack3
  ADD CONSTRAINT `fk_rpack3_rpack_id` FOREIGN KEY (rpack_id) REFERENCES rpack2(rpack_id) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_rpack3_item_id` FOREIGN KEY (item_id) REFERENCES rpack2(item_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table rpack4
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS rpack4(
  rpack_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  batch_id int(10) unsigned NOT NULL,
  examinee_batch_id int(10) unsigned NOT NULL,
  examinee_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  response_id int(10) unsigned NOT NULL,
  response_text varchar(511) NOT NULL,
  PRIMARY KEY(rpack_id)
);

ALTER TABLE rpack4
  ADD CONSTRAINT `fk_rpack4_qp_id` FOREIGN KEY (qp_id) REFERENCES rpack1(qp_id) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_rpack4_batch_id` FOREIGN KEY (batch_id) REFERENCES rpack1(batch_id) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_rpack4_item_id` FOREIGN KEY (item_id) REFERENCES rpack2(item_id) ON DELETE CASCADE;
