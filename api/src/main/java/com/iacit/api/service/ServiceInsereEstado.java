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
		int ii = tabela.size();
		for (int i = 1; i < ii; i++) {
			String xx = tabela.get(i);
			// System.out.println(xx);
			if (i - 1 >= 0 && tabela.get(i - 1) != xx) {
				if(xx == "CO" && xx != null) {
					Estado estado = new Estado(serviceInsereRegiao.returnRegiao(xx),xx);
			        estadoRepository.save(estado);
				}
		        
				//List<Regiao> regioe = regiaoRepository.insertBySegSigla(xx);
			} else {
				continue;
			}
		}
	}
}

