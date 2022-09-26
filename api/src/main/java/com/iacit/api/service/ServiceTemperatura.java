
package com.iacit.api.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTemperatura {
	
	@Autowired(required = true)

	private TemperaturaRepository temperatura;
	
	ArrayList<Temperatura> enviarTemperatura = temperatura.listar("A001", Timestamp.valueOf("2020-01-01 00:00:00"));
	
	public ServiceTemperatura(ArrayList<Temperatura> enviarTemperatura) {
		this.enviarTemperatura=enviarTemperatura;
	}
	
	
	StringBuilder toJSON(ArrayList<Temperatura> enviarTemperatura) {
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		for (Temperatura d : enviarTemperatura) {
			sb.append(gson.toJson(d));
		}
		return sb;
	}

}
