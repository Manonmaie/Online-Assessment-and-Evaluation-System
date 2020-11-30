drop table IF EXISTS au_item_true_false;
drop table IF EXISTS au_item_mcq_options;
drop table IF EXISTS au_qp_item;
drop table IF EXISTS au_item;
drop table IF EXISTS au_course_master;
drop table IF EXISTS au_instruction;
drop table IF EXISTS au_question_paper;
drop table IF EXISTS au_course_master;



CREATE TABLE IF NOT EXISTS au_course_master (
course_master_id int(10) unsigned NOT NULL AUTO_INCREMENT,
course_code varchar(255) UNIQUE NOT NULL,
course_name varchar(255) NOT NULL,
PRIMARY KEY (course_master_id)
);
-- --------------------------------------------------------
-- Data Entry for table `au_course_master`
-- --------------------------------------------------------
INSERT INTO au_course_master VALUES(0,"dbms_101","DBMS");
INSERT INTO au_course_master VALUES(0,"dm_102","Data Modelling");
INSERT INTO au_course_master VALUES(0,"dp_103","Design Patterns");



CREATE TABLE IF NOT EXISTS `au_item` (
		`item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
		`item_text` text(1024) NOT NULL,
    		`item_type` varchar(255) NOT NULL,
		`cognitive_level` ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE') DEFAULT 'UNDERSTAND',
		`difficulty_level` ENUM('EASY', 'EASY-MEDIUM', 'MEDIUM', 'HARD-MEDIUM', 'HARD') DEFAULT 'EASY',
    		`review_status` ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
		`marks` float(24) unsigned NOT NULL,
		`item_status` ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
		`item_use_count` int(10) unsigned DEFAULT 0,
		`author_id` int(10)unsigned,
		`course_master_id` int(10) unsigned,
		PRIMARY KEY (`item_id`) );

ALTER TABLE au_item
	ADD CONSTRAINT `fk_item_course` FOREIGN KEY (course_master_id) REFERENCES au_course_master(course_master_id) ON DELETE SET NULL;


    INSERT INTO au_item VALUES(0,'<figure class="image"><img src="data:image/jpeg;base64,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"></figure> What is a database?',"McqSingleCorrect","UNDERSTAND","EASY","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"What is a  PK?","McqSingleCorrect","UNDERSTAND","MEDIUM","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"What is a FK?","McqMultiCorrect","APPLY","HARD","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"UK and PK are same.","True/False","APPLY","HARD","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"What is a database?","McqSingleCorrect","EVALUATE","EASY","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"Uk with no null values is Pk.","True/False","APPLY","HARD","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"What is a  PK?","McqSingleCorrect","UNDERSTAND","MEDIUM","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"What is a FK?","McqMultiCorrect","ANALYZE","EASY","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"UK and PK are same.","True/False","EVALUATE","EASY","APPROVED",1,"ACTIVE",0,1,1);
    INSERT INTO au_item VALUES(0,"Uk with no null values is Pk.","True/False","ANALYZE","EASY","APPROVED",1,"ACTIVE",0,1,2);
    INSERT INTO au_item VALUES(0,"What is a  PK?","McqSingleCorrect","UNDERSTAND","MEDIUM","APPROVED",2,"ACTIVE",0,1,2);
    INSERT INTO au_item VALUES(0,"What is a database?","McqSingleCorrect","UNDERSTAND","EASY","APPROVED",2,"ACTIVE",0,1,2);
    INSERT INTO au_item VALUES(0,"What is a FK?","McqMultiCorrect","UNDERSTAND","EASY-MEDIUM","APPROVED",2,"ACTIVE",0,1,3);
    INSERT INTO au_item VALUES(0,"UK and PK are same.","True/False","ANALYZE","EASY","APPROVED",2,"ACTIVE",0,1,3);
    INSERT INTO au_item VALUES(0,"Uk with no null values is Pk.","True/False","UNDERSTAND","EASY-MEDIUM","APPROVED",2,"ACTIVE",0,1,3);





CREATE TABLE IF NOT EXISTS `au_item_true_false` (
	    `item_true_false_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	    `item_id` int(10) unsigned,
	    `true_percent` int(10) unsigned,
	    `false_percent` int(10) unsigned,
	    PRIMARY KEY (`item_true_false_id`)
	);

ALTER TABLE au_item_true_false
	ADD CONSTRAINT `fk_itemTrueFalse_item` FOREIGN KEY (item_id) REFERENCES au_item(item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Data Entry for table `as_item_true_false`
-- --------------------------------------------------------
INSERT INTO au_item_true_false VALUES(0,9,100,0);
INSERT INTO au_item_true_false VALUES(0,8,0,100);
INSERT INTO au_item_true_false VALUES(0,14,100,0);
INSERT INTO au_item_true_false VALUES(0,15,100,0);


CREATE TABLE IF NOT EXISTS `au_item_mcq_options` (
	    `item_mcq_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	    `item_id` int(10) unsigned,
	    `mcq_option_text` varchar(255) NOT NULL,
	    `mcq_option_marks` int(10),
	    PRIMARY KEY (`item_mcq_id`)
	);


ALTER TABLE au_item_mcq_options
  ADD CONSTRAINT `fk_itemMcqOptions_item` FOREIGN KEY (item_id) REFERENCES au_item(item_id) ON DELETE SET NULL;


  INSERT INTO au_item_mcq_options VALUES(0,1,"Collection of related data",1);
  INSERT INTO au_item_mcq_options VALUES(0,1,"Collection of data",0);
  INSERT INTO au_item_mcq_options VALUES(0,1,"Collection of words",0);
  INSERT INTO au_item_mcq_options VALUES(0,1,"Collection of people",0);
  INSERT INTO au_item_mcq_options VALUES(0,2,"Primary Key",1);
  INSERT INTO au_item_mcq_options VALUES(0,2,"Personal Key",0);
  INSERT INTO au_item_mcq_options VALUES(0,2,"Person Key",0);
  INSERT INTO au_item_mcq_options VALUES(0,2,"Primary Keyword",0);
  INSERT INTO au_item_mcq_options VALUES(0,3,"Foreign Key",0);
  INSERT INTO au_item_mcq_options VALUES(0,3,"Foreign Keyword",1);
  INSERT INTO au_item_mcq_options VALUES(0,3,"Fashion Key",0);
  INSERT INTO au_item_mcq_options VALUES(0,3,"Forward Key",0);





CREATE TABLE IF NOT EXISTS `au_question_paper` (
      `qp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `course_master_id` int(10) unsigned,
      `batch_code` varchar(255),
      `maximum_marks` int(10) unsigned NOT NULL,
      `duration` int(10) unsigned NOT NULL,
      PRIMARY KEY (`qp_id`)
  );
ALTER TABLE au_question_paper
	ADD CONSTRAINT `fk_qp_course` FOREIGN KEY (course_master_id) REFERENCES au_course_master(course_master_id) ON DELETE SET NULL;
 

  -- ------------------------------------------------------
  -- Data Entry for table `au_question_paper`
  -- --------------------------------------------------------
  INSERT INTO au_question_paper VALUES(0,"1","batch1",100,180);
  INSERT INTO au_question_paper VALUES(0,"1","batch2",50,120);
  INSERT INTO au_question_paper VALUES(0,"1","batch3",25,60);


  CREATE TABLE IF NOT EXISTS `au_qp_item` (
      `qp_item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `qp_id` int(10) unsigned,
      `item_id` int(10) unsigned,
      PRIMARY KEY (`qp_item_id`)
  );

  ALTER TABLE au_qp_item
    ADD CONSTRAINT `fk_questionPaperItem_questionPaper` FOREIGN KEY (qp_id) REFERENCES au_question_paper(qp_id) ON DELETE SET NULL,
    ADD CONSTRAINT `fk_questionPaperItem_ItemID` FOREIGN KEY (item_id) REFERENCES au_item(item_id) ON DELETE SET NULL;

    INSERT INTO au_qp_item VALUES(0,1,1);
    INSERT INTO au_qp_item VALUES(0,1,3);
    INSERT INTO au_qp_item VALUES(0,1,2);
    INSERT INTO au_qp_item VALUES(0,2,8);
    INSERT INTO au_qp_item VALUES(0,2,6);
    INSERT INTO au_qp_item VALUES(0,3,4);
    INSERT INTO au_qp_item VALUES(0,3,6);
    INSERT INTO au_qp_item VALUES(0,3,9);
    INSERT INTO au_qp_item VALUES(0,3,2);



  CREATE TABLE IF NOT EXISTS au_instruction(
    instruction_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    qp_id int(10) unsigned,
    instruction_text varchar(255) NOT NULL,
    PRIMARY KEY(instruction_id)
  );
  ALTER TABLE au_instruction
    ADD CONSTRAINT `fk_au_instruction_qp_id` FOREIGN KEY (qp_id) REFERENCES au_question_paper(qp_id) ON DELETE SET NULL;


    -- --------------------------------------------------------
    -- Data Entry for table `au_instruction`
    -- --------------------------------------------------------
    INSERT INTO au_instruction VALUES(0,1,"Exam duration is 3 hrs");
    INSERT INTO au_instruction VALUES(0,1,"It has two sections");
    INSERT INTO au_instruction VALUES(0,1,"Each section contributes to 50% of the total marks");
    INSERT INTO au_instruction VALUES(0,2,"Exam duration is 2 hrs");
    INSERT INTO au_instruction VALUES(0,2,"It has only one section");
    INSERT INTO au_instruction VALUES(0,3,"Exam duration is 1 hr");
    INSERT INTO au_instruction VALUES(0,3,"It has only one section with no negative marking");

-- --------------------------------------------------------
-- Table structure for table out_qpack_header
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS out_qpack_header(
  qpack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qpack_desc varchar(255),
  created_on datetime,
  created_by varchar(255),
  qpack_status ENUM('CREATED', 'SENT') DEFAULT 'CREATED',
  qpack_sent_on datetime,
  qpack_path varchar(255),
  PRIMARY KEY(qpack_header_id)
);

-- --------------------------------------------------------
-- Table structure for table qpack1
-- SELECT q.qp_id, q.maximum_marks, q.duration, q.course_code, q.batch_code, i.instruction_id, i.instruction_text FROM au_question_paper q INNER JOIN au_instruction i
-- ON q.qp_id = i.qp_id;
-- Then fetch course_id and course_name using course_code from course_master and add it to qpack1 
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS qpack1(
  qpack1_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qpack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  maximum_marks int(10) NOT NULL,
  instruction_id int(10) unsigned UNIQUE,
  instruction_text varchar(255),
  duration int(10) NOT NULL,
  course_id int(10) unsigned NOT NULL,
  course_code varchar(255) NOT NULL,
  course_name varchar(255) NOT NULL,
  batch_code varchar(255) NOT NULL,
  PRIMARY KEY(qpack1_id)
);

ALTER TABLE qpack1
  ADD CONSTRAINT `fk_qpack1_qpack_header_id` FOREIGN KEY (qpack_header_id) REFERENCES out_qpack_header(qpack_header_id) ON DELETE CASCADE;


-- --------------------------------------------------------
-- Table structure for table qpack2
-- SELECT q.qp_id, i.item_id, i.item_text, i.marks, i.item_type, i.cognitive_level FROM au_item i INNER JOIN au_qp_item q ON q.item_id = i.item_id;
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS qpack2(
  qpack2_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qpack1_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  item_text text(1024) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  cognitive_level ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE')  NOT NULL,
  PRIMARY KEY(qpack2_id)
);

ALTER TABLE qpack2
  ADD CONSTRAINT `fk_qpack2_qpack1_id` FOREIGN KEY (qpack1_id) REFERENCES qpack1(qpack1_id) ON DELETE CASCADE;


-- --------------------------------------------------------
-- Table structure for table qpack3
-- SELECT i.item_id, o.item_mcq_id, o.mcq_option_text FROM au_qp_item i INNER JOIN au_item_mcq_options o ON i.item_id = o.item_id;
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS qpack3(
  qpack3_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qpack2_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  item_option_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  PRIMARY KEY(qpack3_id)
);

ALTER TABLE qpack3
  ADD CONSTRAINT `fk_qpack3_qpack2_id` FOREIGN KEY (qpack2_id) REFERENCES qpack2(qpack2_id) ON DELETE CASCADE;


-- --------------------------------------------------------
-- Table structure for table out_apack_header
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS out_apack_header(
  apack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  apack_desc varchar(255),
  created_on datetime,
  created_by varchar(255),
  apack_status ENUM('CREATED', 'SENT') DEFAULT 'CREATED',
  apack_sent_on datetime,
  apack_path varchar(255),
  PRIMARY KEY(apack_header_id)
);

-- --------------------------------------------------------
-- Table structure for table apack1
-- SELECT q.qp_id, i.item_id, i.item_text, i.marks, i.item_type FROM au_item i INNER JOIN au_qp_item q ON q.item_id = i.item_id;
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS apack1(
  apack1_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  apack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  item_text text(1024) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  PRIMARY KEY(apack1_id)
);

ALTER TABLE apack1
  ADD CONSTRAINT `fk_apack1_apack_header_id` FOREIGN KEY (apack_header_id) REFERENCES out_apack_header(apack_header_id) ON DELETE CASCADE;

  -- --------------------------------------------------------
-- Table structure for table apack2
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS apack2(
  apack2_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  apack1_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  qp_item_id int(10) unsigned NOT NULL,
  item_option_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  option_percentage int(10) NOT NULL,
  PRIMARY KEY(apack2_id)
);

ALTER TABLE apack2
  ADD CONSTRAINT `fk_apack2_apack1_id` FOREIGN KEY (apack1_id) REFERENCES apack1(apack1_id) ON DELETE CASCADE;