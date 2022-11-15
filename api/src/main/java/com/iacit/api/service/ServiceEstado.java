package com.iacit.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.EstadoRepository;

@Service
public class ServiceEstado {
	@Autowired(required = true)
	EstadoRepository estadoRepository;

	@Autowired
	ServiceRegiao serviceRegiao;

	public List<Estado> selectEstado() {
		List<Estado> etdLista = estadoRepository.selectEstado();
		return etdLista;
	}
	public Estado returnEstado(String etd) {
		Estado etdId = estadoRepository.selectBySigla(etd);
		return etdId;
	}
	public void insBancoService(ArrayList<String> listaRegiao, ArrayList<String> listaEstado) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = listaEstado.size();
		for (int i = 1; i < ii; i++) {
			String estadoS = listaEstado.get(i);
			String regiaoS = listaRegiao.get(i);

			if (i - 1 >= 0 && listaEstado.get(i - 1) != estadoS) {
				Regiao regiao = new Regiao();
				regiao = serviceRegiao.returnRegiao(regiaoS);
				Estado estado = new Estado(regiao,estadoS);
				estadoRepository.save(estado);
			} else {
				continue;
			}
		}
	}
}
