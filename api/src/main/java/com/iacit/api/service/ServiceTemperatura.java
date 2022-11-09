package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTemperatura {

	@Autowired(required=true) 
	private TemperaturaRepository temperaturaRepository;
	
	private ArrayList<String> estTdata;
	
	private ArrayList<String> estTbulbo;
	
	private ArrayList<String> estTmax;
	
	private ArrayList<String> estTmin;

	// tipo da função deve ser TemperaturaRepository
	public List<Temperatura> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<Temperatura> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}
	
	public void insBancoService(ArrayList<String> estTdata, ArrayList<String> estTbulbo, ArrayList<String> estTmax, 
			ArrayList<String> estTmin) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estBulbo = estTbulbo.get(i);
			String estMax = estTmax.get(i);
			String estMin = estTmin.get(i);
			if (i - 1 >= 0 && estTdata.get(i - 1) != estData) {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao("A001");
				Temperatura temperatura = new Temperatura(estacao, Timestamp.valueOf(estData_+":00"), BigDecimal.valueOf(Float.parseFloat(estBulbo)),
						BigDecimal.valueOf(Float.parseFloat(estMax)), BigDecimal.valueOf(Float.parseFloat(estMin)));
				
				temperaturaRepository.save(temperatura);
				
			} else {
				continue;
			}
		}
	}

}
