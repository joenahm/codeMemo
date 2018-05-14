-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2018-05-14 10:06:53
-- 服务器版本： 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joe_student`
--
CREATE DATABASE IF NOT EXISTS `joe_student` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `joe_student`;

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `name` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `gender` varchar(1) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `id` int(11) NOT NULL COMMENT '学号',
  `major` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '专业',
  `grade` varchar(3) COLLATE utf8_bin NOT NULL COMMENT '年级',
  `class` varchar(5) COLLATE utf8_bin NOT NULL COMMENT '班级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`name`, `gender`, `id`, `major`, `grade`, `class`) VALUES
('小明', '男', 201601001, '数学', '16', '1班'),
('小红', '女', 201602001, '物理', '16', '2班');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
