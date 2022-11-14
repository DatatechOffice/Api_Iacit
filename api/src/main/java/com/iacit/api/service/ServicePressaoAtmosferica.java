package com.iacit.api.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.repository.PressaoAtmosfericaRepository;

@Service
public class ServicePressaoAtmosferica {
	@Autowired(required=true) 
	private PressaoAtmosfericaRepository atmosfericaRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<PressaoAtmosferica> getByFilter(String dataInicial, String dataFinal) throws ParseException {

		List<PressaoAtmosferica> entidades = atmosfericaRepository.findByest_codigoAndpra_data_hora("A001", Timestamp.valueOf(dataInicial+" 00:00:00"), Timestamp.valueOf(dataFinal+" 00:00:00"));
		
		return entidades;
	}
	
	public void insBancoService(ArrayList<String> listaEstacaoCodigo, ArrayList<String> estTdata, ArrayList<String> estPrAtMax,
			ArrayList<String> estPrAtMin, ArrayList<String> estPrAtNivelEst) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = estTdata.size();
		for (int i = 1; i < ii; i++) {
			String estData = estTdata.get(i);
			String estPrMax = estPrAtMax.get(i);
			String estPrMin = estPrAtMin.get(i);
			String estPrNEst = estPrAtNivelEst.get(i);
			String codigo = listaEstacaoCodigo.get(i);
			if (estPrAtMax.isEmpty() || estPrAtMin.isEmpty() || estPrAtNivelEst.isEmpty()) {
				continue;
			} else {
				String estData_ = estData.replace("/", "-");
				Estacao estacao = new Estacao(codigo);
				PressaoAtmosferica pressaoAtmosferica = new PressaoAtmosferica(estacao, Timestamp.valueOf(estData_+":00"), BigDecimal.valueOf(Float.parseFloat(estPrMax)),
						BigDecimal.valueOf(Float.parseFloat(estPrMin)), BigDecimal.valueOf(Float.parseFloat(estPrNEst)));
//				System.out.println(estBulbo + estMax + estMin);
				atmosfericaRepository.save(pressaoAtmosferica);

			}
		}
	}


}
