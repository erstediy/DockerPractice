DROP DATABASE IF EXISTS DockerPractice;

CREATE DATABASE DockerPractice;

USE DockerPractice;

DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `type` varchar(30) NOT NULL,
  `sex` varchar(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
);

INSERT INTO animal VALUES(1, 13, 'cat', 'w');
INSERT INTO animal VALUES(2,11,'dog','m');
