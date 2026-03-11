CREATE TABLE tb_tarefas(
id 			 SERIAL PRIMARY KEY,
titulo       VARCHAR(40) NOT NULL,
descricao    VARCHAR(200),
categoria    VARCHAR(20)  NOT NULL,
prioridade   VARCHAR(10)  NOT NULL DEFAULT 'MEDIA',
status       VARCHAR(20)  NOT NULL DEFAULT 'PENDENTE',
data_criacao TIMESTAMP NOT NULL DEFAULT NOW()
)



