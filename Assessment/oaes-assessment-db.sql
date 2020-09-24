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
-- Data Entry for table ea_examinee
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
  course_master_id int(10) unsigned,
  PRIMARY KEY (batch_id)
);

ALTER TABLE as_batch
  ADD CONSTRAINT `fk_as_batch_center_id` FOREIGN KEY (center_id) REFERENCES as_center(center_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_batch`
-- --------------------------------------------------------

INSERT INTO as_batch VALUES(0,"Mrng1","2020-09-23 09:00:00","2020-09-23 12:00:00","RECEIVED",1,1);
INSERT INTO as_batch VALUES(0,"AfterNoon1","2020-01-01 14:00:00","2020-01-01 17:00:00","RECEIVED",1,2);
INSERT INTO as_batch VALUES(0,"Mrng2","2020-01-01 09:00:00","2020-01-01 12:00:00","RECEIVED",1,3);

-- --------------------------------------------------------
-- Table structure for table `as_examinee_batch`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_examinee_batch (
  examinee_batch_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  batch_id int(10) unsigned,
  examinee_id int(10) unsigned,
  PRIMARY KEY (examinee_batch_id)
);

ALTER TABLE as_examinee_batch
  ADD CONSTRAINT `fk_as_examinee_batch_batch_id` FOREIGN KEY (batch_id) REFERENCES as_batch(batch_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_as_examinee_batch_examinee_id` FOREIGN KEY (examinee_id) REFERENCES as_examinee(examinee_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table as_examinee_batch
-- --------------------------------------------------------
INSERT INTO as_examinee_batch VALUES(0,1,1);
INSERT INTO as_examinee_batch VALUES(0,1,2);
INSERT INTO as_examinee_batch VALUES(0,1,3);
INSERT INTO as_examinee_batch VALUES(0,2,1);
INSERT INTO as_examinee_batch VALUES(0,2,2);
INSERT INTO as_examinee_batch VALUES(0,2,4);

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
  user_status ENUM('Active', 'NOT_Active'),
  PRIMARY KEY (invigilator_id)
);

ALTER TABLE as_invigilator
  ADD CONSTRAINT `fk_as_invigilator_batch_id` FOREIGN KEY (batch_id) REFERENCES as_batch(batch_id) ON DELETE SET NULL;

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
-- Data Entry for table `as_question_paper`
-- --------------------------------------------------------

INSERT INTO as_question_paper VALUES(0,"MAT_Paper_1",1,100,180);
INSERT INTO as_question_paper VALUES(0,"MAT_Paper_2",1,100,180);
INSERT INTO as_question_paper VALUES(0,"PHY_1",2,50,120);
INSERT INTO as_question_paper VALUES(0,"CHEM_1",3,25,60);

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
-- Table structure for table `as_item_mcq_options`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_item_mcq_options(
  item_mcq_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_mcq_options_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  mcq_option_text varchar(255) NOT NULL,
  mcq_option_percentage float(24) DEFAULT 0.0,
  PRIMARY KEY(item_mcq_id)
);

ALTER TABLE as_item_mcq_options
  ADD constraint `as_item_mcq_options_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_item_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_item_true_false(
  item_true_false_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_true_false_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  true_percentage float(24) DEFAULT 0.0,
  false_percentage  float(24) DEFAULT 0.0,
  PRIMARY KEY(item_true_false_id)
);

ALTER TABLE as_item_true_false
  ADD constraint `as_item_true_false_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_attempt`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_attempt (
  attempt_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  attempt_code varchar(255) UNIQUE NOT NULL,
  attempt_number int(10) unsigned NOT NULL,
  attempt_start_time timestamp NOT NULL,
  attempt_end_time timestamp NOT NULL,
  status ENUM('NOT_Started','IN_Progress','Completed','Abandoned'),
  examinee_batch_id int(10) unsigned,
  PRIMARY KEY (attempt_id)
);

ALTER TABLE as_attempt
  ADD constraint `fk_as_attempt_examinee_batch_id` FOREIGN KEY (examinee_batch_id) REFERENCES as_examinee_batch(examinee_batch_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_response`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_response (
  response_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  response_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  attempt_id int(10) unsigned,
  PRIMARY KEY (response_id)
);

ALTER TABLE as_response
  ADD constraint `fk_as_response_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES as_qp_item(qp_item_id) ON DELETE SET NULL,
  ADD constraint `fk_as_response_attempt_id` FOREIGN KEY (attempt_id) REFERENCES as_attempt(attempt_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_response_mcq`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_response_mcq (
  response_mcq_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  response_mcq_code varchar(255) UNIQUE NOT NULL,
  response_text varchar(511) NOT NULL,
  response_id int(10) unsigned,
  PRIMARY KEY (response_mcq_id)
);

ALTER TABLE as_response_mcq
  ADD constraint `fk_as_response_mcq_response_id` FOREIGN KEY (response_id) REFERENCES as_response(response_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `as_response_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS as_response_true_false (
  response_true_false_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  response_true_false_code varchar(255) UNIQUE NOT NULL,
  response_id int(10) unsigned,
  PRIMARY KEY (response_true_false_id)
);

ALTER TABLE as_response_true_false
  ADD constraint `fk_as_response_true_false_response_id` FOREIGN KEY (response_id) REFERENCES as_response(response_id) ON DELETE SET NULL;
