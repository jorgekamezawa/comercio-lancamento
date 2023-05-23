DELETE FROM comercio.lancamentos;

ALTER TABLE comercio.lancamentos
ADD COLUMN created_at timestamp NOT NULL;