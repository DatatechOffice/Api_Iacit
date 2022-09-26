
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
	
	@Autowired(required = true)
	private TemperaturaRepository temperaturaRepository;
	
	public ServiceTemperatura(TemperaturaRepository temperaturaRepository) {
		this.temperaturaRepository=temperaturaRepository;
	}
	List<Temperatura> enviarTemperatura = temperaturaRepository.listar("A001", Timestamp.valueOf("2020-01-01 00:00:00"));
	
	StringBuilder toJSON(List<Temperatura> enviarTemperatura) {
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		for (Temperatura d : enviarTemperatura) {
			sb.append(gson.toJson(d));
		}
		return sb;
	}
	
	public static void Main(String []args) {
		ServiceTemperatura serviceTemperatura = new ServiceTemperatura(null);
		List<Temperatura> enviarTemperatura = temperaturaRepository.listar("A001", Timestamp.valueOf("2020-01-01 00:00:00"));
		
		serviceTemperatura.toJSON(enviarTemperatura);
	}

}
