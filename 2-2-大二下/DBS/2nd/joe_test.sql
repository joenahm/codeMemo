-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2018-04-25 20:58:13
-- 服务器版本： 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.29-1+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joe_test`
--
CREATE DATABASE IF NOT EXISTS `joe_test` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `joe_test`;

-- --------------------------------------------------------

--
-- 表的结构 `buy`
--

CREATE TABLE `buy` (
  `cno` varchar(3) COLLATE utf8_bin NOT NULL,
  `pno` varchar(3) COLLATE utf8_bin NOT NULL,
  `bamt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `buy`
--

INSERT INTO `buy` (`cno`, `pno`, `bamt`) VALUES
('C01', 'M01', 13),
('C01', 'M04', 50),
('C01', 'M05', 12),
('C01', 'M06', 30);

-- --------------------------------------------------------

--
-- 表的结构 `customer`
--

CREATE TABLE `customer` (
  `cno` varchar(3) COLLATE utf8_bin NOT NULL,
  `cname` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `caddress` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`cno`, `cname`, `caddress`) VALUES
('C01', 'Dennis', '海淀'),
('C02', 'John', '朝阳');

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE `product` (
  `pno` varchar(3) COLLATE utf8_bin NOT NULL,
  `pname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pprice` float DEFAULT NULL,
  `ptype` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `psupplier` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`pno`, `pname`, `pprice`, `ptype`, `psupplier`) VALUES
('M01', '佳洁士', 8, '牙膏', '宝洁'),
('M02', '高露洁', 6.05, '牙膏', 'Colgate'),
('M03', '中华', 6, '牙膏', '中华'),
('M04', '黑人', 10, '牙膏', '黑人'),
('M05', '牙牙乐', 5, '牙膏', '纳爱斯'),
('M06', '佳洁士牙刷', 1.4, '牙刷', '佳洁士'),
('M07', '高露洁牙刷', 2.8, '牙刷', 'Colgate');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `sale`
--
CREATE TABLE `sale` (
`cno` varchar(3)
,`pno` varchar(3)
,`pname` varchar(20)
,`pprice` float
,`bamt` int(11)
);

-- --------------------------------------------------------

--
-- 视图结构 `sale`
--
DROP TABLE IF EXISTS `sale`;

CREATE ALGORITHM=UNDEFINED DEFINER=`joe`@`%` SQL SECURITY DEFINER VIEW `sale`  AS  select `customer`.`cno` AS `cno`,`product`.`pno` AS `pno`,`product`.`pname` AS `pname`,`product`.`pprice` AS `pprice`,`buy`.`bamt` AS `bamt` from ((`customer` join `product`) join `buy`) where ((`customer`.`cno` = `buy`.`cno`) and (`product`.`pno` = `buy`.`pno`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buy`
--
ALTER TABLE `buy`
  ADD PRIMARY KEY (`cno`,`pno`),
  ADD KEY `pno` (`pno`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cno`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pno`);

--
-- 限制导出的表
--

--
-- 限制表 `buy`
--
ALTER TABLE `buy`
  ADD CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `customer` (`cno`),
  ADD CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`pno`) REFERENCES `product` (`pno`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
