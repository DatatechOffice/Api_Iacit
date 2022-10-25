package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iacit.api.entity.RadiacaoGlobal;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.RadiacaoGlobalRepository;
import com.iacit.api.repository.TemperaturaMaximaRepository;

@Service
public class ServiceRadiacaoGlobal {

	@Autowired(required=true) 
	private RadiacaoGlobalRepository radiacaoRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<RadiacaoGlobal> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<RadiacaoGlobal> entidades = radiacaoRepository.findByest_codigoAndrag_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}

}

/*
if variavel.index(1) != null
junção
else 
*/