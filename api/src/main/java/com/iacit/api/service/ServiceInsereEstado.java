package com.iacit.api.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.EstadoRepository;
import com.iacit.api.repository.RegiaoRepository;

@Service
public class ServiceInsereEstado {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired 
	RegiaoRepository regiaoRepository;
	
	@Autowired
	ServiceInsereRegiao serviceInsereRegiao;

	private ArrayList<String> listaRegiao;
	
	private ArrayList<String> listaEstado;

	public ServiceInsereEstado(ArrayList<String> listaRegiao, ArrayList<String> listaEstado) {
		this.listaRegiao = listaRegiao;
		this.listaEstado= listaEstado;
	}

	public void insBancoService(ArrayList<String> listaRegiao, ArrayList<String> listaEstado) {
		//fazer lógica do zero pois a que estava aqui não estava ajudando
		//if tabela indice contém regiao == ? e uf == ? no mesmo indice, logo pesquisar qual o id da regiao e com o Id em mãos inserir o estado
		int ii = listaRegiao.size();
		for (int i = 1; i < ii; i++) {
			String regiaoS = listaRegiao.get(i);
			// System.out.println(xx);
			if (i - 1 >= 0 && listaRegiao.get(i - 1) != regiaoS) {
		        //Regiao regiao = new Regiao(regiaoS);
		        
			} else {
				int iii = listaEstado.size();
				for (int il = 1; i < iii; il++) {
					String estadoS = listaEstado.get(il);
					if (il - 1 >= 0 && listaRegiao.get(il - 1) != regiaoS) {
				        
				Regiao regiao;
				regiao = regiaoRepository.selectBySegSigla(regiaoS);
				Estado estado = new Estado(regiao, estadoS);
				
				System.out.println(estado.getEtdUnidadeFederativa()+"\n"+estado.getRegId());
				//estadoRepository.save(estado);
				continue;
			}
		}
	}
		}
	}
}

