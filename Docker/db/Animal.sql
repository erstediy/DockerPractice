DROP DATABASE IF EXISTS docker;

CREATE DATABASE docker;

USE docker;

DROP TABLE IF EXISTS `Animal`;
CREATE TABLE `Animal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `type` varchar(30) NOT NULL,
  `sex` varchar(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
);

INSERT INTO Animal VALUES(1, 13, 'cat', 'w');
INSERT INTO Animal VALUES(2,11,'dog','m');
