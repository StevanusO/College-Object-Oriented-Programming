-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2022 at 08:35 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jtexpress`
--

-- --------------------------------------------------------

--
-- Table structure for table `electronicitem`
--

CREATE TABLE `electronicitem` (
  `itemID` char(5) NOT NULL,
  `itemName` varchar(255) NOT NULL,
  `weight` float NOT NULL,
  `warranty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `electronicitem`
--

INSERT INTO `electronicitem` (`itemID`, `itemName`, `weight`, `warranty`) VALUES
('EI001', 'Handphone', 1, 1),
('EI002', 'Laptop', 3, 3),
('EI003', 'Computer', 7, 1),
('EI004', 'Headset', 0.5, 1),
('EI005', 'Digital Camera', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nonelectronicitem`
--

CREATE TABLE `nonelectronicitem` (
  `itemID` char(5) NOT NULL,
  `itemName` varchar(255) NOT NULL,
  `weight` float NOT NULL,
  `fragile` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nonelectronicitem`
--

INSERT INTO `nonelectronicitem` (`itemID`, `itemName`, `weight`, `fragile`) VALUES
('NE001', 'Clock', 1, 1),
('NE002', 'Bedroom Set', 11.5, 0),
('NE003', 'Chair', 2, 0),
('NE004', 'Carpet', 1, 0),
('NE005', 'Sofa', 6.5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `packageID` char(5) NOT NULL,
  `itemID` char(5) NOT NULL,
  `recipientName` varchar(255) NOT NULL,
  `recipientAddress` varchar(255) NOT NULL,
  `userEmail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electronicitem`
--
ALTER TABLE `electronicitem`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `nonelectronicitem`
--
ALTER TABLE `nonelectronicitem`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`packageID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
