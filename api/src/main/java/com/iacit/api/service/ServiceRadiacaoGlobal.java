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
import com.iacit.api.entity.RadiacaoGlobal;
import com.iacit.api.repository.RadiacaoGlobalRepository;
import com.opencsv.CSVWriter;

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

	public void radiacaoCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo, ArrayList<String> valorRadiacao) throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\radiacao_global.csv"));
			CSVWriter csvWriter = new CSVWriter(writer);
			List<String[]> jorgin = new ArrayList<String[]>();
			int ii = datas.size();
			for (int i = 0; i < ii; i++) {
				if (valorRadiacao.get(i).isEmpty()) {
					continue;
				}else {
				String[] jorge = {datas.get(i), valorRadiacao.get(i), estacaoCodigo.get(i)};
				jorgin.add(jorge);
				}
			}
			csvWriter.writeAll(jorgin);
			csvWriter.flush();
			writer.close();	
			
			radiacaoRepository.copyRadiacaoGlobal();
	}
}
