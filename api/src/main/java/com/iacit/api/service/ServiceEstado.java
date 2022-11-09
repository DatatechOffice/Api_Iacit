package com.iacit.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estado;
import com.iacit.api.repository.EstadoRepository;

@Service
public class ServiceEstado {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	ServiceRegiao serviceInsereRegiao;

	private ArrayList<String> listaRegiao;

	private ArrayList<String> listaEstado;

	public ServiceEstado(ArrayList<String> listaRegiao, ArrayList<String> listaEstado) {
		this.listaRegiao = listaRegiao;
		this.listaEstado = listaEstado;
	}
	
	public List<Estado> selectEstado() {
		List<Estado> etdLista = estadoRepository.selectEstado();
		return etdLista;
	}

	public void insBancoService(ArrayList<String> listaRegiao, ArrayList<String> listaEstado) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = listaEstado.size();
		for (int i = 1; i < ii; i++) {
			String estadoS = listaEstado.get(i);
			if (i - 1 >= 0 && listaEstado.get(i - 1) != estadoS) {
				Estado estado = new Estado(estadoS);
		        estadoRepository.save(estado);
			} else {
				continue;
			}
		}
	}
}
