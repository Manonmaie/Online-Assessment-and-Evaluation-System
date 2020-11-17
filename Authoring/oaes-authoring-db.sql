DROP DATABASE oaes_authoring_db;
CREATE DATABASE oaes_authoring_db;

USE oaes_authoring_db;

--
-- Database: `oaes_authoring_db`
--


-- --------------------------------------------------------
-- Table structure for table um_user
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS um_user(
  user_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_name varchar(255) UNIQUE NOT NULL,
  password varchar(255) UNIQUE NOT NULL,
  status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
  PRIMARY KEY(user_id)
);



-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
    `course_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `course_code` varchar(255) UNIQUE NOT NULL,
    `course_name` varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY (`course_id`)
);



-- --------------------------------------------------------

--
-- Table structure for table `course_outcome`
--

CREATE TABLE IF NOT EXISTS `course_outcome` (
    `course_outcome_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `course_id` int(10) unsigned,
    `outcome_text` varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY (`course_outcome_id`)
);

ALTER TABLE course_outcome
  ADD CONSTRAINT `fk_course_outcome_course_id` FOREIGN KEY (course_id) REFERENCES course(course_id) ON DELETE SET NULL;



-- --------------------------------------------------------

--
-- Table structure for table `itemtype_master`
--

CREATE TABLE IF NOT EXISTS `itemtype_master` (
    `itemtype_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `itemtype_name` varchar(255) UNIQUE NOT NULL,
    `itemtype_category` ENUM('AUTO','MANUAL') DEFAULT 'AUTO',
    PRIMARY KEY (`itemtype_id`)
);



-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
    `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `course_outcome_id` int(10) unsigned,
    `itemtype_id` int(10) unsigned,
    `item_code` varchar(255) UNIQUE NOT NULL,
    `item_text` varchar(1024) NOT NULL,
    `cognitive_level` ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE') DEFAULT 'UNDERSTAND',
    `marks` int(4) unsigned NOT NULL,
    `review_status` ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
    `item_status` ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
    `item_use_count` int(10) unsigned DEFAULT 0,
    PRIMARY KEY (`item_id`)
);

ALTER TABLE item
  ADD CONSTRAINT `fk_item_itemtypeMaster` FOREIGN KEY (itemtype_id) REFERENCES itemtype_master(itemtype_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_item_courseOutcomeId` FOREIGN KEY (course_outcome_id) REFERENCES course_outcome(course_outcome_id) ON DELETE SET NULL;



-- --------------------------------------------------------

--
-- Table structure for table `item_review`
--

CREATE TABLE IF NOT EXISTS `item_review` (
    `review_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `item_id` int(10) unsigned,
    `reviewer_id` int(10) unsigned,
    `review_date_time` timestamp ,
    `review_remarks` varchar(1024) ,
    `course_name` varchar(255) UNIQUE NOT NULL,
    `review_status` ENUM('PENDING','APPROVED','REJECTED') DEFAULT 'PENDING',
    PRIMARY KEY (`review_id`)
);

ALTER TABLE item_review
  ADD CONSTRAINT `fk_itemReview_item` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_itemReview_reviewerId` FOREIGN KEY (reviewer_id) REFERENCES um_user(user_id) ON DELETE SET NULL;




-- --------------------------------------------------------

--
-- Table structure for table `item_mcq_options`
--

CREATE TABLE IF NOT EXISTS `item_mcq_options` (
    `item_mcq_options_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `item_id` int(10) unsigned,
    `mcq_option_text` varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY (`item_mcq_options_id`)
);

ALTER TABLE item_mcq_options
  ADD CONSTRAINT `fk_itemMcqOptions_item` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL;
 


-- --------------------------------------------------------

--
-- Table structure for table `item_true_false`
--

CREATE TABLE IF NOT EXISTS `item_true_false` (
    `item_true_false_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `item_id` int(10) unsigned,
    `true_percent` int(10) unsigned,
    `false_percent` int(10) unsigned,
    PRIMARY KEY (`item_true_false_id`)
);

ALTER TABLE item_true_false
  ADD CONSTRAINT `fk_itemTrueFalse_item` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL;
 


-- --------------------------------------------------------

--
-- Table structure for table `question_paper`
--

CREATE TABLE IF NOT EXISTS `question_paper` (
    `question_paper_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `course_id` int(10) unsigned,
    `total_marks` int(10) unsigned NOT NULL,
    PRIMARY KEY (`question_paper_id`)
);

ALTER TABLE question_paper
  ADD CONSTRAINT `fk_questionPaper_CourseId` FOREIGN KEY (course_id) REFERENCES course(course_id) ON DELETE SET NULL;
 


-- --------------------------------------------------------

--
-- Table structure for table `question_Paper_item`
--

CREATE TABLE IF NOT EXISTS `question_paper_item` (
    `question_paper_item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `question_paper_id` int(10) unsigned,
    `item_id` int(10) unsigned,
    PRIMARY KEY (`question_paper_item_id`)
);

ALTER TABLE question_paper_item
  ADD CONSTRAINT `fk_questionPaperItem_questionPaper` FOREIGN KEY (question_paper_id) REFERENCES question_paper(question_paper_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_questionPaperItem_ItemID` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL;




-- --------------------------------------------------------

--
-- Table structure for table `question_Paper_review`
--

CREATE TABLE IF NOT EXISTS `question_paper_review` (
    `question_paper_review_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `question_paper_id` int(10) unsigned,
    `reviewer_id` int(10) unsigned,
    `review_date_time` timestamp ,
    `review_remarks` varchar(1024) ,
    `review_status` ENUM('PENDING','APPROVED','REJECTED') DEFAULT 'PENDING',
    PRIMARY KEY (`question_paper_review_id`)
);

ALTER TABLE question_paper_review
  ADD CONSTRAINT `fk_questionPaperReview_questionPaper` FOREIGN KEY (question_paper_id) REFERENCES question_paper(question_paper_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_questionPaperItem_reviewId` FOREIGN KEY (reviewer_id) REFERENCES um_user(user_id) ON DELETE SET NULL;


-- --------------------------------------------------------
-- Table structure for table um_role_master
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS um_role_master(
  role_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  role_name varchar(255) UNIQUE NOT NULL,
  module_name ENUM('AU', 'AS', 'EVAL', 'EA'),
  PRIMARY KEY(role_id)
);

-- --------------------------------------------------------
-- Table structure for table um_user_role
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS um_user_role(
  user_role_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_id int(10) unsigned,
  role_id int(10) unsigned,
  PRIMARY KEY(user_role_id)
);

ALTER TABLE um_user_role
  ADD CONSTRAINT `fk_um_usercourse_outcome_id_role_user_id` FOREIGN KEY (user_id) REFERENCES um_user(user_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_um_user_role_role_id` FOREIGN KEY (role_id) REFERENCES um_role_master(role_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table um_action_master
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS um_action_master(
  action_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  action_name varchar(255) UNIQUE NOT NULL,
  module_name ENUM('AU', 'AS', 'EVAL', 'EA'),
  PRIMARY KEY(action_id)
);

-- --------------------------------------------------------
-- Table structure for table um_role_action
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS um_role_action(
  role_action_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  role_id int(10) unsigned,
  action_id int(10) unsigned,
  PRIMARY KEY(role_action_id)
);

ALTER TABLE um_role_action
  ADD CONSTRAINT `fk_um_role_action_role_id` FOREIGN KEY (role_id) REFERENCES um_role_master(role_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_um_role_action_action_id` FOREIGN KEY (action_id) REFERENCES um_action_master(action_id) ON DELETE SET NULL;


-- --------------------------------------------------------
-- Table structure for table out_qpack_header
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS out_qpack_header(
  qpack_header_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qpack_desc varchar(255),
  created_on datetime,
  created_by varchar(255),
  qpack_status ENUM('CREATED', 'SENT'),
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
  item_text varchar(255) NOT NULL,
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
  item_mcq_id int(10) unsigned NOT NULL,
  mcq_option_text varchar(255) NOT NULL,
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
  apack_status ENUM('CREATED', 'SENT'),
  apack_sent_on datetime,
  apack_path varchar(255),
  PRIMARY KEY(apack_header_id)
);

-- --------------------------------------------------------
-- Table structure for table apack1
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS apack1(
  apack_header_id int(10) unsigned NOT NULL,
  qp_id int(10) unsigned NOT NULL,
  qp_code varchar(255) NOT NULL,
  item_id int(10) unsigned UNIQUE NOT NULL,
  item_text varchar(255) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  PRIMARY KEY(apack_header_id)
);

ALTER TABLE apack1
  ADD CONSTRAINT `fk_apack1_apack_header_id` FOREIGN KEY (apack_header_id) REFERENCES out_apack_header(apack_header_id) ON DELETE CASCADE;

-- --------------------------------------------------------
-- Table structure for table apack2
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS apack2(
  apack_id int(10) unsigned NOT NULL,
  item_id int(10) unsigned NOT NULL,
  option_text varchar(255) NOT NULL,
  option_percentage float(24),
  PRIMARY KEY(apack_id)
);

ALTER TABLE apack2
  ADD CONSTRAINT `fk_apack2_item_id` FOREIGN KEY (item_id) REFERENCES apack1(item_id) ON DELETE CASCADE;
