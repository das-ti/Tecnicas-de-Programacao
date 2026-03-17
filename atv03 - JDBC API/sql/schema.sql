CREATE DATABASE fornecedores_db;

\c fornecedores_db

CREATE TABLE empresas (
    cnpj            VARCHAR(14)  PRIMARY KEY,
    razao_social    VARCHAR(255) NOT NULL,
    nome_fantasia   VARCHAR(255),
    logradouro      VARCHAR(255),
    municipio       VARCHAR(100),
    uf              CHAR(2),
    cep             VARCHAR(8),
    criado_em       TIMESTAMP DEFAULT NOW()
);

CREATE TABLE socios (
    id                  SERIAL       PRIMARY KEY,
    cnpj_empresa        VARCHAR(14)  NOT NULL,
    nome_socio          VARCHAR(255),
    cnpj_cpf_do_socio   VARCHAR(14),
    qualificacao_socio  VARCHAR(100),
    CONSTRAINT fk_empresa
        FOREIGN KEY (cnpj_empresa)
        REFERENCES empresas(cnpj)
        ON DELETE CASCADE
);
