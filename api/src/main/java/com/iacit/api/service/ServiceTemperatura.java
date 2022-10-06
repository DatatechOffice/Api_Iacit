
package com.iacit.api.service;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.apiIacit.DatatechApiIacit.entity.Temperatura;
import com.apiIacit.DatatechApiIacit.repository.TemperaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTemperatura {

	@Autowired(required=true) 
	private TemperaturaRepository temperaturaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<Temperatura> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		ServiceTemperatura RespT = new ServiceTemperatura();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Temperatura> entidades = temperaturaRepository.listar("A001", formatter.parse(dataInicial), formatter.parse(dataFinal));
		
		return entidades;
	}

}
