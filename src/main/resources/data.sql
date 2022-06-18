DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS employees;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  enabled BOOLEAN
);

INSERT INTO users (username, password, enabled) VALUES
  ('admin', '$2a$10$FrPXLYS2vqKY5vpqHgP4muF4.FcwXX7OyPwXu.eVqevCn9GmB6apq', true),
  ('user', '$2a$10$FrPXLYS2vqKY5vpqHgP4muF4.FcwXX7OyPwXu.eVqevCn9GmB6apq', true),
  ('guest', '$2a$10$FrPXLYS2vqKY5vpqHgP4muF4.FcwXX7OyPwXu.eVqevCn9GmB6apq', true);

CREATE TABLE roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO roles (name) VALUES
  ('USER'),
  ('ADMIN'),
  ('MANAGER');


CREATE TABLE users_roles (
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(role_id) REFERENCES roles(id),
  PRIMARY KEY (user_id, role_id)
);

INSERT INTO users_roles (user_id, role_id) VALUES
  (1, 2),
  (2, 1),
  (2, 2),
  (2, 3),
  (3, 1);