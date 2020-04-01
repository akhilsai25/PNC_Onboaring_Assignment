DROP TABLE IF EXISTS users;

CREATE TABLE users (
id INT(50) AUTO_INCREMENT PRIMARY KEY,
ssn INT(50) DEFAULT NOT NULL,
first_name VARCHAR(250) NOT NULL,
last_name VARCHAR(250) NOT NULL,
address VARCHAR(250) DEFAULT NULL,
phone INT(10) DEFAULT NULL
);

INSERT INTO users (ssn,first_name,last_name,address,phone) VALUES
(122232425,'Akhil','Sai','add1',424242542),
(429742974,'Sai','Pothul','add2',222525566),
(131433535,'Sambi','Virtusa','add3',363634844);
