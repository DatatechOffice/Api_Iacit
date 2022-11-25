package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.TemperaturaOrvalho;
import com.iacit.api.repository.TemperaturaOrvalhoRepository;

@Service
public class ServiceTemperaturaOrvalho {
	@Autowired(required=true) 
	private TemperaturaOrvalhoRepository orvalhoRepository;
	
	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	public List<TemperaturaOrvalho> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {
		
		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);
		
		List<TemperaturaOrvalho> entidades = orvalhoRepository.findByest_codigoAndTOrv_data_hora(
			idEstacao.getEstCodigo(),
			Timestamp.valueOf(dataInicial+" 00:00:00"),
			Timestamp.valueOf(dataFinal+" 00:00:00")
		);
		return entidades;
	}

	public void insBancoService(
		ArrayList<String> listaEstacaoCodigo,
		ArrayList<String> estTdata, 
		ArrayList<String> estToPontoOrvalho, 
		ArrayList<String> estToOrvalhoMax, 
		ArrayList<String> estToOrvalhoMin
	) {
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estPoOrvalho = estToPontoOrvalho.get(i);
			String estOrvalhoMax = estToOrvalhoMax.get(i);
			String estOrvalhoMin = estToOrvalhoMin.get(i);
			String codigo = listaEstacaoCodigo.get(i);
			
			if (estPoOrvalho.isEmpty() || estOrvalhoMax.isEmpty() || estOrvalhoMin.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				TemperaturaOrvalho temperaturaOrvalho = new TemperaturaOrvalho(estacao, Timestamp.valueOf(estData_+":00"), BigDecimal.valueOf(Float.parseFloat(estPoOrvalho)),
				BigDecimal.valueOf(Float.parseFloat(estOrvalhoMax)), BigDecimal.valueOf(Float.parseFloat(estOrvalhoMin)));
				orvalhoRepository.save(temperaturaOrvalho);
			}
		}
	}
}
