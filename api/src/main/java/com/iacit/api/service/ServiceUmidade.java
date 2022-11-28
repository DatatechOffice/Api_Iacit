package com.iacit.api.service;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Umidade;
import com.iacit.api.repository.UmidadeRepository;
import com.opencsv.CSVWriter;

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

	public void umidadeCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo, ArrayList<String> valorMaximoUmidade,
			ArrayList<String> valorMinimoUmidade, ArrayList<String> valorUmidade) throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\umidade.csv"));
			CSVWriter csvWriter = new CSVWriter(writer);
			List<String[]> jorgin = new ArrayList<String[]>();
			int ii = datas.size();
			for (int i = 0; i < ii; i++) {
				if (valorMaximoUmidade.get(i).isEmpty()||valorMinimoUmidade.get(i).isEmpty()||valorUmidade.get(i).isEmpty()) {
					continue;
				}else {
				String[] jorge = {datas.get(i), valorMaximoUmidade.get(i), valorMinimoUmidade.get(i), valorUmidade.get(i), estacaoCodigo.get(i)};
				jorgin.add(jorge);
				}
			}
			csvWriter.writeAll(jorgin);
			csvWriter.flush();
			writer.close();	
			
			umidadeRepository.copyUmidade();
	}
}
