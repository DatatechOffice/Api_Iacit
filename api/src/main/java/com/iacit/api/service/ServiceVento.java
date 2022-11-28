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
import com.iacit.api.entity.Vento;
import com.iacit.api.repository.VentoRepository;
import com.opencsv.CSVWriter;

@Service
public class ServiceVento {
	@Autowired(required = true)
	private VentoRepository ventoRepository;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	public List<Vento> getByFilter(String estacao, String dataInicial, String dataFinal) throws ParseException {

		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);

		List<Vento> entidades = ventoRepository.findByest_codigoAndven_data_hora(idEstacao.getEstCodigo(),
				Timestamp.valueOf(dataInicial + " 00:00:00"), Timestamp.valueOf(dataFinal + " 00:00:00"));
		return entidades;
	}

	public void ventoCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo, ArrayList<String> valorMaximoVento,
			ArrayList<String> valorMinimoVento, ArrayList<String> valorVento) throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\vento.csv"));
		CSVWriter csvWriter = new CSVWriter(writer);
		List<String[]> csv = new ArrayList<String[]>();
		int ii = datas.size();
		for (int i = 0; i < ii; i++) {
			if (valorMaximoVento.get(i).isEmpty() || valorMinimoVento.get(i).isEmpty() || valorVento.get(i).isEmpty()) {
				continue;
			} else {
				String[] csvLinha = { datas.get(i), valorMaximoVento.get(i), valorMinimoVento.get(i), valorVento.get(i),
						estacaoCodigo.get(i) };
				csv.add(csvLinha);
			}
		}
		csvWriter.writeAll(csv);
		csvWriter.flush();
		writer.close();

		ventoRepository.copyVento();
	}
}
