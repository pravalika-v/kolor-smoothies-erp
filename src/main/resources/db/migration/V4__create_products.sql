CREATE TABLE products (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(150) NOT NULL,
    sku VARCHAR(100) NOT NULL UNIQUE,
    barcode VARCHAR(100),

    description VARCHAR(500),

    category_id BIGINT NOT NULL,

    unit VARCHAR(30) NOT NULL,

    purchase_price DECIMAL(12,2) NOT NULL,
    selling_price DECIMAL(12,2) NOT NULL,

    tax_percentage DECIMAL(5,2),

    status VARCHAR(20) NOT NULL,

    created_by BIGINT,

    updated_by BIGINT,
    
    created_at DATETIME NOT NULL,

    updated_at DATETIME,

    version BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
        REFERENCES categories(id)
);