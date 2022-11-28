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
import com.iacit.api.entity.TemperaturaOrvalho;
import com.iacit.api.repository.TemperaturaOrvalhoRepository;
import com.opencsv.CSVWriter;

@Service
public class ServiceTemperaturaOrvalho {
	@Autowired(required = true)
	private TemperaturaOrvalhoRepository orvalhoRepository;
	
	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	public List<TemperaturaOrvalho> getByFilter(String estacao, String dataInicial, String dataFinal)
			throws ParseException {

		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);

		List<TemperaturaOrvalho> entidades = orvalhoRepository.findByest_codigoAndTOrv_data_hora(
				idEstacao.getEstCodigo(), Timestamp.valueOf(dataInicial + " 00:00:00"),
				Timestamp.valueOf(dataFinal + " 00:00:00"));
		return entidades;
	}

	public void temperaturaOrvalhoCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo,
			ArrayList<String> valorMaximoOrvalho, ArrayList<String> valorMinimoOrvalho, ArrayList<String> valorOrvalho)
			throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\temperaturaOrvalho.csv"));
		CSVWriter csvWriter = new CSVWriter(writer);
		List<String[]> jorgin = new ArrayList<String[]>();
		int ii = datas.size();
		for (int i = 0; i < ii; i++) {
			if (valorMaximoOrvalho.get(i).isEmpty() || valorMinimoOrvalho.get(i).isEmpty()
					|| valorOrvalho.get(i).isEmpty()) {
				continue;
			} else {
				String[] jorge = { datas.get(i), valorMaximoOrvalho.get(i), valorMinimoOrvalho.get(i),
						valorOrvalho.get(i), estacaoCodigo.get(i) };
				jorgin.add(jorge);
			}
		}
		csvWriter.writeAll(jorgin);
		csvWriter.flush();
		writer.close();

		orvalhoRepository.copyTemperaturaOrvalho();
	}
}
