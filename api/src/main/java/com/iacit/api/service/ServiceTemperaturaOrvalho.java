package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.entity.TemperaturaOrvalho;
import com.iacit.api.repository.PressaoAtmosfericaMinimaRepository;
import com.iacit.api.repository.TemperaturaOrvalhoMaximaRepository;

@Service
public class ServiceTemperaturaOrvalho {
	@Autowired(required=true) 
	private TemperaturaOrvalhoMaximaRepository orvalhoRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<TemperaturaOrvalho> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		List<TemperaturaOrvalho> entidades = orvalhoRepository.findByest_codigoAndTOrv_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}


}
