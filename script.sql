DROP TABLE IF EXISTS lottery_number;
CREATE TABLE lottery_number (
  id bigint NOT NULL AUTO_INCREMENT,
  number varchar(6) NOT NULL,
  three_digit_front varchar(3) NOT NULL,
  three_digit_last varchar(3) NOT NULL,
  two_digit_last varchar(2) NOT NULL,
  player_id bigint DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS reward_type;
CREATE TABLE reward_type (
   id bigint NOT NULL AUTO_INCREMENT,
   reward_type_name varchar(100) NOT NULL,
   reward_type_description varchar(500) DEFAULT NULL,
   digit int NOT NULL,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS reward_history;
CREATE TABLE reward_history (
    id bigint NOT NULL AUTO_INCREMENT,
    reward_number varchar(6) NOT NULL,
    reward_type_id varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS player;
CREATE TABLE player (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO reward_type (reward_type_name, reward_type_description, digit) VALUES('three_digit_front', 'รางวัลเลขหน้า 3 ตัว', 3);
INSERT INTO reward_type (reward_type_name, reward_type_description, digit) VALUES('three_digit_last', 'รางวัลเลขท้าย 3 ตัว', 3);
INSERT INTO reward_type (reward_type_name, reward_type_description, digit) VALUES('two_digit_last', 'รางวัลเลขท้าย 2 ตัว', 2);
INSERT INTO reward_type (reward_type_name, reward_type_description, digit) VALUES('six_digit', 'รางวัลที่ 1', 6);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('023725', '023', '725', '25', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('031264', '031', '264', '64', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('056151', '056', '151', '51', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('081171', '081', '171', '71', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('191849', '191', '849', '49', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('253038', '253', '038', '38', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('282831', '282', '831', '31', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('425079', '425', '079', '79', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('441031', '441', '031', '31', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('441031', '441', '031', '31', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('460937', '460', '937', '37', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('466941', '466', '941', '41', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('508146', '508', '146', '46', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('513847', '513', '847', '47', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('536698', '536', '698', '98', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('554360', '554', '360', '60', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('554673', '554', '673', '73', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('577698', '577', '698', '98', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('589041', '589', '041', '41', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('679295', '679', '295', '95', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('691695', '691', '695', '95', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('702267', '702', '267', '67', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('705559', '705', '559', '59', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('722095', '722', '095', '95', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('766338', '766', '338', '38', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('924336', '924', '336', '36', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('955789', '955', '789', '89', NULL);
INSERT INTO lottery_number (`number`, three_digit_front, three_digit_last, two_digit_last, player_id) VALUES('978410', '978', '410', '10', NULL);
