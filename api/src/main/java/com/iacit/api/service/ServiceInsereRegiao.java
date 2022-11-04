package com.iacit.api.service;

import java.util.ArrayList;
import java.util.List;

import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.RegiaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class ServiceInsereRegiao {

	@Autowired(required = true)
	private RegiaoRepository regiaoRepository;

	private ArrayList<String> regis;

	public ServiceInsereRegiao(ArrayList<String> regis) {
		this.regis = regis;
	}

	public void insBancoService(ArrayList<String> regis) {
		int ii = regis.size();
		for (int i = 1; i < ii; i++) {
			String xx = regis.get(i);
			// System.out.println(xx);
			if (i - 1 >= 0 && regis.get(i - 1) != xx) {
		        Regiao regiao = new Regiao(xx);
		        regiaoRepository.save(regiao);
				//List<Regiao> regioe = regiaoRepository.insertBySegSigla(xx);
			} else {
				continue;
			}

		}
	}
}
