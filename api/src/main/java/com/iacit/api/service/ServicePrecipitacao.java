package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Precipitacao;
import com.iacit.api.repository.PrecipitacaoRepository;

@Service
public class ServicePrecipitacao {

	@Autowired(required=true) 
	private PrecipitacaoRepository precipitacaoRepository;

	public List<Precipitacao> getByFilter(String dataInicial, String dataFinal) throws ParseException {
		
		List<Precipitacao> entidades = precipitacaoRepository.findByest_codigoAndrag_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}
	
	public void insBancoService(ArrayList<String> listaEstacaoCodigo, ArrayList<String> estTdata, ArrayList<String> estPrecipitacao) {
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String codigo = listaEstacaoCodigo.get(i);
			String estData = estTdata.get(i);
			String estPrec = estPrecipitacao.get(i);
	
			if (estPrec.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				Precipitacao precipitacao = new Precipitacao(estacao, Timestamp.valueOf(estData_+":00"), BigDecimal.valueOf(Float.parseFloat(estPrec)));
				precipitacaoRepository.save(precipitacao);

			}
		}
	}

}
