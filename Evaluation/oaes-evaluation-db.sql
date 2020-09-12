DROP DATABASE oaes_evaluation_db;
CREATE DATABASE oaes_evaluation_db;
USE oaes_evaluation_db;
--
-- Database: `oaes_evaluation_db`
--

-- --------------------------------------------------------
-- Table structure for table `ev_question_paper`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_question_paper(
  qp_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  qp_code varchar(255) UNIQUE NOT NULL,
  maximum_marks float(24) NOT NULL DEFAULT 100,
  duration int(10) NOT NULL DEFAULT 180,
  PRIMARY KEY(qp_id)
);

-- --------------------------------------------------------
-- Table structure for table `ev_itemtype_master`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_itemtype_master (
  itemtype_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  itemtype_code varchar(255) UNIQUE NOT NULL,
  itemtype_name varchar(255) NOT NULL,
  itemtype_category ENUM('AUTO','MANUAL') DEFAULT 'MANUAL',
  PRIMARY KEY (itemtype_id)
);

-- --------------------------------------------------------
-- Table structure for table `ev_qp_item`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_qp_item (
  qp_item_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_code varchar(255) UNIQUE NOT NULL,
  item_text varchar(511) NOT NULL,
  item_marks float(24) unsigned NOT NULL,
  item_type varchar(255) NOT NULL,
  qp_id int(10) unsigned,
  PRIMARY KEY (qp_item_id)
);

ALTER TABLE ev_qp_item
  ADD CONSTRAINT `fk_ev_qp_item_qp_id` FOREIGN KEY (qp_id) REFERENCES ev_question_paper(qp_id) ON DELETE SET NULL;


-- --------------------------------------------------------
-- Table structure for table `ev_item_mcq_options`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_item_mcq_options(
  item_mcq_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_mcq_options_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  mcq_option_text varchar(255) NOT NULL,
  mcq_option_percentage float(24) DEFAULT 0.0,
  PRIMARY KEY(item_mcq_id)
);

ALTER TABLE ev_item_mcq_options
  ADD CONSTRAINT `fk_ev_item_mcq_options_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ev_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `ev_item_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_item_true_false(
  item_true_false_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
  item_true_false_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  true_percentage float(24) DEFAULT 0.0,
  false_percentage  float(24) DEFAULT 0.0,
  PRIMARY KEY(item_true_false_id)
);

ALTER TABLE ev_item_true_false
  ADD CONSTRAINT `fk_ev_item_true_false_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ev_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `ev_drive_center_examinee`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_drive_center_examinee(
  drive_center_examinee_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(drive_center_examinee_id)
);

-- --------------------------------------------------------
-- Table structure for table ev_examinee_item_marks
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_examinee_item_marks(
	examinee_item_marks_id int(10) unsigned NOT NULL AUTO_INCREMENT,
	examinee_item_marks float(24) NOT NULL,
	drive_center_examinee_id int(10) unsigned,
	qp_item_id int(10) unsigned,
	PRIMARY KEY (examinee_item_marks_id)
);

ALTER TABLE ev_examinee_item_marks
  ADD CONSTRAINT `fk_ev_examinee_item_marks_drive_center_examinee_id` FOREIGN KEY (drive_center_examinee_id) REFERENCES ev_drive_center_examinee(drive_center_examinee_id) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_ev_examinee_item_marks_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ev_qp_item(qp_item_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `ev_response`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_response (
  response_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  response_code varchar(255) UNIQUE NOT NULL,
  qp_item_id int(10) unsigned,
  PRIMARY KEY (response_id)
);

ALTER TABLE ev_response
  ADD CONSTRAINT `fk_ev_response_qp_item_id` FOREIGN KEY (qp_item_id) REFERENCES ev_qp_item(qp_item_id) ON DELETE SET NULL;
 
-- --------------------------------------------------------
-- Table structure for table `ev_response_mcq`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_response_mcq (
  response_mcq_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  response_mcq_code varchar(255) UNIQUE NOT NULL,
  response_text varchar(511) NOT NULL,
  response_id int(10) unsigned,
  PRIMARY KEY (response_mcq_id)
);

ALTER TABLE ev_response_mcq
  ADD CONSTRAINT `fk_ev_response_mcq_response_id` FOREIGN KEY (response_id) REFERENCES ev_response(response_id) ON DELETE SET NULL;

-- --------------------------------------------------------
-- Table structure for table `ev_response_true_false`
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ev_response_true_false (
  response_true_false_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  response_true_false_code varchar(255) UNIQUE NOT NULL,
  response_id int(10) unsigned,
  PRIMARY KEY (response_true_false_id)
);

ALTER TABLE ev_response_true_false
  ADD CONSTRAINT `fk_ev_response_true_false_response_id` FOREIGN KEY (response_id) REFERENCES ev_response(response_id) ON DELETE SET NULL;


