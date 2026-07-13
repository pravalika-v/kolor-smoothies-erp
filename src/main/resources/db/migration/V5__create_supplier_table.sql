CREATE TABLE suppliers (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    supplier_code VARCHAR(20) NOT NULL UNIQUE,

    name VARCHAR(150) NOT NULL,

    contact_person VARCHAR(100),

    mobile VARCHAR(20) NOT NULL,

    email VARCHAR(100),

    gst_number VARCHAR(20),

    pan_number VARCHAR(20),

    address_line1 VARCHAR(255),

    address_line2 VARCHAR(255),

    city VARCHAR(100),

    state VARCHAR(100),

    pincode VARCHAR(20),

    country VARCHAR(100),

    status VARCHAR(20) NOT NULL,

    created_by BIGINT,

    created_at DATETIME,

    updated_by BIGINT,

    updated_At DATETIME,
    
     version BIGINT NOT NULL DEFAULT 0
);

CREATE INDEX idx_supplier_name
ON suppliers(name);

CREATE INDEX idx_supplier_status
ON suppliers(status);

CREATE INDEX idx_supplier_code
ON suppliers(supplier_code);