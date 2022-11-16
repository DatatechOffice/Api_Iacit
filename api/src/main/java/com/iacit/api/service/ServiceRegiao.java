package com.iacit.api.service;

import java.util.ArrayList;
import java.util.List;

import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.RegiaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegiao {
	@Autowired(required = true)
	private RegiaoRepository regiaoRepository;

	public Regiao returnRegiao(String reg) {
		Regiao regid = regiaoRepository.selectBySegSigla(reg);
		return regid;
	}

	public List<Regiao> selectRegiao() {
		List<Regiao> regLista = regiaoRepository.selectRegiao();
		return regLista;
	}

	public void insBancoService(ArrayList<String> tabela) {
		int ii = tabela.size();
		for (int i = 1; i < ii; i++) {
			String regiaoS = tabela.get(i);
			if (i - 1 >= 0 && tabela.get(i - 1) != regiaoS) {
				Regiao regiao = new Regiao(regiaoS);
				regiaoRepository.save(regiao);
			} else {
				continue;
			}
		}
	}
}
