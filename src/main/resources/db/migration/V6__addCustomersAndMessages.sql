-- Tabela customers
CREATE TABLE IF NOT EXISTS api_assistente_ia.customers
(
    id BIGSERIAL PRIMARY KEY,
    uuid uuid DEFAULT gen_random_uuid(),
    full_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    deleted_at timestamp with time zone,
    CONSTRAINT customers_uuid_key UNIQUE (uuid)
);

-- Tabela ollama_conversations
CREATE TABLE IF NOT EXISTS api_assistente_ia.ollama_conversations
(
    id BIGSERIAL PRIMARY KEY,
    uuid uuid DEFAULT gen_random_uuid(),
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    deleted_at timestamp with time zone DEFAULT now(),
    customer_id bigint NOT NULL,
    CONSTRAINT ollama_conversations_uuid_key UNIQUE (uuid),
    CONSTRAINT ollama_conversations_customer_id_fkey FOREIGN KEY (customer_id)
        REFERENCES api_assistente_ia.customers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Tabela ollama_messages
CREATE TABLE IF NOT EXISTS api_assistente_ia.ollama_messages
(
    id BIGSERIAL PRIMARY KEY,
    uuid uuid DEFAULT gen_random_uuid(),
    conversation_id bigint NOT NULL,
    role character varying(50) COLLATE pg_catalog."default" NOT NULL,
    content text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    CONSTRAINT ollama_messages_uuid_key UNIQUE (uuid),
    CONSTRAINT ollama_messages_conversation_id_fkey FOREIGN KEY (conversation_id)
        REFERENCES api_assistente_ia.ollama_conversations (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Índices para melhor performance
CREATE INDEX IF NOT EXISTS idx_customers_uuid ON api_assistente_ia.customers(uuid);
CREATE INDEX IF NOT EXISTS idx_ollama_conversations_uuid ON api_assistente_ia.ollama_conversations(uuid);
CREATE INDEX IF NOT EXISTS idx_ollama_conversations_customer_id ON api_assistente_ia.ollama_conversations(customer_id);
CREATE INDEX IF NOT EXISTS idx_ollama_messages_uuid ON api_assistente_ia.ollama_messages(uuid);
CREATE INDEX IF NOT EXISTS idx_ollama_messages_conversation_id ON api_assistente_ia.ollama_messages(conversation_id);
CREATE INDEX IF NOT EXISTS idx_ollama_messages_created_at ON api_assistente_ia.ollama_messages(created_at);