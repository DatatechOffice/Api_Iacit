package com.iacit.api.controller;

import lombok.Data;

@Data
public class FilterDataVo {
	String dataInicio;
	String dataFim;
	String regiao;
	String estado;
	String variavel;
}
