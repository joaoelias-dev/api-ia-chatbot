
CREATE TABLE api_assistente_ia.appointments_status (
	id bigserial NOT NULL,
	uuid UUID DEFAULT gen_random_uuid() NOT NULL,
	status varchar NOT NULL,
	deleted bool NULL,
	CONSTRAINT appointments_status_pk PRIMARY KEY (id),
	CONSTRAINT appointments_status_unique UNIQUE ("uuid")
);

CREATE TABLE appointments (
    id BIGSERIAL PRIMARY KEY,
    uuid UUID DEFAULT gen_random_uuid() NOT NULL,
    title VARCHAR(255),
    starts TIMESTAMP WITH TIME ZONE NOT NULL,
    ends TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'SCHEDULED',
    description TEXT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE,
    user_account_id BIGINT NOT NULL,
	CONSTRAINT appointments_unique UNIQUE ("uuid"),
	CONSTRAINT appointments_users_fk FOREIGN KEY (user_account_id) REFERENCES api_assistente_ia.users_accounts(id)
);
