CREATE TABLE estado_e_regiao (
  	eer_id SERIAL PRIMARY KEY,
	eer_regiao VARCHAR(2),
	eer_unidade_federativa VARCHAR(2)
);

CREATE TABLE estacao (
	est_codigo VARCHAR(5) PRIMARY KEY,
	est_nome_estacao VARCHAR(30),
	est_longitude FLOAT,
  	est_latitude FLOAT,
  	est_altitude FLOAT,
 	est_data_fundacao VARCHAR(10),
  	eer_id INTEGER,
	FOREIGN KEY (eer_id) REFERENCES estado_e_regiao (eer_id)
);

CREATE TABLE temperatura (
	tem_id SERIAL PRIMARY KEY,
	tem_data VARCHAR(10),
	tem_max NUMERIC,
 	tem_min NUMERIC,
  	tem_hora VARCHAR(8),
  	tem_ar_bulbo_seco NUMERIC,
  	est_codigo VARCHAR(4),
	FOREIGN KEY (est_codigo) REFERENCES estacao (est_codigo)
);
