package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.TemperaturaMaxima;
import com.iacit.api.repository.TemperaturaMaximaRepository;

@Service
public class TemperaturaMaximaService {

	@Autowired(required=true) 
	private TemperaturaMaximaRepository temperaturaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<TemperaturaMaxima> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<TemperaturaMaxima> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}

}
