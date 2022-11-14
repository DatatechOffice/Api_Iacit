package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
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
	
	public void insBancoService(ArrayList<String> listaEstacaoCodigo, ArrayList<String> estTdata, ArrayList<String> estVentoDirHor, ArrayList<String> estVentoRajMax, 
			ArrayList<String> estVentoVelHor) {

		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estVenDirHor = estVentoDirHor.get(i);
			String estVenRajMax = estVentoRajMax.get(i);
			String estVenVelHor = estVentoVelHor.get(i);
			String codigo = listaEstacaoCodigo.get(i);
			if (estVenDirHor.isEmpty() || estVenRajMax.isEmpty() || estVenVelHor.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				Vento vento = new Vento(estacao, Timestamp.valueOf(estData_+":00"), BigDecimal.valueOf(Float.parseFloat(estVenDirHor)),
						BigDecimal.valueOf(Float.parseFloat(estVenRajMax)), BigDecimal.valueOf(Float.parseFloat(estVenVelHor)));

				ventoRepository.save(vento);

			}
		}
	} 


}
