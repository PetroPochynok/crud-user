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
(2, 'Olivia', 'Clark', 'olivia.clark@gmail.com', 5700),
(3, 'Noah', 'Smith', 'noah.smith@gmail.com', 10750),
(4, 'Charlotte', 'Williams', 'charlotte.williams@gmail.com', 46500),
(5, 'Bob', 'Jhonson', 'bob.jhonson@gmail.com', 2500),
(6, 'Sophia', 'Lopez', 'sophia.lopez@outlook.com', 63100),
(7, 'Lucas', 'Moore', 'lucas.moore@outlook.com', 33250),
(8, 'James', 'Wilson', 'james.wilson@outlook.com', 13400),
(9, 'Henry', 'King', 'henry.king@outlook.com', 150700),
(10, 'Petro', 'Pochynok', 'petro.pochynok@gmail.com', 32400),
(11, 'Bob', 'Lopez', 'bob.lopez@iCloud.com', 63100),
(12, 'James', 'Williams', 'james.williams@iCloud.com', 15100),
(13, 'Rick', 'Clark', 'rick.clark@iCloud.com', 42500),
(14, 'Sophia', 'Moore', 'sophia.moore@iCloud.com', 57100),
(15, 'Noah', 'Williams', 'noah.williams@iCloud.com', 2100),
(16, 'Zakhar', 'Pavlenko', 'zakhar.pavlenko@yandex.ua', 95250),
(17, 'Yevheniia', 'Boyko', 'yevheniia.boyko@gmail.com', 32500),
(18, 'Zhanna', 'Tkachenko', 'zhanna.tkachenko@yandex.ua', 47350),
(19, 'Dmitry ', 'Kovalchuk', 'dmitry.kovalchuk@gmail.com', 120700),
(20, 'Halyna', 'Havrylyuk', 'halyna.havrylyuk@yandex.ua', 74500);
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
(10, 'Ukraine', 'New Rozdol', 'Shevchenka 39', 10),
(11, 'Australia', 'Sydney', 'King Street', 11),
(12, 'Italy', 'Rome', 'Via del Corso', 12),
(13, 'Finland', 'Espoo', 'Aamutie', 13),
(14, 'Canada', 'Montreal', 'Sainte-Catherine Street', 14),
(15, 'Norway', 'Trondheim', 'Bakkegata', 15),
(16, 'Ukraine', 'Mykolaiv', 'Vinnytsia', 16),
(17, 'Ukraine', 'Odesa', 'Vinnytsia', 17),
(18, 'Ukraine', 'Lviv', 'Vinnytsia', 18),
(19, 'Ukraine', 'Kiev', 'Vinnytsia', 19),
(20, 'Ukraine', 'Vinnytsia', 'Vinnytsia', 20);
