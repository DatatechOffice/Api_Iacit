package com.iacit.api.service;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Precipitacao;
import com.iacit.api.repository.PrecipitacaoRepository;
import com.opencsv.CSVWriter;

@Service
public class ServicePrecipitacao {

	@Autowired(required = true)
	private PrecipitacaoRepository precipitacaoRepository;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	public List<Precipitacao> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {

		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);

		List<Precipitacao> entidades = precipitacaoRepository.findByest_codigoAndrag_data_hora(idEstacao.getEstCodigo(),
				Timestamp.valueOf(dataInicial + " 00:00:00"), Timestamp.valueOf(dataFinal + " 00:00:00"));
		return entidades;
	}

	public void precipitacaoCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo,
			ArrayList<String> valorPrecipitacao) throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\precipitacao.csv"));
		CSVWriter csvWriter = new CSVWriter(writer);
		List<String[]> jorgin = new ArrayList<String[]>();
		int ii = datas.size();
		for (int i = 0; i < ii; i++) {
			if (valorPrecipitacao.get(i).isEmpty()) {
				continue;
			} else {
				String[] jorge = { datas.get(i), valorPrecipitacao.get(i), estacaoCodigo.get(i) };
				jorgin.add(jorge);
			}
		}
		csvWriter.writeAll(jorgin);
		csvWriter.flush();
		writer.close();

		precipitacaoRepository.copyPrecipitacao();
	}
}
