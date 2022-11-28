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
import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.repository.PressaoAtmosfericaRepository;
import com.opencsv.CSVWriter;

@Service
public class ServicePressaoAtmosferica {
	@Autowired(required = true)
	private PressaoAtmosfericaRepository atmosfericaRepository;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	// tipo da função deve ser TemperaturaRepository
	public List<PressaoAtmosferica> getByFilter(String estacao, String dataInicial, String dataFinal)
			throws ParseException {

		Estacao idEstacao = serviceEstacao.selectEstacaoCodigo(estacao);

		List<PressaoAtmosferica> entidades = atmosfericaRepository.findByest_codigoAndpra_data_hora(
				idEstacao.getEstCodigo(), Timestamp.valueOf(dataInicial + " 00:00:00"),
				Timestamp.valueOf(dataFinal + " 00:00:00"));
		return entidades;
	}

	public void pressaoAtmosfericaCopy(ArrayList<String> datas, ArrayList<String> estacaoCodigo,
			ArrayList<String> valorMaximoPressao, ArrayList<String> valorMinimoPressao, ArrayList<String> valorPressao)
			throws IOException {

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\pressao_atmosferica.csv"));
		CSVWriter csvWriter = new CSVWriter(writer);
		List<String[]> jorgin = new ArrayList<String[]>();
		int ii = datas.size();
		for (int i = 0; i < ii; i++) {
			if (valorMaximoPressao.get(i).isEmpty() || valorMinimoPressao.get(i).isEmpty()
					|| valorPressao.get(i).isEmpty()) {
				continue;
			} else {
				String[] jorge = { datas.get(i), valorMaximoPressao.get(i), valorMinimoPressao.get(i),
						valorPressao.get(i), estacaoCodigo.get(i) };
				jorgin.add(jorge);
			}
		}
		csvWriter.writeAll(jorgin);
		csvWriter.flush();
		writer.close();

		atmosfericaRepository.copyPressaoAtmosferica();
	}
}
