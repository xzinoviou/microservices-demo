
CREATE TABLE `song` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `artist` varchar(255) DEFAULT NULL,
  `bar_code` varchar(13) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8lhckxjlahgvoiceie2px0x9x` (`bar_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;