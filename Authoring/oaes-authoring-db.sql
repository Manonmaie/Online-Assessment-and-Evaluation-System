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
