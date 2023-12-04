DROP TABLE IF EXISTS lottery_number;
CREATE TABLE lottery_number (
                                  id bigint NOT NULL AUTO_INCREMENT,
                                  number varchar(6) NOT NULL,
                                  three_digit_front varchar(3) NOT NULL,
                                  three_digit_last varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                  two_digit_last varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                  owner varchar(100) DEFAULT NULL,
                                  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS reward_type;
CREATE TABLE reward_type (
                               id bigint NOT NULL AUTO_INCREMENT,
                               reward_type_name varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                               reward_type_description varchar(500) DEFAULT NULL,
                               PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS reward_history;
CREATE TABLE reward_history (
                                  id bigint NOT NULL AUTO_INCREMENT,
                                  reward_number varchar(6) NOT NULL,
                                  reward_type_id varchar(100) DEFAULT NULL,
                                  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;