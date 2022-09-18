package com.iacit.api.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class filtro {
	
	private String est_nome_estacao;
	private String est_codigo;
	private String tem_data_hora;
}
