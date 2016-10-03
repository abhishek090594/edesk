-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2016 at 08:43 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `erd`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
`ad_id` int(4) NOT NULL,
  `ad_emailid` varchar(70) NOT NULL,
  `ad_password` varchar(32) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ad_id`, `ad_emailid`, `ad_password`) VALUES
(1, 'admin@gmail.com', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `coursename`
--

CREATE TABLE IF NOT EXISTS `coursename` (
`con_id` int(3) NOT NULL,
  `con_name` varchar(36) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coursename`
--

INSERT INTO `coursename` (`con_id`, `con_name`) VALUES
(1, 'Bachelor of Computer Application'),
(2, 'Bachelor of Business Administrator'),
(3, 'Master Of Computer Apllication'),
(4, 'Master Of Business Administrator'),
(5, 'MSC-CA'),
(6, 'MSC-ICT');

-- --------------------------------------------------------

--
-- Table structure for table `institutename`
--

CREATE TABLE IF NOT EXISTS `institutename` (
`inn_id` int(3) NOT NULL,
  `inn_name` varchar(85) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `institutename`
--

INSERT INTO `institutename` (`inn_id`, `inn_name`) VALUES
(1, 'Shree Madhav Institute Of Computer Application and Information Technology'),
(2, 'Udhna Citizen College Of Computer Application and Information Technology'),
(3, 'S.D.J Inernational College'),
(4, 'Bhagwan Mahavir of Computer Application and Information Technology');

-- --------------------------------------------------------

--
-- Table structure for table `panelhead`
--

CREATE TABLE IF NOT EXISTS `panelhead` (
`ph_id` int(4) NOT NULL,
  `ph_name` varchar(35) NOT NULL,
  `stf_id` int(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `panelhead`
--

INSERT INTO `panelhead` (`ph_id`, `ph_name`, `stf_id`) VALUES
(34, 'Mayuri Patel', 20),
(37, 'Neha Topiwala', 19),
(38, 'Ronak Gandhi', 26);

-- --------------------------------------------------------

--
-- Table structure for table `panelmembers`
--

CREATE TABLE IF NOT EXISTS `panelmembers` (
`pnm_id` int(4) NOT NULL,
  `ph_id` int(4) NOT NULL,
  `stf_id` int(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `panelmembers`
--

INSERT INTO `panelmembers` (`pnm_id`, `ph_id`, `stf_id`) VALUES
(46, 37, 22),
(47, 37, 27),
(48, 34, 21),
(49, 34, 23),
(52, 38, 24),
(55, 38, 25);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
`stf_id` int(4) NOT NULL,
  `stf_name` varchar(35) NOT NULL,
  `stf_address` varchar(80) NOT NULL,
  `stf_contact` bigint(20) DEFAULT NULL,
  `stf_emailid` varchar(70) NOT NULL,
  `stf_image` varchar(100) DEFAULT NULL,
  `stf_password` varchar(32) NOT NULL,
  `stf_status` tinyint(1) NOT NULL,
  `stf_dateofjoin` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`stf_id`, `stf_name`, `stf_address`, `stf_contact`, `stf_emailid`, `stf_image`, `stf_password`, `stf_status`, `stf_dateofjoin`) VALUES
(19, 'Neha Topiwala', 'Adajan', 9876785461, 'neha121@gmail.com', 'null', 'neha123', 1, '2016-05-11 10:37:08'),
(20, 'Mayuri Patel', 'Unn', 9876785400, 'mayuri@gmail.com', 'null', 'mayuri123', 1, '2016-05-11 10:26:21'),
(21, 'Khushbu Patel', 'Udhna', 8876785461, 'khushbu121@gmail.com', 'null', 'khushbu123', 0, '2016-05-11 10:27:21'),
(22, 'Dipal Patel', 'Bhestan', 9876785433, 'dipal121@gmail.com', 'null', 'dipal123', 0, '2016-05-11 10:28:35'),
(23, 'Poonam Yadav', 'Sachin', 9876785412, 'poonam121@gmail.com', 'null', 'poonam123', 0, '2016-05-11 10:29:26'),
(24, 'Himadri Patel', 'Bardoli', 9876781161, 'himadri@gmail.com', 'null', 'himadri123', 0, '2016-05-11 10:30:39'),
(25, 'Krishna Tailor', 'Bhagal', 7876785461, 'krishna121@gmail.com', 'null', 'krishna123', 0, '2016-05-11 10:32:27'),
(26, 'Ronak Gandhi', 'Parle Point', 9876785333, 'ronak121@gmail.com', 'null', 'ronak123', 1, '2016-05-11 10:33:36'),
(27, 'Anita Gyanchandani', 'Ukai', 9876785455, 'anita121@gmail.com', 'null', 'anita123', 0, '2016-05-11 10:37:42');

-- --------------------------------------------------------

--
-- Table structure for table `studentinquiry`
--

CREATE TABLE IF NOT EXISTS `studentinquiry` (
`stud_id` int(4) NOT NULL,
  `stf_id` int(4) NOT NULL,
  `inn_id` int(3) NOT NULL,
  `con_id` int(3) NOT NULL,
  `stud_name` varchar(35) NOT NULL,
  `stud_address` varchar(150) NOT NULL,
  `stud_contact` bigint(20) NOT NULL,
  `stud_emailid` varchar(70) NOT NULL,
  `stud_percentage` float NOT NULL,
  `stud_status` tinyint(1) NOT NULL,
  `stud_inquirydate` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentinquiry`
--

INSERT INTO `studentinquiry` (`stud_id`, `stf_id`, `inn_id`, `con_id`, `stud_name`, `stud_address`, `stud_contact`, `stud_emailid`, `stud_percentage`, `stud_status`, `stud_inquirydate`) VALUES
(24, 19, 2, 1, 'maitree thakkar', 'pandesara surat', 8460235641, 'maitree@gmail.com', 99, 1, '2016-05-11 10:44:33'),
(25, 19, 3, 3, 'Rudra Trivedi', 'ahemdavad', 9988774455, 'maitreer@gmail.com', 88, 1, '2016-05-11 10:45:39'),
(26, 19, 3, 3, 'nilay thakar', 'pandesara surat', 7889663322, 'nilay@gmail.com', 88, 0, '2016-05-11 10:49:58'),
(27, 22, 2, 3, 'govind dubey', 'swapna srusti socity bhestan surat', 7456982130, 'govind@gmail.com', 555, 0, '2016-05-11 10:54:47'),
(28, 22, 4, 3, 'bhagyashree soni', 'parvat patiya surat', 7788996655, 'bhagy@gmail.com', 33, 0, '2016-05-11 10:54:55'),
(29, 22, 3, 3, 'pritesh patel', 'boarding navsari ', 7456982130, 'pritesh@gmail.com', 96, 1, '2016-05-11 10:55:55'),
(30, 27, 3, 3, 'rudresh', 'dindolo surat', 7896541230, 'rudresh@gmail.com', 99, 1, '2016-05-11 11:00:38'),
(31, 27, 1, 3, 'Sohil Chamadia', 'uvan socity unn', 7869654145, 'sohil@gmail.com', 87, 1, '2016-05-11 11:01:25'),
(32, 27, 2, 3, 'valand darshan ', 'bhestan station road surat', 9913093442, 'ds210083@gmail.com', 99, 0, '2016-05-11 11:02:42'),
(33, 23, 3, 4, 'Akshay Dudhwala', 'Udhna Darwaja,Surat', 9081213576, 'akshay121@ymail.com', 79, 0, '2016-05-11 07:23:53'),
(34, 23, 1, 5, 'Mamta Shah', 'Ring-Road', 8908793245, 'mamta@gmail.com', 91, 0, '2016-05-11 07:22:27'),
(35, 23, 2, 2, 'Neha Desai', 'Belgium Square', 8904312345, 'neha444@gmail.com', 69, 1, '2016-05-11 07:23:20'),
(36, 23, 4, 6, 'Roshan Rathod', 'Harinagar', 9601232456, 'roshan@gmail.com', 68, 0, '2016-05-11 07:24:48'),
(37, 21, 4, 6, 'Abhishek Prajapati', 'Bardoli', 8923124565, 'abhi@gmail.com', 89, 1, '2016-05-11 07:28:06'),
(38, 21, 2, 2, 'Karan Patel', 'Bhestan', 9987032154, 'karan@gmail.com', 68, 1, '2016-05-11 07:28:50'),
(39, 21, 2, 3, 'Sana Patil', 'Sachin', 8879023243, 'sana@gmail.com', 74, 0, '2016-05-11 07:29:51'),
(40, 21, 2, 3, 'Irfan Haider', 'irfan111@gmail.com', 8890213245, 'irfan232@gmail.com', 71, 0, '2016-05-11 07:33:25');

-- --------------------------------------------------------

--
-- Table structure for table `taskassign`
--

CREATE TABLE IF NOT EXISTS `taskassign` (
`taskAssign_id` int(11) NOT NULL,
  `ph_id` int(11) NOT NULL,
  `taskAssign_startdate` date NOT NULL,
  `taskAssign_enddate` date NOT NULL,
  `taskAssign_description` varchar(150) NOT NULL,
  `taskAssign_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`ad_id`);

--
-- Indexes for table `coursename`
--
ALTER TABLE `coursename`
 ADD PRIMARY KEY (`con_id`);

--
-- Indexes for table `institutename`
--
ALTER TABLE `institutename`
 ADD PRIMARY KEY (`inn_id`);

--
-- Indexes for table `panelhead`
--
ALTER TABLE `panelhead`
 ADD PRIMARY KEY (`ph_id`);

--
-- Indexes for table `panelmembers`
--
ALTER TABLE `panelmembers`
 ADD PRIMARY KEY (`pnm_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
 ADD PRIMARY KEY (`stf_id`);

--
-- Indexes for table `studentinquiry`
--
ALTER TABLE `studentinquiry`
 ADD PRIMARY KEY (`stud_id`);

--
-- Indexes for table `taskassign`
--
ALTER TABLE `taskassign`
 ADD PRIMARY KEY (`taskAssign_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `ad_id` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `coursename`
--
ALTER TABLE `coursename`
MODIFY `con_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `institutename`
--
ALTER TABLE `institutename`
MODIFY `inn_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `panelhead`
--
ALTER TABLE `panelhead`
MODIFY `ph_id` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `panelmembers`
--
ALTER TABLE `panelmembers`
MODIFY `pnm_id` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
MODIFY `stf_id` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `studentinquiry`
--
ALTER TABLE `studentinquiry`
MODIFY `stud_id` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `taskassign`
--
ALTER TABLE `taskassign`
MODIFY `taskAssign_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
