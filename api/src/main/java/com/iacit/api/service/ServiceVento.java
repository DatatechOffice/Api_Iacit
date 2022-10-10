package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iacit.api.entity.Vento;
import com.iacit.api.repository.VentoRepository;

@Service
public class ServiceVento {
	@Autowired(required=true) 
	private VentoRepository ventoRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<Vento> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		List<Vento> entidades = ventoRepository.findByest_codigoAndven_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}


}
