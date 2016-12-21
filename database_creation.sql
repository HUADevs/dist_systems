SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2247234_spring`
--

-- --------------------------------------------------------

--
-- Table structure for table `Citizens`
--
DROP TABLE History,HistoryInc,DamageForm,Insurance,Rights,Service,Vehicle,Vehicles,Citizens,Customers,User,Role,Department;

CREATE TABLE `Citizens` (
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `personal_id` varchar(8) NOT NULL,
  `tax_reg_number` int(9) NOT NULL,
  `license_date` date NOT NULL,
  `birthday_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Customers`
--

CREATE TABLE `Customers` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `personal_id` varchar(8) NOT NULL,
  `tax_reg_number` int(9) NOT NULL,
  `license_date` date NOT NULL,
  `birthday_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `DamageForm`
--

CREATE TABLE `DamageForm` (
  `id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `photo` mediumblob NOT NULL,
  `cost` double NOT NULL,
  `date` date NOT NULL,
  `approval` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE `Department` (
  `department_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `region` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `num_of_emp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `History`
--

CREATE TABLE `History` (
  `incident_id` int(11) NOT NULL,
  `personal_id` varchar(8) NOT NULL,
  `incident` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `HistoryInc`
--

CREATE TABLE `HistoryInc` (
  `id` int(11) NOT NULL,
  `person_id` varchar(8) NOT NULL,
  `inc_description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Insurance`
--

CREATE TABLE `Insurance` (
  `vehicle_id` int(11) NOT NULL,
  `date_start` date NOT NULL,
  `price` double NOT NULL,
  `discount` double DEFAULT NULL,
  `type` varchar(15) NOT NULL,
  `new_driver` tinyint(1) DEFAULT NULL,
  `duration` smallint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Rights`
--

CREATE TABLE `Rights` (
  `right_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Service`
--

CREATE TABLE `Service` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Vehicle`
--

CREATE TABLE `Vehicle` (
  `vehicle_id` int(11) NOT NULL,
  `license_plate` varchar(7) NOT NULL,
  `person_id` varchar(8) NOT NULL,
  `release_date` date NOT NULL,
  `cubic` int(5) NOT NULL,
  `type` varchar(15) NOT NULL,
  `color` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Vehicles`
--

CREATE TABLE `Vehicles` (
  `license_plate` varchar(7) NOT NULL,
  `person_id` varchar(8) NOT NULL,
  `release_date` date NOT NULL,
  `cubic` int(5) NOT NULL,
  `type` varchar(15) NOT NULL,
  `color` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Citizens`
--
ALTER TABLE `Citizens`
  ADD PRIMARY KEY (`personal_id`),
  ADD UNIQUE KEY `tax_reg_number` (`tax_reg_number`);

--
-- Indexes for table `Customers`
--
ALTER TABLE `Customers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_id` (`personal_id`),
  ADD UNIQUE KEY `tax_reg_number` (`tax_reg_number`);

--
-- Indexes for table `DamageForm`
--
ALTER TABLE `DamageForm`
  ADD PRIMARY KEY (`id`);
--
-- Indexes for table `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`department_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `History`
--
ALTER TABLE `History`
  ADD PRIMARY KEY (`incident_id`),
  ADD KEY `personal_id` (`personal_id`);

--
-- Indexes for table `HistoryInc`
--
ALTER TABLE `HistoryInc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `person_id` (`person_id`);

--
-- Indexes for table `Insurance`
--
ALTER TABLE `Insurance`
  ADD PRIMARY KEY (`vehicle_id`);

--
-- Indexes for table `Rights`
--
ALTER TABLE `Rights`
  ADD PRIMARY KEY (`right_id`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `Service`
--
ALTER TABLE `Service`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `Vehicle`
--
ALTER TABLE `Vehicle`
  ADD PRIMARY KEY (`vehicle_id`),
  ADD KEY `person_id` (`person_id`),
  ADD UNIQUE KEY `license_plate` (`license_plate`);

--
-- Indexes for table `Vehicles`
--
ALTER TABLE `Vehicles`
  ADD PRIMARY KEY (`license_plate`),
  ADD KEY `person_id` (`person_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Customers`
--
ALTER TABLE `Customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `DamageForm`
--
ALTER TABLE `DamageForm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Department`
--
ALTER TABLE `Department`
  MODIFY `department_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `History`
--
ALTER TABLE `History`
  MODIFY `incident_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `HistoryInc`
--
ALTER TABLE `HistoryInc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Insurance`
--

--
-- AUTO_INCREMENT for table `Rights`
--
ALTER TABLE `Rights`
  MODIFY `right_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Role`
--
ALTER TABLE `Role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Service`
--
ALTER TABLE `Service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Vehicle`
--
ALTER TABLE `Vehicle`
  MODIFY `vehicle_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `DamageForm`
--
ALTER TABLE `DamageForm`
  ADD CONSTRAINT `DamageForm_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `Vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `History`
--
ALTER TABLE `History`
  ADD CONSTRAINT `History_ibfk_1` FOREIGN KEY (`personal_id`) REFERENCES `Customers` (`personal_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `HistoryInc`
--
ALTER TABLE `HistoryInc`
  ADD CONSTRAINT `HistoryInc_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `Citizens` (`personal_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Insurance`
--
ALTER TABLE `Insurance`
  ADD CONSTRAINT `Insurance_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `Vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Rights`
--
ALTER TABLE `Rights`
  ADD CONSTRAINT `Rights_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `Role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Rights_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `Service` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `User_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `Role` (`role_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `User_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `Department` (`department_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `Vehicle`
--
ALTER TABLE `Vehicle`
  ADD CONSTRAINT `Vehicle_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `Customers` (`personal_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Vehicles`
--
ALTER TABLE `Vehicles`
  ADD CONSTRAINT `Vehicles_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `Citizens` (`personal_id`) ON DELETE CASCADE ON UPDATE CASCADE;
  

insert into Citizens values("Winner","areall","US795436", "753146823","2010/11/04",'1996/08/04');

insert into Vehicles values("ZXC1235","US795436","1967/12/06",5000,"muscle","blue");

select * from damageform;
delete from vehicle where license_plate='ZXC1235';
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
commit;