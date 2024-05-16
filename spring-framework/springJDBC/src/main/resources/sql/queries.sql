-- 키=값
-- ? 대신에 :변수 로 작성할 것..

-- SQL to insert a user
INSERT_USER=INSERT INTO users (name, email) VALUES (:name, :email);

-- SQL to fetch all users
GET_ALL_USERS=SELECT id, name, email FROM users;

-- SQL to update a user's email
UPDATE_USER_EMAIL=UPDATE users SET email = :email WHERE name = :name;

-- SQL to delete a user
DELETE_USER=DELETE FROM users WHERE name = :name;