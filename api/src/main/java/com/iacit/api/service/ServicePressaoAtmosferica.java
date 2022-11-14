package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.PressaoAtmosfericaRepository;
import com.iacit.api.repository.TemperaturaRepository;

@Service
public class ServicePressaoAtmosferica {
	@Autowired(required=true) 
	private PressaoAtmosfericaRepository atmosfericaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<PressaoAtmosferica> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		List<PressaoAtmosferica> entidades = atmosfericaRepository.findByest_codigoAndpra_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}


}
