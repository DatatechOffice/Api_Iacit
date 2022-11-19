package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;

@Service
public class ServiceTemperatura {
	@Autowired(required=true) 
	private TemperaturaRepository temperaturaRepository;
	
	@Autowired(required=true) 
	private ServiceEstacao serviceEstacao;
	
	public List<Temperatura> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {	
		
		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);
		
		List<Temperatura> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora(
			idEstacao.getEstCodigo(),
			Timestamp.valueOf(dataInicial+" 00:00:00"), 
			Timestamp.valueOf(dataFinal+" 00:00:00")
		);
		return entidades;
	}

	public void insBancoService(
		ArrayList<String> listaEstacaoCodigo, 
		ArrayList<String> estTdata, 
		ArrayList<String> estTbulbo, 
		ArrayList<String> estTmax, 
		ArrayList<String> estTmin) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estBulbo = estTbulbo.get(i);
			String estMax = estTmax.get(i);
			String estMin = estTmin.get(i);
			String codigo = listaEstacaoCodigo.get(i);
			if (estBulbo.isEmpty() || estMax.isEmpty() || estMin.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				Temperatura temperatura = new Temperatura(
					estacao, Timestamp.valueOf(estData_+":00"), 
					BigDecimal.valueOf(Float.parseFloat(estBulbo)),
					BigDecimal.valueOf(Float.parseFloat(estMax)), 
					BigDecimal.valueOf(Float.parseFloat(estMin))
				);
				//System.out.println(estBulbo + estMax + estMin);
				temperaturaRepository.save(temperatura);
			}
		}
	}
}
