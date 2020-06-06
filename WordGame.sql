-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2020 at 08:09 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wordgame`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `current_level` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`fname`, `lname`, `uname`, `pass`, `current_level`, `user_id`) VALUES
('Dennis', 'Essuman', 'DEQ', 'DEQ', NULL, 1),
('Samuel', 'Essuman', 'SEQ', 'seq', NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `word`
--

CREATE TABLE `word` (
  `word` varchar(20) DEFAULT NULL,
  `hint` varchar(200) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `word_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `word`
--

INSERT INTO `word` (`word`, `hint`, `level`, `word_id`) VALUES
('ABUSE', 'TO USE IMPROPERLY OR EXCESSIVELY', 3, 1),
('ASSET', 'A USEFUL OR VALUABLE QUALITY,PERSON OR THING', 3, 2),
('CRASH', 'TO BREAK VIOLENTLY OR DESTRUCTION ON IMPACT', 3, 3),
('GREEN', 'VISIBLE SPECTRUM LYING BETWEEN YELLOW AND BLUE', 3, 4),
('MEDIA', 'MEANS OF COMMUNICATION', 3, 5),
('BANK', 'A BUSINESS ESTABLISHMENT IN WHICH MONEY IS KEPT', 2, 6),
('DARK', 'LACKING OR HAVING VERY LITTLE LIGHT', 2, 7),
('DOOR', 'SLIDING PANEL FOR CLOSING THE ENTRANCE TO A ROOM', 2, 8),
('FILM', 'A LONG NARRATIVE MOVIE', 2, 9),
('FUND', 'A SUM OF MONEY SET ASIDE FOR A SPECIFIC PURPOSE', 2, 10),
('AIL', 'TROUBLE OR AFFLICT IN MIND OR BODY', 1, 11),
('NET', 'TO CATCH FISH IN A MESH DEVICE', 1, 12),
('PEN', 'TO WRITE DOWN ON PAPER', 1, 13),
('EWE', 'A FEMALE SHEEP', 1, 14),
('GUN', 'TO DISCHARGE BULLETS', 1, 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `word`
--
ALTER TABLE `word`
  ADD PRIMARY KEY (`word_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `word`
--
ALTER TABLE `word`
  MODIFY `word_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
