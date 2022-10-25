package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.TemperaturaArBulboSeco;
import com.iacit.api.repository.TemperaturaArBulboSecoRepository;

@Service
public class TemperaturaArBulboSecoService {

	@Autowired(required=true) 
	private TemperaturaArBulboSecoRepository temperaturaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<TemperaturaArBulboSeco> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<TemperaturaArBulboSeco> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}

}
