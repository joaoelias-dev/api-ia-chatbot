CREATE TABLE api_assistente_ia.users_accounts (
	id bigserial NOT NULL,
	uuid UUID DEFAULT gen_random_uuid() NOT NULL,
	username varchar(50) NOT NULL,
	"password" varchar(255) NOT NULL,
	email varchar(100) UNIQUE,
	status varchar(20) DEFAULT 'ACTIVE' NOT NULL,
	deleted boolean DEFAULT false NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,

	-- Constraints
	CONSTRAINT users_accounts_pkey PRIMARY KEY (id),
	CONSTRAINT users_accounts_uuid_unique UNIQUE (uuid),
	CONSTRAINT users_accounts_username_unique UNIQUE (username),
	CONSTRAINT users_accounts_email_unique UNIQUE (email)
);
