package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Umidade;
import com.iacit.api.repository.UmidadeRepository;

@Service
public class ServiceUmidade {
	@Autowired(required=true) 
	private UmidadeRepository umidadeRepository;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;
	
	public List<Umidade> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {
		
		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);
		
		List<Umidade> entidades = umidadeRepository.findByest_codigoAndumi_data_hora(
			idEstacao.getEstCodigo(), 
			Timestamp.valueOf(dataInicial+" 00:00:00"), 
			Timestamp.valueOf(dataFinal+" 00:00:00")
		);
		return entidades;
	}

	public void insBancoService(
		ArrayList<String> listaEstacaoCodigo, 
		ArrayList<String> estTdata, 
		ArrayList<String> estUmiRelAr, 
		ArrayList<String> estUmiRelMax, 
		ArrayList<String> estUmiRelMin
	) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estURelAr = estUmiRelAr.get(i);
			String estURelMax = estUmiRelMax.get(i);
			String estURelMin = estUmiRelMin.get(i);
			String codigo = listaEstacaoCodigo.get(i);

			if (estURelAr.isEmpty() || estURelMax.isEmpty() || estURelMin.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				Umidade umidade = new Umidade(
					estacao, Timestamp.valueOf(estData_+":00"), 
					BigDecimal.valueOf(Float.parseFloat(estURelAr)),
					BigDecimal.valueOf(Float.parseFloat(estURelMax)), 
					BigDecimal.valueOf(Float.parseFloat(estURelMin))
				);
				umidadeRepository.save(umidade);
			}
		}
	}
}
