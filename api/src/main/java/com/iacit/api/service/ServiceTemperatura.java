
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
		
		List<Temperatura> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}

}
