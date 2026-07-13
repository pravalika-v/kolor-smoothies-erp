CREATE TABLE categories (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(100) NOT NULL UNIQUE,

    description VARCHAR(500),

    status VARCHAR(20) NOT NULL,

    created_at DATETIME NOT NULL,

    updated_at DATETIME,

    created_by BIGINT,

    updated_by BIGINT,

    version BIGINT NOT NULL DEFAULT 0
);