CREATE TABLE api_assistente_ia.users (
	id bigserial NOT NULL,
	uuid UUID DEFAULT gen_random_uuid() NOT NULL,
	username varchar(50) NOT NULL,  -- Tamanho definido
	"password" varchar(255) NOT NULL,  -- Tamanho para hash
	email varchar(100) UNIQUE,  -- Campo email é comum
	status varchar(20) DEFAULT 'ACTIVE' NOT NULL,  -- Enum-like com tamanho
	deleted boolean DEFAULT false NOT NULL,  -- NOT NULL mais seguro
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,  -- Auditoria
	
	-- Constraints
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_uuid_unique UNIQUE (uuid),
	CONSTRAINT users_username_unique UNIQUE (username),
    CONSTRAINT users_email_unique UNIQUE (email)
);
