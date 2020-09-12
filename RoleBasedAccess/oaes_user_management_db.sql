DROP DATABASE oaes_user_management_db;
CREATE DATABASE oaes_user_management_db;
USE oaes_user_management_db;
--
-- Database: `oaes_user_management_db`
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
  ADD CONSTRAINT `fk_um_user_role_user_id` FOREIGN KEY (user_id) REFERENCES um_user(user_id) ON DELETE SET NULL,
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

