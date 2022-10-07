
package com.iacit.api.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTemperatura {

	@Autowired(required=true) 
	private TemperaturaRepository temperaturaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<Temperatura> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
		//List<Temperatura> entidades = temperaturaRepository.listar("A001", formatter.parse(dataInicial));
		List<Temperatura> entidades = temperaturaRepository.listar("A001", Timestamp.valueOf(dataInicial));
		
		return entidades;
	}

}
