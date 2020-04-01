DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT(50) DEFAULT NOT NULL,
ssn INT(50) DEFAULT NOT NULL,
account_no INT(250) NOT NULL,
account_type VARCHAR(250) NOT NULL,
card_issued INT(1) DEFAULT 0,
card_no INT(250) DEFAULT 0000000
);

INSERT INTO accounts (user_id,ssn,account_no,account_type,card_issued,card_no) VALUES
(1,122232425,7647658,'Checkings',1,6476569),
(1,131433535,8756488,'Credit',1,57769867);

INSERT INTO accounts (user_id,ssn,account_no,account_type,card_issued) VALUES
(2,429742974,6758758,'Savings',1);