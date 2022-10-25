package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.TemperaturaOrvalhoMaxima;
import com.iacit.api.repository.TemperaturaOrvalhoMaximaRepository;

@Service
public class TemperaturaOrvalhoMaximaService {

	@Autowired(required=true) 
	private TemperaturaOrvalhoMaximaRepository temperaturaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<TemperaturaOrvalhoMaxima> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<TemperaturaOrvalhoMaxima> entidades = temperaturaRepository.findByest_codigoAndTOrv_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}

}
