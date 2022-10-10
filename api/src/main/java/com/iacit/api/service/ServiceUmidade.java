package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iacit.api.entity.Umidade;
import com.iacit.api.repository.UmidadeRepository;

@Service
public class ServiceUmidade {
	@Autowired(required=true) 
	private UmidadeRepository umidadeRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<Umidade> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		List<Umidade> entidades = umidadeRepository.findByest_codigoAndumi_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}
}
