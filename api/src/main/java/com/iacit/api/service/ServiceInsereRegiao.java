package com.iacit.api.service;

import java.util.List;

import com.iacit.api.ApiApplication;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.RegiaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class ServiceInsereRegiao{
	@Autowired(required=true) 
	private RegiaoRepository regiaoRepository;
	
	private Regiao regiaoCO;

	public ServiceInsereRegiao(Regiao regiaoCO) {
		this.regiaoCO=regiaoCO;
	}
	
	public List<Regiao> insBancoService(){
		System.out.println(regiaoCO.getRegSigla());
		
	List<Regiao> regiaos = regiaoRepository.insertBySegSigla(regiaoCO.getRegSigla());
	
	return regiaos;
	
	}


}
