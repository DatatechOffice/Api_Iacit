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
	ServiceInsereRegiao serviceInsereRegiao;

	private ArrayList<String> listaRegiao;

	private ArrayList<String> listaEstado;

	public ServiceInsereEstado(ArrayList<String> listaRegiao, ArrayList<String> listaEstado) {
		this.listaRegiao = listaRegiao;
		this.listaEstado = listaEstado;
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
