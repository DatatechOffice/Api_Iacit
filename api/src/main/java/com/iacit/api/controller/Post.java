package com.iacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Post {
Timestamp datainicio;
Timestamp datafim;
String regiao;
String estacao;
String dado;
List<String> regioes;
List<String> dados;

public Post() {
}



public Post(Timestamp datainicio, Timestamp datafim, String regiao, String estacao, String dado, List<String> regioes,
		List<String> dados) {
	super();
	this.datainicio = datainicio;
	this.datafim = datafim;
	this.regiao = regiao;
	this.estacao = estacao;
	this.dado = dado;
	this.regioes = regioes;
	this.dados = dados;
}



public Timestamp getDatainicio() {
	return datainicio;
}

public void setDatainicio(Timestamp datainicio) {
	this.datainicio = datainicio;
}

public Timestamp getDatafim() {
	return datafim;
}

public void setDatafim(Timestamp datafim) {
	this.datafim = datafim;
}

public String getRegiao() {
	return regiao;
}

public void setRegiao(String regiao) {
	this.regiao = regiao;
}

public String getDado() {
	return dado;
}

public void setDado(String dado) {
	this.dado = dado;
}

public List<String> getRegioes() {
	return regioes;
}

public void setRegioes(List<String> regioes) {
	this.regioes = regioes;
}

public List<String> getDados() {
	return dados;
}

public void setDados(List<String> dados) {
	this.dados = dados;
}

public String getEstacao() {
	return estacao;
}

public void setEstacao(String estacao) {
	this.estacao = estacao;
}


}
