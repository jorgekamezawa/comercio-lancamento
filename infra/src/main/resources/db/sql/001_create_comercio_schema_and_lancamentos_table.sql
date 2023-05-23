CREATE SCHEMA comercio;

CREATE TABLE comercio.lancamentos (
	id uuid NOT NULL,
	valor numeric(38, 2) NOT NULL,
	tipo_pagamento varchar(255) NOT NULL,
	CONSTRAINT lancamentos_pkey PRIMARY KEY (id)
);