CREATE DATABASE IF NOT EXISTS `crud-user`;
USE `crud-user`;

CREATE TABLE IF NOT EXISTS `user` (
	id BIGINT AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    money INT DEFAULT NULL,
    CONSTRAINT `user_PK` PRIMARY KEY (`id`),
    CONSTRAINT `user_email_UQ` UNIQUE KEY (`email`)
);

CREATE TABLE IF NOT EXISTS `user_profile` (
	id BIGINT AUTO_INCREMENT,
    country VARCHAR(30) DEFAULT NULL,
    city VARCHAR(50) DEFAULT NULL,
    street VARCHAR(50) DEFAULT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT `user_profike_PK` PRIMARY KEY (`id`),
    CONSTRAINT `user_profile_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) 
);

# insert some records
INSERT INTO `user` VALUES 
	(1, 'Rick', 'Novak', 'rick.novak@gmail.com', 25000),
	(2, 'Olivia', 'Clark', 'olivia.clark@gmail.com', 25000),
	(3, 'Noah', 'Smith', 'noah.smith@gmail.com', 10750),
	(4, 'Charlotte', 'Williams', 'charlotte.williams@gmail.com', 46500),
	(5, 'Bob', 'Jhonson', 'bob.jhonson@gmail.com', 2500),
	(6, 'Sophia', 'Lopez', 'sophia.lopez@gmail.com', 63100),
    (7, 'Lucas', 'Moore', 'lucas.moore@gmail.com', 33250),
    (8, 'James', 'Wilson', 'james.wilson@gmail.com', 13400),
    (9, 'Henry', 'King', 'henry.king@gmail.com', 150700),
    (10, 'Petro', 'Pochynok', 'petro.pochynok@gmail.com', 32400);
INSERT INTO `user_profile` VALUES 
	(1, 'Canada', 'Toronto', 'Milmink Street', 1),
    (2, 'Australia', 'Perth', 'Brisbane Terrace', 2),
    (3, 'Ireland', 'Dublin', 'Henrietta Street', 3),
    (4, 'Italy', 'Milan', 'Via Dante', 4),
    (5, 'Norway', 'Stavanger', 'Baneveien', 5),
    (6, 'Finland', 'Helsinki', 'Esplanadi', 6),
    (7, 'Sweden', 'Stockholm', 'Svartensgatan', 7),
    (8, 'Iceland', 'Akureyri', 'Valagil', 8),
    (9, 'Switzerland', 'Bern', 'Blockweg', 9),
    (10, 'Ukraine', 'New Rozdol', 'Shevchenka 39', 10);
    

