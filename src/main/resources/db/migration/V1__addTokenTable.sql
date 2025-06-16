-- Cria extensão para geração de UUIDs
-- Flyway:postgresql
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Cria schema (caso ainda não exista)
CREATE SCHEMA IF NOT EXISTS api_assistente_ia;

-- Cria tabela de tokens
CREATE TABLE IF NOT EXISTS api_assistente_ia.tokens (
    id BIGSERIAL PRIMARY KEY,
    uuid UUID DEFAULT gen_random_uuid() NOT NULL,
    token VARCHAR NOT NULL UNIQUE,
    descricao VARCHAR,
    validade TIMESTAMPTZ, -- data e hora com fuso
    status VARCHAR DEFAULT 'liberado',
    CONSTRAINT tokens_uuid_unique UNIQUE (uuid)
);