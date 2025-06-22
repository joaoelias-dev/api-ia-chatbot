-- Tabela: companies
CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT gen_random_uuid() NOT NULL,
    brand_name VARCHAR(255) NOT NULL,
    legal_name VARCHAR(255),
    taxid VARCHAR(100),
    email VARCHAR(255),
    website VARCHAR(255),
    currency VARCHAR(10),
    timezone VARCHAR(100),
    deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- Tabela: company_phones
CREATE TABLE company_phones (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT gen_random_uuid() NOT NULL,
    ddi VARCHAR(10) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    description VARCHAR(255),
    company_id INTEGER NOT NULL,
    CONSTRAINT fk_company_phones_company FOREIGN KEY (company_id) 
        REFERENCES companies (id)
);

-- Tabela: company_addresses
CREATE TABLE company_addresses (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT gen_random_uuid() NOT NULL,
    country VARCHAR(100),
    state VARCHAR(100),
    city VARCHAR(100),
    zipcode VARCHAR(20),
    addressline VARCHAR(255),
    district VARCHAR(100),
    number VARCHAR(20),
    complement VARCHAR(255),
    company_id INTEGER NOT NULL,
    CONSTRAINT fk_company_addresses_company FOREIGN KEY (company_id)
        REFERENCES companies (id)
);

-- Tabela: my_company
CREATE TABLE my_company (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT gen_random_uuid() NOT NULL,
    company_id INTEGER NOT NULL UNIQUE,
    CONSTRAINT fk_my_company_company FOREIGN KEY (company_id) 
        REFERENCES companies (id)
);
