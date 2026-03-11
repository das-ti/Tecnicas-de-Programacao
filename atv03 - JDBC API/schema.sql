CREATE TABLE empresas (
    cnpj          VARCHAR(14)  PRIMARY KEY,
    razao_social  VARCHAR(200) NOT NULL,
    nome_fantasia VARCHAR(200),
    logradouro    VARCHAR(200)
);

CREATE TABLE socios (
    id           SERIAL PRIMARY KEY,
    cnpj_empresa VARCHAR(14) NOT NULL,
    nome         VARCHAR(200) NOT NULL,

    FOREIGN KEY (cnpj_empresa) REFERENCES empresas(cnpj)
);