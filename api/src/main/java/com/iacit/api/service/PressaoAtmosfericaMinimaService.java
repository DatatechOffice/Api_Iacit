package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.PressaoAtmosfericaMinima;
import com.iacit.api.repository.PressaoAtmosfericaMinimaRepository;

@Service
public class PressaoAtmosfericaMinimaService {
	@Autowired(required=true) 
	private PressaoAtmosfericaMinimaRepository atmosfericaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<PressaoAtmosfericaMinima> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		List<PressaoAtmosfericaMinima> entidades = atmosfericaRepository.findByest_codigoAndpra_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}


}

