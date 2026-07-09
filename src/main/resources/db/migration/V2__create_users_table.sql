CREATE TABLE users (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100),

    email VARCHAR(150) NOT NULL UNIQUE,

    phone VARCHAR(20) UNIQUE,

    password VARCHAR(255) NOT NULL,

    role VARCHAR(30) NOT NULL,

    status VARCHAR(20) NOT NULL,

    created_by BIGINT,

    updated_by BIGINT,

    created_at DATETIME NOT NULL,

    updated_at DATETIME NOT NULL

);