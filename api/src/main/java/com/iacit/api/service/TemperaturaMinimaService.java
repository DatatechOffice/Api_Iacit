package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.TemperaturaMinima;
import com.iacit.api.repository.TemperaturaMinimaRepository;

@Service
public class TemperaturaMinimaService {

	@Autowired(required=true) 
	private TemperaturaMinimaRepository temperaturaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<TemperaturaMinima> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<TemperaturaMinima> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}

}
