DROP DATABASE IF EXISTS moodle;
CREATE DATABASE moodle;
USE moodle;
CREATE TABLE role(
	id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE user(
	id INT NOT NULL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    role_id INT DEFAULT NULL,
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE user_ip_address(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    ip_address VARCHAR(255) NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES user(id) 
);

CREATE TABLE category(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE course(
	id INT NOT NULL  PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT FOREIGN	KEY (category_id) REFERENCES category(id)
);

CREATE TABLE course_module(
	id INT NOT NULL  PRIMARY KEY,
    resource_name VARCHAR(255) NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT FOREIGN	KEY (course_id) REFERENCES course(id)
);

CREATE TABLE course_enrollment(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_enrolling_id INT NOT NULL,
    user_being_enrolled_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (user_enrolling_id) REFERENCES user(id),
    CONSTRAINT FOREIGN KEY (user_being_enrolled_id) REFERENCES user(id)
);

CREATE TABLE course_module_updated(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    course_module_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT FOREIGN KEY (course_module_id) REFERENCES course_module(id)
);

INSERT INTO role VALUES 
	(5, 'student');

INSERT INTO user VALUES
    (2, 'Gabrijela', 'Petrov', null),
    (109, 'Marko', 'Cvetkov', null),
    (4773, 'John', 'Doe', null),
    (5464, 'Dijana', 'Antovska', 5),
    (6361, 'Jane', 'Doe', null);

