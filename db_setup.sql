CREATE DATABASE IF NOT EXISTS sample_db_for_myapp;

CREATE TABLE IF NOT EXISTS user (
user_id INT NOT NULL UNIQUE,
user_name VARCHAR(100) NOT NULL UNIQUE,
user_pass VARCHAR(200) NOT NULL,
first_name VARCHAR(100) DEFAULT "Lorem",
last_name VARCHAR(100) DEFAULT "Ipsum",
profile_info VARCHAR(100) DEFAULT "No profile specified",
PRIMARY KEY(user_id)
);

INSERT INTO user VALUES 
(1, "guest", "guest", "Guest", "", "This is a guest profile for testing purpose."),
(2, "admin", "admin", "Admin", "", "owner of this site.");
