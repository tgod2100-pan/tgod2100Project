CREATE TABLE IF NOT EXISTS tutorials (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    published BOOLEAN DEFAULT FALSE
);