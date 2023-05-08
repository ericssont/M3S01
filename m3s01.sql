CREATE TABLE despesas (
  id_despesas bigserial PRIMARY KEY,
  credor varchar(100) NOT NULL,
  data_vencimento date NOT NULL,
  data_pagamento date DEFAULT NULL,
  valor double precision NOT NULL,
  descricao varchar(200) DEFAULT NULL,
  status varchar(20) NOT NULL DEFAULT 'Pendente'
)