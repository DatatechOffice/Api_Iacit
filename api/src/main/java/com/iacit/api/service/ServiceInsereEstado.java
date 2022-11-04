package com.iacit.api.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.EstadoRepository;

@Service
public class ServiceInsereEstado {
	
	@Autowired
	EstadoRepository estadoRepository;
	ServiceInsereRegiao serviceInsereRegiao;

	private ArrayList<String> tabela;

	public ServiceInsereEstado(ArrayList<String> tabela) {
		this.tabela = tabela;
	}

	public void insBancoService(ArrayList<String> tabela) {
		//fazer lógica do zero pois a que estava aqui não estava ajudando
		//if tabela indice contém regiao == ? e uf == ? no mesmo indice, logo pesquisar qual o id da regiao e com o Id em mãos inserir o estado
	}
}

