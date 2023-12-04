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

INSERT INTO reward_type (id, reward_type_name, reward_type_description)
VALUES(1, 'three_digit_front', 'รางวัลเลขหน้า 3 ตัว');
INSERT INTO reward_type (id, reward_type_name, reward_type_description)
VALUES(2, 'three_digit_last', 'รางวัลเลขท้าย 3 ตัว');
INSERT INTO reward_type (id, reward_type_name, reward_type_description)
VALUES(3, 'two_digit_last', 'รางวัลเลขท้าย 2 ตัว');
INSERT INTO reward_type (id, reward_type_name, reward_type_description)
VALUES(4, 'six_digit', 'รางวัลที่ 1');
