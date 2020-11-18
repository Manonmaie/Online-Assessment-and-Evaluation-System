DROP DATABASE oaes_exam_admin_db;
CREATE DATABASE oaes_exam_admin_db;
USE oaes_exam_admin_db;
--
-- Database: `oaes_exam_admin_db`
--

-- --------------------------------------------------------
-- Table structure for table `ea_course_master`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_course_master (
  course_master_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  course_code varchar(255) UNIQUE NOT NULL,
  course_name varchar(255) NOT NULL,
  PRIMARY KEY (course_master_id)
);

-- --------------------------------------------------------
-- Data Entry for table ea_course_master
-- --------------------------------------------------------
INSERT INTO ea_course_master VALUES(0,"DBMS","Database Management System");
INSERT INTO ea_course_master VALUES(0,"DM","Data Modelling");
INSERT INTO ea_course_master VALUES(0,"OS","Operating Systems");
INSERT INTO ea_course_master VALUES(0,"DSA","Data Structures and Alogorithms");

-- --------------------------------------------------------
-- Table structure for table ea_examdrive
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_examdrive(
  examdrive_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  examdrive_code varchar(255) UNIQUE NOT NULL,
  examdrive_name varchar(255) NOT NULL,
  status ENUM('NOT_STARTED','IN_PROGRESS','COMPLETED') DEFAULT 'NOT_STARTED',
  course_master_id int(10) unsigned,
  PRIMARY KEY (examdrive_id)
);

ALTER TABLE ea_examdrive
  ADD CONSTRAINT `fk_ea_examdrive_course_master_id` FOREIGN KEY (course_master_id) REFERENCES ea_course_master(course_master_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_examdrive
-- --------------------------------------------------------
INSERT INTO ea_examdrive VALUES(0,"MID","Mid Term Examination",'COMPLETED',1);
INSERT INTO ea_examdrive VALUES(0,"END","End Term Examination",'NOT_STARTED',1);
INSERT INTO ea_examdrive VALUES(0,"IMP","Improvement Examination",'NOT_STARTED',1);

-- --------------------------------------------------------
-- Table structure for table ea_examinee
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_examinee(
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
INSERT INTO ea_examinee VALUES(0,"S1","ABC","abc","CSE","ABC@iiitb.org",'IIITB');
INSERT INTO ea_examinee VALUES(0,"S2","ZYX","xyz",NULL,NULL,NULL);
INSERT INTO ea_examinee VALUES(0,"S3","Z","z","ECE",NULL,NULL);
INSERT INTO ea_examinee VALUES(0,"S4","Y","y",NULL,NULL,"IIITB");
INSERT INTO ea_examinee VALUES(0,"S5","X","x",NULL,NULL,NULL);

-- --------------------------------------------------------
-- Table structure for table ea_center
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_center(
  center_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  center_code varchar(255) UNIQUE NOT NULL,
  center_name varchar(255) NOT NULL,
  center_capacity int(10) unsigned,
  PRIMARY KEY(center_id)
);

-- --------------------------------------------------------
-- Data Entry for table ea_center
-- --------------------------------------------------------
INSERT INTO ea_center VALUES(0,"IIITB","International Institute of Information Technology, Bangalore",1000);
INSERT INTO ea_center VALUES(0,"IIITH","International Institute of Information Technology, Hyderabad",1000);
INSERT INTO ea_center VALUES(0,"IITB","Indian Institute of Technology, Mumbai",10000);
INSERT INTO ea_center VALUES(0,"IITM","Indian Institute of Technology, Chennai",20000);

-- --------------------------------------------------------
-- Table structure for table `ea_batch`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_batch(
  batch_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  batch_code varchar(255) UNIQUE NOT NULL,
  batch_start_time datetime NOT NULL,
  batch_end_time datetime NOT NULL,
  qp_status ENUM('PENDING','RECEIVED','ERROR_SENDING','SENT') DEFAULT 'PENDING',
  center_id int(10) unsigned,
  examdrive_id int(10) unsigned,
  qp_id int(10) unsigned,
  PRIMARY KEY (batch_id)
);

ALTER TABLE ea_batch
  ADD CONSTRAINT `fk_ea_batch_center_id` FOREIGN KEY (center_id) REFERENCES ea_center(center_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_ea_batch_examdrive_id` FOREIGN KEY (examdrive_id) REFERENCES ea_examdrive(examdrive_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_batch
-- --------------------------------------------------------
INSERT INTO ea_batch VALUES(0,"MID-MRNG-IIITB","2020-09-23 10:00:00","2020-09-23 13:00:00","RECEIVED",1,1,NULL);
INSERT INTO ea_batch VALUES(0,"END-MRNG-IIITB","2020-10-23 10:00:00","2020-10-23 13:00:00","RECEIVED",1,2,NULL);
INSERT INTO ea_batch VALUES(0,"IMP-MRNG-IIITB","2020-12-23 10:00:00","2020-12-23 13:00:00","RECEIVED",1,3,NULL);
INSERT INTO ea_batch VALUES(0,"MID-EVNG-IIITB","2020-09-23 14:00:00","2020-09-23 17:00:00","RECEIVED",1,1,NULL);
INSERT INTO ea_batch VALUES(0,"MID-MRNG-IIITH","2020-09-23 10:00:00","2020-09-23 13:00:00","RECEIVED",2,1,NULL);

-- --------------------------------------------------------
-- Table structure for table `ea_examinee_batch`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_examinee_batch (
  examinee_batch_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  batch_id int(10) unsigned,
  examinee_id int(10) unsigned,
  -- marks_obtained float(24),
  PRIMARY KEY (examinee_batch_id)
);

ALTER TABLE ea_examinee_batch
  ADD CONSTRAINT `fk_ea_examinee_batch_batch_id` FOREIGN KEY (batch_id) REFERENCES ea_batch(batch_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_ea_examinee_batch_examinee_id` FOREIGN KEY (examinee_id) REFERENCES ea_examinee(examinee_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_examinee_batch
-- --------------------------------------------------------
INSERT INTO ea_examinee_batch VALUES(0,1,1);
INSERT INTO ea_examinee_batch VALUES(0,2,1);
INSERT INTO ea_examinee_batch VALUES(0,1,2);
INSERT INTO ea_examinee_batch VALUES(0,2,2);
INSERT INTO ea_examinee_batch VALUES(0,3,2);

-- --------------------------------------------------------
-- Table structure for table `ea_question_paper`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_question_paper(
  qp_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  -- qp_code varchar(255) UNIQUE NOT NULL,
  batch_id int(10) unsigned,
  maximum_marks float(24) NOT NULL DEFAULT 100,
  duration int(10) NOT NULL DEFAULT 180,
  PRIMARY KEY(qp_id)
);

ALTER TABLE ea_question_paper
  ADD CONSTRAINT `fk_ea_question_paper_batch_id` FOREIGN KEY (batch_id) REFERENCES ea_batch(batch_id) ON DELETE SET NULL;

ALTER TABLE ea_batch
  ADD CONSTRAINT `fk_ea_batch_qp_id` FOREIGN KEY (qp_id) REFERENCES ea_question_paper(qp_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_question_paper
-- --------------------------------------------------------
-- INSERT INTO ea_question_paper VALUES(0,"dbMid",1,100,180);
-- INSERT INTO ea_question_paper VALUES(0,"dbEnd",2,100,180);
-- INSERT INTO ea_question_paper VALUES(0,"dbImp",3,100,180);
INSERT INTO ea_question_paper VALUES(0,1,100,180);
INSERT INTO ea_question_paper VALUES(0,2,100,180);
INSERT INTO ea_question_paper VALUES(0,3,100,180);
INSERT INTO ea_question_paper VALUES(0,5,100,180);

-- --------------------------------------------------------
-- Table structure for table `ea_instruction`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_instruction(
  instruction_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  instruction_code varchar(255) UNIQUE NOT NULL,
  qp_id int(10) unsigned,
  instruction_text varchar(255) NOT NULL,
  PRIMARY KEY(instruction_id)
);

ALTER TABLE ea_instruction
  ADD CONSTRAINT `fk_ea_instruction_qp_id` FOREIGN KEY (qp_id) REFERENCES ea_question_paper(qp_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_instruction
-- --------------------------------------------------------
INSERT INTO ea_instruction VALUES(0,"IC1",1,"Instruction 1");
INSERT INTO ea_instruction VALUES(0,"IC2",1,"Instruction 2");
INSERT INTO ea_instruction VALUES(0,"IC3",2,"Instruction 3");

-- --------------------------------------------------------
-- Table structure for table `ea_itemtype_master`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_itemtype_master (
  itemtype_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  itemtype_code varchar(255) UNIQUE NOT NULL,
  itemtype_name varchar(255) NOT NULL,
  itemtype_category ENUM('AUTO','MANUAL') DEFAULT 'MANUAL',
  PRIMARY KEY (itemtype_id)
);

-- --------------------------------------------------------
-- Table structure for table `ea_qp_item`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_qp_item (
  qp_item_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_code varchar(255) UNIQUE NOT NULL,
  item_text varchar(511) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER','UNDERSTAND','APPLY','ANALYZE','EVALUATE','CREATE'),
  qp_id int(10) unsigned,
  PRIMARY KEY (qp_item_id)
);

ALTER TABLE ea_qp_item
  ADD constraint `fk_ea_qp_item_qp_id` FOREIGN KEY (qp_id) REFERENCES ea_question_paper(qp_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_qp_item
-- --------------------------------------------------------
INSERT INTO ea_qp_item VALUES(0,"1.1","1stQuestion-Mid-DB",5,"MCQ",'REMEMBER',1);
INSERT INTO ea_qp_item VALUES(0,"1.2","2stQuestion-Mid-DB",10,"MCQ",'APPLY',1);
INSERT INTO ea_qp_item VALUES(0,"1.3","3stQuestion-Mid-DB",5,"MCQ",'REMEMBER',1);
INSERT INTO ea_qp_item VALUES(0,"2.1","1stQuestion-End-DB",5,"MCQ",'REMEMBER',2);
INSERT INTO ea_qp_item VALUES(0,"2.2","2stQuestion-End-DB",10,"TF",'APPLY',2);
INSERT INTO ea_qp_item VALUES(0,"3.1","1stQuestion-IMP-DB",30,"MCQ",'EVALUATE',3);

-- --------------------------------------------------------
-- Table structure for table `ea_examinee_item_marks`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_examinee_item_marks (
  examinee_item_marks_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qp_item_id int(10) unsigned,
  examinee_batch_id int(10) unsigned,
  marks_obtained float(24) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (examinee_item_marks_id),
  CONSTRAINT `uk_ea_examinee_item_marks` UNIQUE (qp_item_id,examinee_batch_id)
);

ALTER TABLE ea_examinee_item_marks
  ADD constraint `fk_ea_examinee_item_marks_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ea_qp_item(qp_item_id) ON DELETE SET NULL,
  ADD constraint `fk_ea_examinee_item_marks_examinee_batch_id` FOREIGN KEY (examinee_batch_id) REFERENCES ea_examinee_batch(examinee_batch_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_examinee_item_marks
-- --------------------------------------------------------
INSERT INTO ea_examinee_item_marks VALUES(0,1,1,5);
INSERT INTO ea_examinee_item_marks VALUES(0,2,1,8);
INSERT INTO ea_examinee_item_marks VALUES(0,3,1,4);
INSERT INTO ea_examinee_item_marks VALUES(0,1,3,0);
INSERT INTO ea_examinee_item_marks VALUES(0,2,3,3);
INSERT INTO ea_examinee_item_marks VALUES(0,3,3,1);
INSERT INTO ea_examinee_item_marks VALUES(0,4,2,5);
INSERT INTO ea_examinee_item_marks VALUES(0,5,2,10);
INSERT INTO ea_examinee_item_marks VALUES(0,4,4,0);
INSERT INTO ea_examinee_item_marks VALUES(0,5,4,5);
INSERT INTO ea_examinee_item_marks VALUES(0,6,5,20);

-- ALTER TABLE `ea_examinee_batch` MODIFY COLUMN marks_obtained GENERATED ALWAYS AS (SUM(marks_obtained) FROM `ea_examinee_item_marks` GROUP BY examinee_batch_id) STORED;

-- --------------------------------------------------------
-- View structure for table `ea_examinee_batch_marks`
-- --------------------------------------------------------
CREATE view `ea_examinee_batch_marks` as (
  SELECT eb.*, SUM(eim.marks_obtained) as marks_obtained from `ea_examinee_batch` eb JOIN `ea_examinee_item_marks` eim ON eb.examinee_batch_id = eim.examinee_batch_id GROUP BY examinee_batch_id
);

-- --------------------------------------------------------
-- Table structure for table `ea_item_mcq_options`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_item_mcq_options(
  item_mcq_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_mcq_options_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  mcq_option_text varchar(255) NOT NULL,
  PRIMARY KEY(item_mcq_id)
);

ALTER TABLE ea_item_mcq_options
  ADD constraint `ea_item_mcq_options_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ea_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_item_mcq_options
-- --------------------------------------------------------
INSERT INTO ea_item_mcq_options VALUES(0,"1.1.1",1,"1stQuestion-Mid-DB-OP1");
INSERT INTO ea_item_mcq_options VALUES(0,"1.1.2",1,"1stQuestion-Mid-DB-OP2");
INSERT INTO ea_item_mcq_options VALUES(0,"1.1.3",1,"1stQuestion-Mid-DB-OP3");
INSERT INTO ea_item_mcq_options VALUES(0,"1.2.1",2,"2stQuestion-Mid-DB-OP1");
INSERT INTO ea_item_mcq_options VALUES(0,"1.2.2",2,"2stQuestion-Mid-DB-OP2");
INSERT INTO ea_item_mcq_options VALUES(0,"2.1.1",4,"1stQuestion-End-DB-OP1");
INSERT INTO ea_item_mcq_options VALUES(0,"3.1.1",6,"1stQuestion-IMP-DB-OP1");

-- --------------------------------------------------------
-- Table structure for table `ea_item_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ea_item_true_false(
  item_true_false_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_true_false_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  PRIMARY KEY(item_true_false_id)
);

ALTER TABLE ea_item_true_false
  ADD constraint `ea_item_true_false_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ea_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table ea_item_true_false
-- --------------------------------------------------------
INSERT INTO ea_item_true_false VALUES(0,"2.2",5);

-- --------------------------------------------------------
-- Table structure for table in_qpack_header
-- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS in_qpack_header(
--   qpack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   qpack_desc varchar(255),
--   created_on datetime,
--   created_by varchar(255),
--   qpack_status ENUM('CREATED', 'SENT'),
--   qpack_sent_on datetime,
--   qpack_path varchar(255),
--   PRIMARY KEY(qpack_header_id)
-- );

-- -- --------------------------------------------------------
-- -- Table structure for table qpack1
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS qpack1(
--   qpack_header_id int(10) unsigned NOT NULL,
--   qp_id int(10) unsigned UNIQUE NOT NULL,
--   qp_code varchar(255) UNIQUE NOT NULL,
--   maximum_marks float(24) NOT NULL,
--   instruction_id int(10) unsigned UNIQUE NOT NULL,
--   instruction_code varchar(255) UNIQUE NOT NULL,
--   instruction_text varchar(255) NOT NULL,
--   duration int(10) NOT NULL,
--   PRIMARY KEY(qpack_header_id)
-- );

-- ALTER TABLE qpack1
--   ADD CONSTRAINT `fk_qpack1_qpack_header_id` FOREIGN KEY (qpack_header_id) REFERENCES in_qpack_header(qpack_header_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table qpack2
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS qpack2(
--   qpack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   qp_id int(10) unsigned NOT NULL,
--   item_id int(10) unsigned UNIQUE NOT NULL,
--   item_text varchar(255) NOT NULL,
--   item_marks float(24) unsigned NOT NULL,
--   item_type varchar(255) NOT NULL,
--   cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
--   PRIMARY KEY(qpack_id)
-- );

-- ALTER TABLE qpack2
--   ADD CONSTRAINT `fk_qpack2_qp_id` FOREIGN KEY (qp_id) REFERENCES qpack1(qp_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table qpack3
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS qpack3(
--   qpack_id int(10) unsigned NOT NULL,
--   item_id int(10) unsigned NOT NULL,
--   option_text varchar(255) NOT NULL,
--   PRIMARY KEY(qpack_id)
-- );

-- ALTER TABLE qpack3
--   ADD CONSTRAINT `fk_qpack3_qpack_id` FOREIGN KEY (qpack_id) REFERENCES qpack2(qpack_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_qpack3_item_id` FOREIGN KEY (item_id) REFERENCES qpack2(item_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table out_epack_header
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

-- --------------------------------------------------------
-- Table structure for table epack1
-- SELECT q.qp_id, q.maximum_marks, i.instruction_id, i.instruction_code, i.instruction_text, q.duration, b.batch_id, b.batch_code, b.batch_start_time, b.batch_end_time,
-- c.center_id, c.center_code, c.center_name, e.examdrive_id, e.examdrive_code, e.examdrive_name, co.course_master_id, co.course_code, co.course_name FROM ea_center c 
-- INNER JOIN ea_batch b ON c.center_id = b.center_id INNER JOIN ea_question_paper q on q.batch_id = b.batch_id LEFT JOIN ea_instruction i on i.qp_id = q.qp_id 
-- INNER JOIN ea_examdrive e on e.examdrive_id = b.examdrive_id INNER JOIN ea_course_master co ON e.course_master_id = co.course_master_id"
-- --------------------------------------------------------
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
  -- ADD CONSTRAINT `fk_epack1_centre_id` FOREIGN KEY (centre_id) REFERENCES out_epack_header(centre_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table epack2
-- SELECT i.qp_id, i.qp_item_id, i.item_text, i.item_marks, i.item_type, i.cognitive_level FROM ea_qp_item i WHERE q.qp_id = :qp_id")
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS epack2(
  epack2_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  epack1_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned UNIQUE NOT NULL,
  item_text varchar(255) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
  PRIMARY KEY(epack2_id)
);

ALTER TABLE epack2
  ADD CONSTRAINT `fk_epack2_epack1_id` FOREIGN KEY (epack1_id) REFERENCES epack1(epack1_id) ON DELETE CASCADE;

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


-- -- --------------------------------------------------------
-- -- Table structure for table in_mpack_header
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS in_mpack_header(
--   mpack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   mpack_desc varchar(255),
--   created_on datetime,
--   created_by varchar(255),
--   mpack_status ENUM('CREATED', 'SENT'),
--   mpack_sent_on datetime,
--   mpack_path varchar(255),
--   PRIMARY KEY(mpack_header_id)
-- );

-- -- --------------------------------------------------------
-- -- Table structure for table mpack1
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS mpack1(
--   mpack_header_id int(10) unsigned NOT NULL,
--   qp_id int(10) unsigned UNIQUE NOT NULL,
--   qp_code varchar(255) UNIQUE NOT NULL,
--   maximum_marks float(24) NOT NULL,
--   marks_obtained float(24) NOT NULL,
--   duration int(10) NOT NULL,
--   PRIMARY KEY(mpack_header_id)
-- );

-- ALTER TABLE mpack1
--   ADD CONSTRAINT `fk_mpack1_mpack_header_id` FOREIGN KEY (mpack_header_id) REFERENCES in_mpack_header(mpack_header_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table mpack2
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS mpack2(
--   mpack_id int(10) unsigned NOT NULL AUTO_INCREMENT,
--   qp_id int(10) unsigned NOT NULL,
--   item_id int(10) unsigned UNIQUE NOT NULL,
--   item_text varchar(255) NOT NULL,
--   item_marks float(24) unsigned NOT NULL,
--   item_type varchar(255) NOT NULL,
--   cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE'),
--   PRIMARY KEY(mpack_id)
-- );

-- ALTER TABLE mpack2
--   ADD CONSTRAINT `fk_mpack2_qp_id` FOREIGN KEY (qp_id) REFERENCES mpack1(qp_id) ON DELETE CASCADE;

-- -- --------------------------------------------------------
-- -- Table structure for table mpack3
-- -- --------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS mpack3(
--   mpack_id int(10) unsigned NOT NULL,
--   qp_id int(10) unsigned NOT NULL,
--   examinee_batch_id int(10) unsigned NOT NULL,
--   item_id int(10) unsigned UNIQUE NOT NULL,
--   item_marks_obtained float(24) unsigned NOT NULL,
--   PRIMARY KEY(mpack_id)
-- );

-- ALTER TABLE mpack3
--   ADD CONSTRAINT `fk_mpack3_qp_id` FOREIGN KEY (qp_id) REFERENCES mpack1(qp_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_mpack3_mpack_id` FOREIGN KEY (mpack_id) REFERENCES mpack2(mpack_id) ON DELETE CASCADE,
--   ADD CONSTRAINT `fk_mpack3_item_id` FOREIGN KEY (item_id) REFERENCES mpack2(item_id) ON DELETE CASCADE;