
package com.iacit.api.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTemperatura {
	
	@Autowired(required=true) 
	private TemperaturaRepository temperaturaRepository;
	
	private String A;
	private String B;

	StringBuilder toJSON(List<Temperatura> enviarTemperatura) {
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		for (Temperatura d : enviarTemperatura) {
			sb.append(gson.toJson(d));
		}
		System.out.println(sb);
		
		return sb;
	}

	// tipo da função deve ser TemperaturaRepository
	public TemperaturaRepository serviceTEntity(String A, String B) {

		ServiceTemperatura RespT = new ServiceTemperatura();
		
		List<Temperatura> enviarTemperatura = temperaturaRepository.listar("A001", Timestamp.valueOf(A), Timestamp.valueOf(B));
		
		System.out.println(RespT.toJSON(enviarTemperatura));
		
		//return repository;

		return temperaturaRepository;
	}

}
