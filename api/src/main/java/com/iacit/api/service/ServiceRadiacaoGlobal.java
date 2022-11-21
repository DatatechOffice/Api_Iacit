package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.RadiacaoGlobal;
import com.iacit.api.repository.RadiacaoGlobalRepository;

@Service
public class ServiceRadiacaoGlobal {
	@Autowired(required=true) 
	private RadiacaoGlobalRepository radiacaoRepository;
	
	@Autowired(required=true) 
	private ServiceEstacao serviceEstacao;
	
	public List<RadiacaoGlobal> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {
		
		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);
		
		List<RadiacaoGlobal> entidades = radiacaoRepository.findByest_codigoAndrag_data_hora(
			idEstacao.getEstCodigo(), 
			Timestamp.valueOf(dataInicial+" 00:00:00"), 
			Timestamp.valueOf(dataFinal+" 00:00:00")
		);
		return entidades;
	}

	public void insBancoService(
		ArrayList<String> listaEstacaoCodigo, ArrayList<String> estTdata, ArrayList<String> estRadiacaoGlobal
	) {
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estRadGlobal = estRadiacaoGlobal.get(i);
			String codigo = listaEstacaoCodigo.get(i);
			if (estRadGlobal.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				RadiacaoGlobal radiacaoGlobal = new RadiacaoGlobal(
					estacao, 
					Timestamp.valueOf(estData_+":00"), 
					BigDecimal.valueOf(Float.parseFloat(estRadGlobal))
				);
				radiacaoRepository.save(radiacaoGlobal);
			}
		}
	}
}
