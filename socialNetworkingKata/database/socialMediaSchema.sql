BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
        username varchar(64) PRIMARY KEY NOT NULL UNIQUE,
        firstName varchar(32) NOT NULL,
        password varchar (32) NOT NULL
);

DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
        post_id serial PRIMARY KEY,
        username varchar(64) NOT NULL,
        message varchar (512) NOT NULL,
        time_posted TIMESTAMP DEFAULT Now(),
    
        FOREIGN KEY (username) references users (username)
);
        
DROP TABLE IF EXISTS followers;

CREATE TABLE followers (       
        username varchar(64) NOT NULL,
        follows_user varchar(64) NOT NULL
);

COMMIT TRANSACTION;

INSERT INTO users(username, firstname, password) VALUES ('Alice', 'Alice', 'alicespassword');
INSERT INTO users(username, firstname, password) VALUES ('Bob', 'Bob', 'bobspassword');
INSERT INTO users(username, firstname, password) VALUES ('Charlie', 'Charlie', 'charliespassword');
INSERT INTO posts(username, message) VALUES ('Alice', 'I love the weather today.');
INSERT INTO posts(username, message) VALUES ('Bob', 'Darn! We lost!');
INSERT INTO posts(username, message) VALUES ('Bob', 'Good game though.');
INSERT INTO posts(username, message) VALUES ('Charlie', 'I''m in New York today! Anyone want to have a coffee?');
INSERT INTO followers(username, follows_user) VALUES ('Bob', 'Alice');
INSERT INTO followers(username, follows_user) VALUES ('Bob', 'Charlie');


