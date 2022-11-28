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
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;
import com.opencsv.CSVWriter;

@Service
public class ServiceTemperatura {
	@Autowired(required = true)
	private TemperaturaRepository temperaturaRepository;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	public List<Temperatura> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {

		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);

		List<Temperatura> entidades = temperaturaRepository.findByest_codigoAndtem_data_hora(idEstacao.getEstCodigo(),
				Timestamp.valueOf(dataInicial + " 00:00:00"), Timestamp.valueOf(dataFinal + " 00:00:00"));
		return entidades;
	}

	public void temperaturaCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo,
			ArrayList<String> valorMaximoTemperatura, ArrayList<String> valorMinimoTemperatura,
			ArrayList<String> valorTemperatura) throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\temperatura.csv"));
		CSVWriter csvWriter = new CSVWriter(writer);
		List<String[]> jorgin = new ArrayList<String[]>();
		int ii = datas.size();
		for (int i = 0; i < ii; i++) {
			if (valorMaximoTemperatura.get(i).isEmpty() || valorMinimoTemperatura.get(i).isEmpty()
					|| valorTemperatura.get(i).isEmpty()) {
				continue;
			} else {
				String[] jorge = { datas.get(i), valorMaximoTemperatura.get(i), valorMinimoTemperatura.get(i),
						valorTemperatura.get(i), estacaoCodigo.get(i) };
				jorgin.add(jorge);
			}
		}
		csvWriter.writeAll(jorgin);
		csvWriter.flush();
		writer.close();

		temperaturaRepository.copyTemperatura();
	}
}
