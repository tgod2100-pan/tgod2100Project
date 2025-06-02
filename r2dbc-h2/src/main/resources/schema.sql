CREATE TABLE IF NOT EXISTS tutorials (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    published BOOLEAN DEFAULT FALSE
);

-- INSERT INTO tutorials (title, description, published) VALUES ('Spring Boot