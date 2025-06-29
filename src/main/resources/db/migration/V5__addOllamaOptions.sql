-- Tabela: ollama_options
CREATE TABLE ollama_options (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    temperature NUMERIC(2,1) CHECK (temperature >= 0.0 AND temperature <= 1.0),
    top_p NUMERIC(2,1) CHECK (top_p >= 0.1 AND top_p <= 1.0),
    num_predict INTEGER
);

-- Tabela: ollama_configs
CREATE TABLE ollama_configs (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    model VARCHAR(255),
    prompt TEXT,
    suffix VARCHAR(255),
    images VARCHAR(255),
    think BOOLEAN,
    format VARCHAR(255),
    system TEXT,
    template TEXT,
    options_id INTEGER REFERENCES ollama_options(id) ON DELETE SET NULL,
    stream BOOLEAN,
    raw BOOLEAN,
    keep_alive VARCHAR(255)
);

-- Tabela: company
CREATE TABLE company (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    name VARCHAR(255) NOT NULL
    -- Outros campos que você tiver no seu modelo de Company
);

-- Tabela: ollama_company_configs
CREATE TABLE ollama_company_configs (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    company_id INTEGER NOT NULL REFERENCES company(id) ON DELETE CASCADE,
    ollama_config_id INTEGER NOT NULL REFERENCES ollama_configs(id) ON DELETE CASCADE
);

-- Tabela: ollama_history_chats
CREATE TABLE ollama_history_chats (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    company_config_id INTEGER NOT NULL REFERENCES ollama_company_configs(id) ON DELETE CASCADE,
    role VARCHAR(50) NOT NULL,
    content TEXT NOT NULL
);
