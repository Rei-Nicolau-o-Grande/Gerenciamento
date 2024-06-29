CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    departamento_id BIGINT,

    CONSTRAINT fk_departamento FOREIGN KEY (departamento_id)
    REFERENCES departamentos(id) ON DELETE SET NULL
);